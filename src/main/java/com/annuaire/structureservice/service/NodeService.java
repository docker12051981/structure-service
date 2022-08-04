package com.annuaire.structureservice.service;
import com.annuaire.structureservice.object.StructureNode;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @author karim hmadi

 * @description interface service node structure (for recursive)

 */
public interface NodeService {

    int DEFAULT_ROOT_NODE_ID = -1;

    StructureNode getFullTree(int treeId);

    StructureNode getSubTree(int treeId, int nodeId, Long maxDepth);

    void deleteNodes(int treeId, int nodeId);

    void create(StructureNode treeNode);

    void move(int treeId, int nodeId, int newParentNodeId);

    static StructureNode assembleTree(final List<StructureNode> nodes, final int rootNodeId) {
        final Map<Integer, StructureNode> mapTmp = new LinkedHashMap<>();
        // Save all nodes to a map
        for (final StructureNode current : nodes) {
            mapTmp.put(current.getKey(), current);
        }
        // Loop and assign parent/child relationships
        for (final StructureNode current : nodes) {
            final List<Integer> parents = current.getParentId();

            if (!CollectionUtils.isEmpty(parents)) {
                for (final Integer pid : parents) {
                    final StructureNode parent = mapTmp.get(pid);
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
