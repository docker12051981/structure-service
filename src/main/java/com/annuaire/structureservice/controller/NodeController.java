package com.annuaire.structureservice.controller;

import com.annuaire.structureservice.object.StructureNode;
import com.annuaire.structureservice.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author karim hmadi

 * @description recursiv structure controllor

 */
@CrossOrigin(origins = "*")
@RestController
public class NodeController {
    @Autowired
    NodeService nodeService;
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/structures/node/{treeId}")
    public ResponseEntity<StructureNode> getFullTree(@PathVariable("treeId") int treeId) {
        return ResponseEntity.ok(nodeService.getFullTree(treeId));
    }
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/structures/node/{treeId}/st/{nodeId}")
    public ResponseEntity<StructureNode> getSubtree(@PathVariable("treeId") int treeId, @PathVariable("nodeId") int nodeId) {
        return ResponseEntity.ok(nodeService.getSubTree(treeId, nodeId, null));
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/structures/node/{treeId}/{nodeId}")
    public ResponseEntity<Void> deleteNodes(@PathVariable("treeId") int treeId, @PathVariable("nodeId") int nodeId) {
        nodeService.deleteNodes(treeId, nodeId);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/structures/node/")
    public ResponseEntity<Void> create(@RequestBody StructureNode treeNode) {
        nodeService.create(treeNode);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin(origins = "*")
    @PutMapping(value = "/structures/node/{treeId}/{nodeId}")
    public ResponseEntity<Void> move(@PathVariable("treeId") int treeId, @PathVariable("nodeId") int nodeId,
                                     @RequestParam int newParentNodeId) {
        nodeService.move(treeId, nodeId , newParentNodeId);
        return ResponseEntity.ok().build();
    }

}
