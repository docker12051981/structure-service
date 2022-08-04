package com.annuaire.structureservice.service;

import com.annuaire.structureservice.controller.SecteureActiviteController;
import com.annuaire.structureservice.exception.NotFoundException;
import com.annuaire.structureservice.model.Node;

import com.annuaire.structureservice.object.StructureNode;
import com.annuaire.structureservice.repository.NodeRepository;

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

 * @description implement service node structure for recursivity

 */
@Service
public class NodeServiceImpl implements NodeService{

    private static final Logger logger = LoggerFactory.getLogger(SecteureActiviteController.class);
    private final NodeRepository nodeRepository;
    public NodeServiceImpl(NodeRepository  nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public StructureNode getFullTree(int treeId) {
        List<Node> nodes = nodeRepository.findDistinctByTreeId(treeId).orElseThrow(NotFoundException::new);
        /*List<Node> nodes = nodeRepository.findByTreeId(treeId).orElseThrow(NotFoundException::new);*/
        List<StructureNode> structureNodes = new ArrayList<>();
        for (Node node : nodes) {
            StructureNode structureNode = new StructureNode();
            BeanUtils.copyProperties(node, structureNode, "children");

            structureNodes.add(structureNode);
        }

        return NodeService.assembleTree(structureNodes, NodeService.DEFAULT_ROOT_NODE_ID);
    }

    @Override
    @Transactional(readOnly = true)
    public StructureNode getSubTree(int treeId, int nodeId, Long maxDepth) {
        List<Node> nodes = nodeRepository.getSubTree(treeId, nodeId, null).orElseThrow(NotFoundException::new);

        List<StructureNode> flatList = nodes.stream()
                .map(Node::getDescendants)
                .flatMap(Collection::stream)
                .map(node -> {
                    StructureNode tr = new StructureNode();
                    BeanUtils.copyProperties(node, tr);
                    return tr;
                })
                .collect(Collectors.toList());

        StructureNode root = new StructureNode();
        BeanUtils.copyProperties(nodes.get(0), root, "id", "children");
        flatList.add(root);

        return (NodeService.assembleTree(flatList, nodeId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteNodes(int treeId, int nodeId)  {
        // ... perform validations etc.
        List<Node> nodes = nodeRepository.getSubTree(treeId, nodeId, 1L).orElseThrow(NotFoundException::new);
        var target = nodes.get(0);
        if (!CollectionUtils.isEmpty(target.getDescendants())) {
            target.getDescendants().forEach(n -> n.setParentId(target.getParentId()));
            nodeRepository.saveAll(target.getDescendants());
        }
        nodeRepository.delete(target);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(StructureNode structureNode) {
        // ... check if parent exists etc.
        Node node = new Node();

        node.setTreeId(structureNode.getTreeId());
        node.setParentId(structureNode.getParentId());
        node.setTitle(structureNode.getTitle());
        node.setName(structureNode.getTitle());
        node.setLib_ar(structureNode.getLib_ar());
        node.setDescription_fr(structureNode.getDescription_fr());
        node.setDescription_ar(structureNode.getDescription_ar());
        node.setAbr_fr(structureNode.getAbr_fr());
        node.setAbr_ar(structureNode.getAbr_ar());
        node.setLogo(structureNode.getLogo());
        node.setType(structureNode.getType());
        node.setSoustype(structureNode.getSoustype());
        node.setSecteur(structureNode.getSecteur());
        node.setAdresse(structureNode.getAdresse());
        node.setContact(structureNode.getContact());
        node.setStatus(structureNode.getStatus());
        node.setCreatedBy(structureNode.getCreatedBy());
        node.setKey(new Random().nextInt()); // set a unique nodeId based on your policy
        if(structureNode.getOrgId() == 0)
        {
            node.setOrgId(node.getKey());
        }
        else if (structureNode.getOrgId()!=0)
        {
            node.setOrgId(structureNode.getOrgId());
        }
        logger.info("Methode createparam(): before : create : {} ", node.getKey());
        logger.info("Methode createparam(): after : create : {} ", structureNode.getTreeId());
        nodeRepository.save(node);
        // iterate children and persist them as well...
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void move(int treeId, int nodeId, int newParentNodeId) {
        // ... perform validations etc.
        var node = nodeRepository.findDistinctByTreeIdAndKey(treeId, nodeId).orElseThrow(NotFoundException::new);
        node.setParentId(List.of(newParentNodeId));
       nodeRepository.save(node);
    }


}
