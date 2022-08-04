package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.model.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description repository implement for param (ignored but can used after)

 */
public interface ParamGraphLookupRepository {
    Optional<List<Param>> getSubTree(int treeId, int nodeId, Long maxDepth);
}
