package com.annuaire.structureservice.controller;
import com.annuaire.structureservice.dto.StructureDto;
import com.annuaire.structureservice.dto.TypeStructureDto;
import com.annuaire.structureservice.model.Structure;
import com.annuaire.structureservice.model.TypeStructure;
import com.annuaire.structureservice.service.ITypeStructureService;
import com.annuaire.structureservice.service.TypeStructureService;
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

 * @description type structure controllor

 */
@CrossOrigin(origins = "*")
@Slf4j
@RestController
public class TypeStructureController {
    private static final Logger logger = LoggerFactory.getLogger(TypeStructureController.class);
    @Autowired
    TypeStructureService typestructureService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/structures/type/add/")
    public ResponseEntity<TypeStructureDto> createTypeStructure(@RequestBody TypeStructureDto typestructureDto)
    {
        logger.info("Methode createTypeStructure(): before : typestructureDto : {} ", typestructureDto);
        TypeStructureDto typestr= converter.typeentityToDto(typestructureService.saveTypeStructure(typestructureDto));
        logger.info("Methode createTypeStructure(): after : typestructureDto : {} ", typestr);
        return new ResponseEntity<>(typestr, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structures/type/all")
    public ResponseEntity<List<TypeStructureDto>> findAll() {

        List<TypeStructure> listtypestruct = typestructureService.findAllTypeStructures();
        logger.info("Methode findAll(): after : typestructureDto : {} ", converter.typeentityToDto(listtypestruct));
        return new ResponseEntity<List<TypeStructureDto>>(converter.typeentityToDto(listtypestruct), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structures/type/{id}")
    public ResponseEntity<TypeStructureDto> findTypeStructureById(@PathVariable(name = "id") String id) {
        TypeStructure typestructure= typestructureService.findTypeStructureById(id);
        // convert entity to DTO
        TypeStructureDto typestructureResponse = converter.typeentityToDto(typestructure);
        logger.info("Methode findTypeStructureById(): after : typestructureResponse : {} ", typestructureResponse);
        return ResponseEntity.ok().body(typestructureResponse);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/structures/type/update/{id}")
    public ResponseEntity<TypeStructureDto> updateTypeStructure(@PathVariable String id, @RequestBody TypeStructureDto TypestructureDto) {
        // convert DTO to Entity
        logger.info("Methode updateTypeStructure(): before : TypestructureDto : {} ", TypestructureDto);
        TypeStructure typestructureRequest = converter.typedtoToEntity(TypestructureDto);
        TypeStructure typestructure = typestructureService.updateTypeStructure(id, typestructureRequest);
        // entity to DTO
        TypeStructureDto typestructureResponse = converter.typeentityToDto(typestructure);
        logger.info("Methode updateTypeStructure(): after : typestructureResponse : {} ", typestructureResponse);
        return ResponseEntity.ok().body(typestructureResponse);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/structures/type/delete/{id}")
    public ResponseEntity<Boolean> deleteTypeStructure(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = typestructureService.deleteTypeStructure(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
