package com.annuaire.structureservice.model;

import com.annuaire.structureservice.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author karim hmadi

 * @description entity recursive structure

 */

@Document(collection = "structure")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    @Id
    private String id;
    @Transient
    public static final String SEQUENCE_NAME = "structure_sequence";
    @Indexed(unique = true)
    private int key;
    private int treeId;
    private int orgId;
    private List<Integer> parentId;
    private List<Node> descendants;
    @NotNull
    private String title;
    private String name;
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
    @DBRef
    private TypeStructure type;
    @Field("soustype")
    private SousTypeStructure soustype;
    @Field("secteur")
    @DBRef
    private Secteureactivite secteur;
    @Field("contact")
    private SContact contact;
    @Field("adresse")
    private Adresse adresse;
    private String createdBy;
    private String updatedBy;
    @CreatedDate
    private LocalDateTime createTime;
    @LastModifiedDate
    private LocalDateTime updateTime;
}
