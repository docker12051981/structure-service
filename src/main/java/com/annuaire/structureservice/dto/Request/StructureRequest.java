package com.annuaire.structureservice.dto.Request;

import com.annuaire.structureservice.enumeration.Status;
import com.annuaire.structureservice.model.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description request structure DTO

 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StructureRequest {
    private String parent;
    private String lib_fr;
    private String lib_ar;
    private String abr_fr;
    private String abr_ar;
    private Boolean isorganisme;
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
