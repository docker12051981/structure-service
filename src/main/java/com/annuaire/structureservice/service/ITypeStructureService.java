package com.annuaire.structureservice.service;

import com.annuaire.structureservice.dto.TypeStructureDto;
import com.annuaire.structureservice.model.TypeStructure;

import java.util.List;

/**
 * @author karim hmadi

 * @description interface service type structure

 */
public interface ITypeStructureService {
    TypeStructure saveTypeStructure(TypeStructureDto typestructureDto);
    List<TypeStructure> findAllTypeStructures();
    TypeStructure findTypeStructureById(String id);
    TypeStructure updateTypeStructure(String id, TypeStructure structureRequest);
    Boolean deleteTypeStructure(String id);
}
