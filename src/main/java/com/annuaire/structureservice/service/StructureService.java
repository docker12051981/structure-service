package com.annuaire.structureservice.service;

import com.annuaire.structureservice.dto.StructureDto;

import com.annuaire.structureservice.model.CustomStructure;
import com.annuaire.structureservice.model.Structure;

import com.annuaire.structureservice.repository.IStructureRepository;
import com.annuaire.structureservice.tools.Converter;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;


import static com.annuaire.structureservice.model.Param.SEQUENCE_NAME;

/**
 * @author karim hmadi

 * @description implement service structure

 */
@Service
public class StructureService implements IStructureService{

    private final IStructureRepository structureRepository;
    public StructureService(IStructureRepository structureRepository) {
        super();
        this.structureRepository = structureRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @Autowired
    private SequenceGenerator service;
    @Override
    public Structure saveStructure(StructureDto structureDto)
    {
        Structure structure = converter.dtoToEntity(structureDto);
        structure.setCreateTime(LocalDateTime.now());
        structure.setUpdateTime(null);
        if(structure.getParent()==null) {
            structure.setTree(service.getSequenceNumber(SEQUENCE_NAME));
        }
        //StructureDto str= converter.entityToDto(structure);
        return structureRepository.save(structure);
    }

    @Override
    public List<Structure> findStructureByGouvernorat(String gouvernoratfr)
    {
        return structureRepository.findByGouvernoratfrAsCustom(gouvernoratfr);
    }


    @Override
    public CustomStructure findStructureByCustom(Integer key)
    {
        return structureRepository.findStructureAsCustom(key);
    }

    @Override
    public Structure findStructureById(String id) {
        Optional<Structure> result = structureRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Structure", "id", id);
        }

    }


    @Override
    public Structure findStructureByKey(Integer id) {
        Optional<Structure> result = structureRepository.findByKey(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Structure", "key", "invalid key");
        }
    }


    @Override
    public List<Structure> findStructuresByParent(String id)
    {
        return structureRepository.findByParent(id);
    }

    @Override
    public Boolean deleteStructure(String id) {
        structureRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Structure> findAllStructures()
    {
        return structureRepository.findAll();
    }


    @Override
    public Structure updateStructure(String id, Structure structureRequest) {
        Structure structure = structureRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("Structure", "id", id));

        structure.setParent(structureRequest.getParent());
        structure.setTitle(structureRequest.getTitle());
        structure.setLib_ar(structureRequest.getLib_ar());
        structure.setAbr_fr(structureRequest.getAbr_fr());
        structure.setAbr_ar(structureRequest.getAbr_ar());
        structure.setLogo(structureRequest.getLogo());
        structure.setDescription_fr(structureRequest.getDescription_fr());
        structure.setDescription_ar(structureRequest.getDescription_ar());
        structure.setStatus(structureRequest.getStatus());
        structure.setType(structureRequest.getType());
        structure.setSoustype(structureRequest.getSoustype());
        structure.setSecteur(structureRequest.getSecteur());
        structure.setUpdateTime(LocalDateTime.now());
        structure.setUpdatedBy(structureRequest.getUpdatedBy());
        structure.setContact(structureRequest.getContact());
        structure.setAdresse(structureRequest.getAdresse());

        return structureRepository.save(structure);
    }

}
