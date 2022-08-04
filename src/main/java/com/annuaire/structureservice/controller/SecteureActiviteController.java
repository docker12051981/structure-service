package com.annuaire.structureservice.controller;

import com.annuaire.structureservice.dto.SecteureactiviteDto;
import com.annuaire.structureservice.dto.TypeStructureDto;
import com.annuaire.structureservice.model.Secteureactivite;
import com.annuaire.structureservice.service.SecteureActiviteService;
import com.annuaire.structureservice.tools.Converter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author karim hmadi

 * @description secteur activité controllor

 */

@RestController
@Slf4j
public class SecteureActiviteController {
    private static final Logger logger = LoggerFactory.getLogger(SecteureActiviteController.class);
    @Autowired
    SecteureActiviteService secteureActiviteService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/structures/secteureactivite/add/")
    public ResponseEntity<SecteureactiviteDto> createSecteureActivite(@RequestBody SecteureactiviteDto secteuractiviteDto)
    {
        logger.info("Methode createSecteureActivite(): before : secteuractiviteDto : {} ", secteuractiviteDto);
        SecteureactiviteDto secteuractivite= converter.secteurentityToDto(secteureActiviteService.saveSecteureActivite(secteuractiviteDto));
        logger.info("Methode createSecteureActivite(): after : secteuractiviteDto : {} ", secteuractivite);
        return new ResponseEntity<>(secteuractivite, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structures/secteureactivite/all")
    public ResponseEntity<List<SecteureactiviteDto>> findAll() {

        List<Secteureactivite> listsecteuractivite = secteureActiviteService.findAllSecteurActivite();
        logger.info("Methode findAll(): after : SecteuractiviteDto : {} ", converter.secteurentityToDto(listsecteuractivite));
        return new ResponseEntity<List<SecteureactiviteDto>>(converter.secteurentityToDto(listsecteuractivite), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structures/secteureactivite/{id}")
    public ResponseEntity<SecteureactiviteDto> findSecteurActiviteById(@PathVariable(name = "id") String id) {
        Secteureactivite secteuractivite= secteureActiviteService.findSecteurActiviteById(id);
        // convert entity to DTO
        SecteureactiviteDto secteuractiviteResponse = converter.secteurentityToDto(secteuractivite);
        logger.info("Methode findSecteurActiviteById(): after : secteuractiviteResponse : {} ", secteuractiviteResponse);
        return ResponseEntity.ok().body(secteuractiviteResponse);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/structures/secteureactivite/update/{id}")
    public ResponseEntity<SecteureactiviteDto> updateSecteureActivite(@PathVariable String id, @RequestBody SecteureactiviteDto secteuractiviteDto) {
        // convert DTO to Entity
        logger.info("Methode updateSecteureActivite(): before : SecteuractiviteDto : {} ", secteuractiviteDto);
        Secteureactivite secteuractiviteRequest = converter.secteuredtoToEntity(secteuractiviteDto);
        Secteureactivite secteuractivite = secteureActiviteService.updateSecteureActivite(id, secteuractiviteRequest);
        // entity to DTO
        SecteureactiviteDto secteureactiviteResponse = converter.secteurentityToDto(secteuractivite);
        logger.info("Methode updateSecteureActivite(): after : secteureactiviteResponse : {} ", secteureactiviteResponse);
        return ResponseEntity.ok().body(secteureactiviteResponse);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/structures/secteureactivite/delete/{id}")
    public ResponseEntity<Boolean> deleteSecteureActivite(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = secteureActiviteService.deleteSecteureActivite(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
