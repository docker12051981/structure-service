package com.annuaire.structureservice.controller;
import com.annuaire.structureservice.dto.CustomStructureDto;

import com.annuaire.structureservice.dto.StructureDto;

import com.annuaire.structureservice.model.CustomStructure;

import com.annuaire.structureservice.model.Structure;
import com.annuaire.structureservice.repository.ParamRepository;
import com.annuaire.structureservice.service.IStructureService;

import com.annuaire.structureservice.service.SequenceGenerator;

import com.annuaire.structureservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author karim hmadi

 * @description structure controllor

 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/structures")
public class StructureController {

    private IStructureService structureService;
    public StructureController(IStructureService structureService) {
        super();
        this.structureService = structureService;
    }

    @Autowired
    private ParamRepository paramRepository;

    @Autowired
    private SequenceGenerator service;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public ResponseEntity<StructureDto> createStructure(@RequestBody StructureDto structureDto)
    {
        StructureDto str= converter.entityToDto(structureService.saveStructure(structureDto));
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/gouvernorat/{gouvernorat}")
    public ResponseEntity<List<StructureDto>> findByGouvernorat(@PathVariable String gouvernorat)
    {
        List<Structure> findstructurebygouvernorat= structureService.findStructureByGouvernorat(gouvernorat);
        return new ResponseEntity<List<StructureDto>>(converter.entityToDto(findstructurebygouvernorat), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<StructureDto> getStructureById(@PathVariable(name = "id") String id) {
        Structure structure= structureService.findStructureById(id);
        // convert entity to DTO
        StructureDto structureResponse = converter.entityToDto(structure);
        return ResponseEntity.ok().body(structureResponse);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/key/organisme/{key}")
    public ResponseEntity<CustomStructureDto> getStructureByOrganisme(@PathVariable(name = "key") Integer key) {
        CustomStructure customstructure= structureService.findStructureByCustom(key);
        // convert entity to DTO
        CustomStructureDto customstructureResponse = converter.customentityToDto(customstructure);
        return ResponseEntity.ok().body(customstructureResponse);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStructure(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
          deleted = structureService.deleteStructure(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<List<StructureDto>> findAll() {
        List<Structure> findAll = structureService.findAllStructures();
        return new ResponseEntity<List<StructureDto>>(converter.entityToDto(findAll), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/parent/{id}")
    public ResponseEntity<List<StructureDto>> findAllByparent(@PathVariable String id) {
        List<Structure> findByParent = structureService.findStructuresByParent(id);
        return new ResponseEntity<List<StructureDto>>(converter.entityToDto(findByParent), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/nodeId/{id}")
    public ResponseEntity<StructureDto> getStructureByKey(@PathVariable(name = "id") Integer id) {
        Structure structure= structureService.findStructureByKey(id);
        // convert entity to DTO
        StructureDto structureResponse = converter.entityToDto(structure);
        return ResponseEntity.ok().body(structureResponse);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<StructureDto> updateStructure(@PathVariable String id, @RequestBody StructureDto structureDto) {
        // convert DTO to Entity
        Structure structureRequest = converter.dtoToEntity(structureDto);
        Structure structure = structureService.updateStructure(id, structureRequest);
        // entity to DTO
        StructureDto structureResponse = converter.entityToDto(structure);
        return ResponseEntity.ok().body(structureResponse);
    }

/*
    @PostMapping("/saveparams/")
    public Param save(@RequestBody Param param)
    {
        if(!param.getName().isEmpty()) {
            param.setTreeId(service.getSequenceNumber(SEQUENCE_NAME));
            return paramRepository.save(param);
        }
        else
        {
            return param;
        }
    }

    @GetMapping("/params")
    public List<Param> getparams()
    {
        return paramRepository.findAll();
    }
*/
}
