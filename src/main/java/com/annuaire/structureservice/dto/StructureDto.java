package com.annuaire.structureservice.dto;

import com.annuaire.structureservice.enumeration.Status;
import com.annuaire.structureservice.model.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
/**
 * @author karim hmadi

 * @description structure dto DTO

 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StructureDto {
    private String id;
    private int key;
    private int treeId;
    private int orgId;
    private String parent;
    private String title;
    private String lib_ar;
    private String abr_fr;
    private String abr_ar;
    private String logo;
    private String description_fr;
    private String description_ar;
    private Status status;
    private TypeStructure type;
    private SousTypeStructure soustype;
    private Secteureactivite secteur;
    private SContact contact;
    private Adresse adresse;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
