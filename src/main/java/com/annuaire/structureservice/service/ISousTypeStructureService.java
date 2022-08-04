package com.annuaire.structureservice.service;

import com.annuaire.structureservice.dto.SousTypeStructureDto;
import com.annuaire.structureservice.model.SousTypeStructure;
import com.annuaire.structureservice.model.TypeStructure;

import java.util.List;

/**
 * @author karim hmadi

 * @description interface service sous type structure

 */
public interface ISousTypeStructureService {
    SousTypeStructure saveSousTypeStructure(SousTypeStructureDto soustypestructureDto);
    List<SousTypeStructure> findAllSousTypeStructures();
    List<SousTypeStructure> findSousTypeStructureByType(String id);
    SousTypeStructure findSousTypeStructureById(String id);
    SousTypeStructure updateSousTypeStructure(String id, SousTypeStructure sousTypeStructureReq);
    Boolean deleteSousTypeStructure(String id);
}
