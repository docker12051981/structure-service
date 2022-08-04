package com.annuaire.structureservice.object;

import com.annuaire.structureservice.enumeration.Status;
import com.annuaire.structureservice.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javers.core.metamodel.annotation.DiffIgnore;
import org.javers.core.metamodel.annotation.TypeName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author karim hmadi

 * @description value object for recursive structure

 */

@TypeName("StructureNode")
@Getter
@Setter
@ToString
public class StructureNode {

    @Id
    private String id;
    private int key;
    @DiffIgnore
    private int treeId;
    private int orgId;
    @DiffIgnore
    private List<Integer> parentId;
    private List<StructureNode> children;
    @DiffIgnore
    @JsonIgnore
    private List<StructureNode> parents;
    private String title;
    private String name;
    private String lib_ar;
    private String abr_fr;
    private String abr_ar;
    private String logo;
    private String description_fr;
    private String description_ar;
    private Status status;
    @DBRef
    private TypeStructure type;
    @DBRef
    private SousTypeStructure soustype;
    @DBRef
    private Secteureactivite secteur;
    private SContact contact;
    private Adresse adresse;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public StructureNode() {
        this.parentId = new ArrayList<>();
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    // TODO: throws java.lang.NullPointerException: null and in many cases hierarchies are not fetched correctly
    public void addChild(StructureNode child) {
        if (this.children!= null && !this.children.contains(child) && child != null)
            this.children.add(child);
    }

    public void addParent(StructureNode parent) {
        if (this.parents!= null && !this.parents.contains(parent) && parent != null)
            this.parents.add(parent);
    }
}
