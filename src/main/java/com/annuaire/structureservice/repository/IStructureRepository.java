package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.dto.StructureDto;
import com.annuaire.structureservice.model.CustomStructure;
import com.annuaire.structureservice.model.Structure;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description repository for structure

 */
@Repository
public interface IStructureRepository extends MongoRepository<Structure,String> {
    Optional<Structure> findById(String id);
    Optional<Structure> findByKey(Integer id);
    List<Structure> findByParent(String id);

    @Query(value="{ 'adresse.gouvernorat.lib_fr': ?0 }, Fields: null, Sort: null")
    List<Structure> findByGouvernoratfrAsCustom(String gouvernorat);

    @Query(value="{ 'key' : ?0 }",fields="{ 'id' : 1, 'key' : 1, 'title' : 1, 'abr_fr' : 1}")
    CustomStructure findStructureAsCustom(Integer key);

}
