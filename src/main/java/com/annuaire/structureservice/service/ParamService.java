package com.annuaire.structureservice.service;

import com.annuaire.structureservice.object.ParamNode;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author karim hmadi

 * @description interface param service (ignored but can used after for generique param)

 */
public interface ParamService {

    int DEFAULT_ROOT_NODE_ID = -1;

    ParamNode getFullTree(int treeId);

    ParamNode getSubTree(int treeId, int nodeId, Long maxDepth);

    void deleteNodes(int treeId, int nodeId);

    void create(ParamNode treeNode);

    void move(int treeId, int nodeId, int newParentNodeId);

    static ParamNode assembleTree(final List<ParamNode> nodes, final int rootNodeId) {
        final Map<Integer, ParamNode> mapTmp = new LinkedHashMap<>();
        // Save all nodes to a map
        for (final ParamNode current : nodes) {
            mapTmp.put(current.getNodeId(), current);
        }
        // Loop and assign parent/child relationships
        for (final ParamNode current : nodes) {
            final List<Integer> parents = current.getParentId();

            if (!CollectionUtils.isEmpty(parents)) {
                for (final Integer pid : parents) {
                    final ParamNode parent = mapTmp.get(pid);
                    if (parent != null) {
                        parent.addChild(current);
                        current.addParent(parent);
                    }
                }
            }
        }
        return mapTmp.get(rootNodeId);
    }

}
