package com.annuaire.structureservice.controller;
import com.annuaire.structureservice.dto.SousTypeStructureDto;
import com.annuaire.structureservice.model.SousTypeStructure;
import com.annuaire.structureservice.service.SousTypeStructureService;
import com.annuaire.structureservice.tools.Converter;
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

 * @description sous type structure controllor

 */
@CrossOrigin(origins = "*")
@RestController
public class SousTypeStructureController {
    private static final Logger logger = LoggerFactory.getLogger(SousTypeStructureController.class);
    @Autowired
    SousTypeStructureService soustypestructureService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/structures/sous-type/add/")
    public ResponseEntity<SousTypeStructureDto> createSousTypeStructure(@RequestBody SousTypeStructureDto soustypestructureDto) {
        logger.info("Methode createSousTypeStructure(): before : soustypestructureDto : {} ", soustypestructureDto);
        SousTypeStructureDto soustypestr = converter.soustypeentityToDto(soustypestructureService.saveSousTypeStructure(soustypestructureDto));
        logger.info("Methode createSousTypeStructure(): after : soustypestructureDto : {} ", soustypestr);
        return new ResponseEntity<>(soustypestr, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structures/sous-type/all")
    public ResponseEntity<List<SousTypeStructureDto>> findAll() {
        List<SousTypeStructure> listsoustypestruct = soustypestructureService.findAllSousTypeStructures();
        logger.info("Methode findAll(): after : soustypestructureDto : {} ", converter.soustypeentityToDto(listsoustypestruct));
        return new ResponseEntity<List<SousTypeStructureDto>>(converter.soustypeentityToDto(listsoustypestruct), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structures/sous-type/{id}")
    public ResponseEntity<SousTypeStructureDto> findSousTypeStructureById(@PathVariable(name = "id") String id) {
        SousTypeStructure soustypestructure = soustypestructureService.findSousTypeStructureById(id);
        // convert entity to DTO
        SousTypeStructureDto soustypestructureResponse = converter.soustypeentityToDto(soustypestructure);
        logger.info("Methode findSousTypeStructureById(): after : soustypestructureResponse : {} ", soustypestructureResponse);
        return ResponseEntity.ok().body(soustypestructureResponse);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structures/sous-type/type/{id}")
    public ResponseEntity <List<SousTypeStructureDto>> findSousTypeStructureByType(@PathVariable(name = "id") String id) {
        List<SousTypeStructure> soustypestructure = soustypestructureService.findSousTypeStructureByType(id);
        // convert entity to DTO
        List<SousTypeStructureDto> soustypestructureResponse = converter.soustypeentityToDto(soustypestructure);
        logger.info("Methode findSousTypeStructureByType(): after : soustypestructureResponse : {} ", soustypestructureResponse);
        return ResponseEntity.ok().body(soustypestructureResponse);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/structures/sous-type/update/{id}")
    public ResponseEntity<SousTypeStructureDto> updateSousTypeStructure(@PathVariable String id, @RequestBody SousTypeStructureDto sousTypeStructureDto) {
        // convert DTO to Entity
        logger.info("Methode updateSousTypeStructure(): before : SousTypestructureDto : {} ", sousTypeStructureDto);
        SousTypeStructure soustypestructureRequest = converter.soustypedtoToEntity(sousTypeStructureDto);
        SousTypeStructure soustypestructure = soustypestructureService.updateSousTypeStructure(id, soustypestructureRequest);
        // entity to DTO
        SousTypeStructureDto soustypestructureResponse = converter.soustypeentityToDto(soustypestructure);
        logger.info("Methode updateSousTypeStructure(): after : soustypestructureResponse : {} ", soustypestructureResponse);
        return ResponseEntity.ok().body(soustypestructureResponse);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/structures/sous-type/delete/{id}")
    public ResponseEntity<Boolean> deleteSousTypeStructure(@PathVariable String id) {
        Boolean deleted = false;
        if (id != null) {
            deleted = soustypestructureService.deleteSousTypeStructure(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);

    }
}