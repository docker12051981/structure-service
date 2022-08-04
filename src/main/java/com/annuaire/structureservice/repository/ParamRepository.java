package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.model.Node;
import com.annuaire.structureservice.model.Param;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description repository param (ignored but can used after for generique param)

 */
public interface ParamRepository extends MongoRepository<Param, Object>, ParamGraphLookupRepository {
    Optional<List<Param>> findDistinctByTreeId(int treeId);
    Optional<Param> findDistinctByTreeIdAndNodeId(int treeId, int nodeId);
}
