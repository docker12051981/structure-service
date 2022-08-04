package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.model.Node;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description repository interface for node structure

 */
public interface NodeRepository extends MongoRepository<Node, Object>, NodeGraphLookupRepository {
    Optional<List<Node>> findDistinctByTreeId(int treeId);
    //Optional<List<Node>> findByTreeId(int treeId);
    Optional<Node> findDistinctByTreeIdAndKey(int treeId, int nodeId);
}
