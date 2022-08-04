package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.model.SousTypeStructure;
import com.annuaire.structureservice.model.TypeStructure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author karim hmadi

 * @description repository for soustype structure

 */
@Repository
public interface ISousTypeStructureRepository extends MongoRepository<SousTypeStructure,String> {
    @Query(value="{ typeId: ?0 }", fields="{ lib_fr: 1,lib_ar:1, _id: 1 }", sort="{ lib_fr: -1 }")
    List<SousTypeStructure> findByTypeAsCustom(String id);
}
