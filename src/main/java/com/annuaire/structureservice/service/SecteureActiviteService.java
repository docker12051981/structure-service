package com.annuaire.structureservice.service;
import com.annuaire.structureservice.dto.SecteureactiviteDto;
import com.annuaire.structureservice.model.Secteureactivite;
import com.annuaire.structureservice.repository.ISecteureActiviteRepository;
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

 * @description implement service secteur activitie

 */
@Service
public class SecteureActiviteService implements ISecteureActiviteService{
    private final ISecteureActiviteRepository secteureActiviteRepository;
    public SecteureActiviteService(ISecteureActiviteRepository secteureActiviteRepository) {
        super();
        this.secteureActiviteRepository = secteureActiviteRepository;
    }

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Secteureactivite saveSecteureActivite(SecteureactiviteDto secteureactiviteDto)
    {
        Secteureactivite secteureactivite = converter.secteuredtoToEntity(secteureactiviteDto);
        secteureactivite.setCreateTime(LocalDateTime.now());
        //StructureDto str= converter.entityToDto(structure);
        return secteureActiviteRepository.save(secteureactivite);
    }

    @Override
    public List<Secteureactivite> findAllSecteurActivite()
    {
        return secteureActiviteRepository.findAll();
    }

    @Override
    public Secteureactivite findSecteurActiviteById(String id) {
        Optional<Secteureactivite> result = secteureActiviteRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Secteureactivite", "id", id);
        }
    }

    @Override
    public Secteureactivite updateSecteureActivite(String id, Secteureactivite secteureActiviteRequest) {
        Secteureactivite secteureactivite = secteureActiviteRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("SecteureActivite", "id", id));
        secteureactivite.setCode(secteureActiviteRequest.getCode());
        secteureactivite.setLib_fr(secteureActiviteRequest.getLib_fr());
        secteureactivite.setLib_ar(secteureActiviteRequest.getLib_ar());
        secteureactivite.setUpdateTime(LocalDateTime.now());
        secteureactivite.setUpdatedBy(secteureActiviteRequest.getUpdatedBy());
        return secteureActiviteRepository.save(secteureactivite);
    }

    @Override
    public Boolean deleteSecteureActivite(String id) {
        secteureActiviteRepository.deleteById(id);
        return true;
    }

}
