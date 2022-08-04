package com.annuaire.structureservice.service;

import com.annuaire.structureservice.controller.SecteureActiviteController;
import com.annuaire.structureservice.exception.NotFoundException;
import com.annuaire.structureservice.model.Param;
import com.annuaire.structureservice.object.ParamNode;
import com.annuaire.structureservice.repository.ParamRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author karim hmadi

 * @description implement service param (ignored but can used after for generique param)

 */

@Slf4j
@Service
public class ParamServiceImpl implements ParamService{

    private static final Logger logger = LoggerFactory.getLogger(SecteureActiviteController.class);
    private final ParamRepository paramRepository;

    public ParamServiceImpl(ParamRepository paramRepository) {
        this.paramRepository = paramRepository;
    }

    @Override
    public ParamNode getFullTree(int treeId) {
        List<Param> nodes = paramRepository.findDistinctByTreeId(treeId).orElseThrow(NotFoundException::new);

        List<ParamNode> paramNodes = new ArrayList<>();
        for (Param param : nodes) {
            ParamNode paramNode = new ParamNode();
            BeanUtils.copyProperties(param, paramNode, "id", "children");

            paramNodes.add(paramNode);
        }

        return ParamService.assembleTree(paramNodes, ParamService.DEFAULT_ROOT_NODE_ID);
    }

    @Override
    @Transactional(readOnly = true)
    public ParamNode getSubTree(int treeId, int nodeId, Long maxDepth) {
        List<Param> params = paramRepository.getSubTree(treeId, nodeId, null).orElseThrow(NotFoundException::new);

        List<ParamNode> flatList = params.stream()
                .map(Param::getDescendants)
                .flatMap(Collection::stream)
                .map(node -> {
                    ParamNode tr = new ParamNode();
                    BeanUtils.copyProperties(node, tr, "id");
                    return tr;
                })
                .collect(Collectors.toList());

        ParamNode root = new ParamNode();
        BeanUtils.copyProperties(params.get(0), root, "id", "children");
        flatList.add(root);

        return (ParamService.assembleTree(flatList, nodeId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteNodes(int treeId, int nodeId)  {
        // ... perform validations etc.
        List<Param> nodes = paramRepository.getSubTree(treeId, nodeId, 1L).orElseThrow(NotFoundException::new);
        var target = nodes.get(0);
        if (!CollectionUtils.isEmpty(target.getDescendants())) {
            target.getDescendants().forEach(n -> n.setParentId(target.getParentId()));
            paramRepository.saveAll(target.getDescendants());
        }

        paramRepository.delete(target);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(ParamNode paramNode) {
        // ... check if parent exists etc.
        Param param = new Param();
        param.setTreeId(paramNode.getTreeId());
        param.setParentId(paramNode.getParentId());
        param.setName(paramNode.getName());
        param.setVal(paramNode.getVal());
        param.setNodeId(new Random().nextInt()); // set a unique nodeId based on your policy
        logger.info("Methode createparam(): before : create : {} ", param.getNodeId());
        logger.info("Methode createparam(): after : create : {} ", param);

        paramRepository.save(param);
        // iterate children and persist them as well...
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void move(int treeId, int nodeId, int newParentNodeId) {
        // ... perform validations etc.
        var param = paramRepository.findDistinctByTreeIdAndNodeId(treeId, nodeId).orElseThrow(NotFoundException::new);
        param.setParentId(List.of(newParentNodeId));
        paramRepository.save(param);
    }


}
