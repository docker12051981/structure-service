package com.annuaire.structureservice.controller;

import com.annuaire.structureservice.object.ParamNode;
import com.annuaire.structureservice.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author karim hmadi

 * @description ignored but can used after (générique param)

 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ParamController {

    @Autowired
    ParamService paramService;

    @GetMapping(value = "/structures/param/{treeId}")
    public ResponseEntity<ParamNode> getFullTree(@PathVariable("treeId") int treeId) {
        return ResponseEntity.ok(paramService.getFullTree(treeId));
    }

    @GetMapping(value = "/structures/param/{treeId}/st/{nodeId}")
    public ResponseEntity<ParamNode> getSubtree(@PathVariable("treeId") int treeId, @PathVariable("nodeId") int nodeId) {
        return ResponseEntity.ok(paramService.getSubTree(treeId, nodeId, null));
    }

    @DeleteMapping(value = "/structures/param/{treeId}/{nodeId}")
    public ResponseEntity<Void> deleteNodes(@PathVariable("treeId") int treeId, @PathVariable("nodeId") int nodeId) {
        paramService.deleteNodes(treeId, nodeId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/structures/param/")
    public ResponseEntity<Void> create(@RequestBody ParamNode paramNode) {
        paramService.create(paramNode);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/structures/param/{treeId}/{nodeId}")
    public ResponseEntity<Void> move(@PathVariable("treeId") int treeId, @PathVariable("nodeId") int nodeId, @RequestParam int newParentNodeId) {
        paramService.move(treeId, nodeId , newParentNodeId);
        return ResponseEntity.ok().build();
    }


}
