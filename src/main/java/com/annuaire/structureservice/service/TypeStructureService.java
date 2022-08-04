package com.annuaire.structureservice.service;

import com.annuaire.structureservice.dto.StructureDto;
import com.annuaire.structureservice.dto.TypeStructureDto;
import com.annuaire.structureservice.model.Structure;
import com.annuaire.structureservice.model.TypeStructure;
import com.annuaire.structureservice.repository.IStructureRepository;
import com.annuaire.structureservice.repository.ITypeStructureRepository;
import com.annuaire.structureservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description implement service type structure

 */

@Service
public class TypeStructureService implements ITypeStructureService{
    private final ITypeStructureRepository typeStructureRepository;
    public TypeStructureService(ITypeStructureRepository typeStructureRepository) {
        super();
        this.typeStructureRepository = typeStructureRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public TypeStructure saveTypeStructure(TypeStructureDto typeStructureDto)
    {
        TypeStructure typestructure = converter.typedtoToEntity(typeStructureDto);
        typestructure.setCreateTime(LocalDateTime.now());
        //StructureDto str= converter.entityToDto(structure);
        return typeStructureRepository.save(typestructure);
    }

    @Override
    public List<TypeStructure> findAllTypeStructures()
    {
        return typeStructureRepository.findAll();
    }

    @Override
    public TypeStructure findTypeStructureById(String id) {
        Optional<TypeStructure> result = typeStructureRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("TypeStructure", "id", id);
        }

    }

    @Override
    public TypeStructure updateTypeStructure(String id, TypeStructure structureRequest) {
        TypeStructure typestructure = typeStructureRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("TypeStructure", "id", id));


        typestructure.setLib_fr(structureRequest.getLib_fr());
        typestructure.setLib_ar(structureRequest.getLib_ar());
        typestructure.setIsorganisme(structureRequest.getIsorganisme());
        typestructure.setUpdateTime(LocalDateTime.now());
        typestructure.setUpdatedBy(structureRequest.getUpdatedBy());
        return typeStructureRepository.save(typestructure);
    }

    @Override
    public Boolean deleteTypeStructure(String id) {
        typeStructureRepository.deleteById(id);
        return true;
    }
}
