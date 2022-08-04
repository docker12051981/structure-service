package com.annuaire.structureservice.service;

import com.annuaire.structureservice.dto.SousTypeStructureDto;
import com.annuaire.structureservice.model.SousTypeStructure;
import com.annuaire.structureservice.model.Structure;
import com.annuaire.structureservice.repository.ISousTypeStructureRepository;
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
public class SousTypeStructureService implements ISousTypeStructureService {
    private final ISousTypeStructureRepository soustypeStructureRepository;
    public SousTypeStructureService(ISousTypeStructureRepository soustypeStructureRepository) {
        super();
        this.soustypeStructureRepository = soustypeStructureRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public SousTypeStructure saveSousTypeStructure(SousTypeStructureDto soustypeStructureDto)
    {
        SousTypeStructure soustypestructure = converter.soustypedtoToEntity(soustypeStructureDto);
        soustypestructure.setCreateTime(LocalDateTime.now());
        return soustypeStructureRepository.save(soustypestructure);
    }

    @Override
    public List<SousTypeStructure> findAllSousTypeStructures()
    {
        return soustypeStructureRepository.findAll();
    }

    @Override
    public SousTypeStructure findSousTypeStructureById(String id) {
        Optional<SousTypeStructure> result = soustypeStructureRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("SousTypeStructure", "id", id);
        }

    }

    @Override
    public SousTypeStructure updateSousTypeStructure(String id, SousTypeStructure sousTypeStructureReq) {
        SousTypeStructure soustypestructure = soustypeStructureRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("SousTypeStructure", "id", id));
        soustypestructure.setTypeId(sousTypeStructureReq.getTypeId());
        soustypestructure.setLib_fr(sousTypeStructureReq.getLib_fr());
        soustypestructure.setLib_ar(sousTypeStructureReq.getLib_ar());
        soustypestructure.setUpdateTime(LocalDateTime.now());
        soustypestructure.setUpdatedBy(sousTypeStructureReq.getUpdatedBy());
        return soustypeStructureRepository.save(soustypestructure);
    }

    @Override
    public Boolean deleteSousTypeStructure(String id) {
        soustypeStructureRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SousTypeStructure> findSousTypeStructureByType(String id)
    {
        return soustypeStructureRepository.findByTypeAsCustom(id);
    }

}
