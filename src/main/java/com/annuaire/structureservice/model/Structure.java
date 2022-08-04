package com.annuaire.structureservice.model;

import com.annuaire.structureservice.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author karim hmadi

 * @description entity structure

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "structure")
public class Structure {

    @Id
    private String id;
    private int key;
    private String parent;
    @Transient
    public static final String SEQUENCE_NAME = "structure_sequence";
    private int tree;
    private int orgId;
    @NotNull
    private String title;
    @NotNull
    private String lib_ar;
    private String abr_fr;
    private String abr_ar;
    private String logo;
    private String description_fr;
    private String description_ar;
    @Field("status")
    private Status status;
    @Field("type")
    private TypeStructure type;
    @Field("Soustype")
    private SousTypeStructure soustype;
    @Field("secteur")
    private Secteureactivite secteur;
    @Field("contact")
    private SContact contact;
    @Field("adresse")
    private Adresse adresse;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
