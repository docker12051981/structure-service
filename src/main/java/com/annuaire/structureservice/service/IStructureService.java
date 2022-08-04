package com.annuaire.structureservice.service;

import com.annuaire.structureservice.dto.Request.StructureRequest;
import com.annuaire.structureservice.dto.StructureDto;
import com.annuaire.structureservice.dto.TypeStructureDto;
import com.annuaire.structureservice.model.CustomStructure;
import com.annuaire.structureservice.model.Structure;
import com.annuaire.structureservice.model.TypeStructure;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description interface service structure

 */
public interface IStructureService {
    Structure saveStructure(StructureDto structureDto);

    List<Structure> findStructureByGouvernorat(String gouvernorat);

    Structure findStructureById(String id);

    Structure findStructureByKey(Integer id);

    Boolean deleteStructure(String id);

    List<Structure> findAllStructures();

    Structure updateStructure(String id, Structure structureRequest);

    List<Structure> findStructuresByParent(String id);

    CustomStructure findStructureByCustom(Integer key);
}
