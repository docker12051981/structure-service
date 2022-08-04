package com.annuaire.structureservice.tools;

import com.annuaire.structureservice.dto.*;
import com.annuaire.structureservice.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author karim hmadi

 * @description convert dto to entity and entity to dto

 */

@Component
public class Converter {

    public StructureDto entityToDto(Structure structure) {

        ModelMapper mapper =new ModelMapper();
        StructureDto map = mapper.map(structure, StructureDto.class);
        return map;

    }
    public List<StructureDto> entityToDto(List<Structure> structure) {

        return	structure.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }


    public Structure dtoToEntity(StructureDto structuredto) {

        ModelMapper mapper =new ModelMapper();
        Structure map = mapper.map(structuredto, Structure.class);
        return map;

    }
    public List<Structure> dtoToEntity(List<StructureDto> structuredto) {

        return	structuredto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }




    public CustomStructureDto customentityToDto(CustomStructure customstructure) {
        ModelMapper mapper =new ModelMapper();
        CustomStructureDto map = mapper.map(customstructure, CustomStructureDto.class);
        return map;
    }

    public List<CustomStructureDto> customentityToDto(List<CustomStructure> customstructure) {
        return	customstructure.stream().map(x -> customentityToDto(x)).collect(Collectors.toList());
    }


    public CustomStructure customdtoToEntity(CustomStructureDto customstructuredto) {
        ModelMapper mapper =new ModelMapper();
        CustomStructure map = mapper.map(customstructuredto, CustomStructure.class);
        return map;
    }

    public List<CustomStructure> customdtoToEntity(List<CustomStructureDto> customstructuredto) {
        return	customstructuredto.stream().map(x -> customdtoToEntity(x)).collect(Collectors.toList());
    }



    public TypeStructureDto typeentityToDto(TypeStructure typestructure) {
        ModelMapper mapper =new ModelMapper();
        TypeStructureDto map = mapper.map(typestructure, TypeStructureDto.class);
        return map;
    }
    public List<TypeStructureDto> typeentityToDto(List<TypeStructure> typestructure) {

        return	typestructure.stream().map(x -> typeentityToDto(x)).collect(Collectors.toList());

    }


    public TypeStructure typedtoToEntity(TypeStructureDto typeStructureDto)
    {

        ModelMapper mapper = new ModelMapper();
        TypeStructure map = mapper.map(typeStructureDto, TypeStructure.class);
        return map;
    }

    public List<TypeStructure> typedtoToEntity(List<TypeStructureDto> lsttypedto)
    {

        return lsttypedto.stream().map(x -> typedtoToEntity(x)).collect(Collectors.toList());
    }



    /** convert dto for sous-type **/


    public SousTypeStructureDto soustypeentityToDto(SousTypeStructure soustypestructure) {

        ModelMapper mapper =new ModelMapper();
        SousTypeStructureDto map = mapper.map(soustypestructure, SousTypeStructureDto.class);
        return map;

    }
    public List<SousTypeStructureDto> soustypeentityToDto(List<SousTypeStructure> soustypestructure) {

        return	soustypestructure.stream().map(x -> soustypeentityToDto(x)).collect(Collectors.toList());

    }


    public SousTypeStructure soustypedtoToEntity(SousTypeStructureDto soustypeStructureDto)
    {

        ModelMapper mapper = new ModelMapper();
        SousTypeStructure map = mapper.map(soustypeStructureDto, SousTypeStructure.class);
        return map;
    }

    public List<SousTypeStructure> soustypedtoToEntity(List<SousTypeStructureDto> lstsoustypedto)
    {

        return lstsoustypedto.stream().map(x -> soustypedtoToEntity(x)).collect(Collectors.toList());
    }





    /** convert dto for secteur **/


    public SecteureactiviteDto secteurentityToDto(Secteureactivite secteuractivite) {

        ModelMapper mapper =new ModelMapper();
        SecteureactiviteDto map = mapper.map(secteuractivite, SecteureactiviteDto.class);
        return map;

    }
    public List<SecteureactiviteDto> secteurentityToDto(List<Secteureactivite> secteuractivites) {

        return	secteuractivites.stream().map(x -> secteurentityToDto(x)).collect(Collectors.toList());

    }


    public Secteureactivite secteuredtoToEntity(SecteureactiviteDto secteuractiviteDto)
    {

        ModelMapper mapper = new ModelMapper();
        Secteureactivite map = mapper.map(secteuractiviteDto, Secteureactivite.class);
        return map;
    }

    public List<Secteureactivite> secteuredtoToEntity(List<SecteureactiviteDto> secteuractiviteDtos)
    {

        return secteuractiviteDtos.stream().map(x -> secteuredtoToEntity(x)).collect(Collectors.toList());
    }

}
