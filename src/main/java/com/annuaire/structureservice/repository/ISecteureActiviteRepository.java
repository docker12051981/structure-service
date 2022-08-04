package com.annuaire.structureservice.repository;

import com.annuaire.structureservice.model.Secteureactivite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author karim hmadi

 * @description repository for secteur activitie

 */
@Repository
public interface ISecteureActiviteRepository extends MongoRepository<Secteureactivite,String> {
}
