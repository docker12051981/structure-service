package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.model.TypeStructure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author karim hmadi

 * @description repository for type structure

 */
@Repository
public interface ITypeStructureRepository extends MongoRepository<TypeStructure,String> {
}
