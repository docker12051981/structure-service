package com.annuaire.structureservice.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.javers.core.metamodel.annotation.DiffIgnore;
import org.javers.core.metamodel.annotation.Id;
import org.javers.core.metamodel.annotation.TypeName;

import java.util.ArrayList;
import java.util.List;

@TypeName("ParamNode")
@Getter
@Setter
@ToString
public class ParamNode {

    @Id
    private int nodeId;
    private String name;
    private double val;
    @DiffIgnore
    private int treeId;

    @DiffIgnore
    private List<Integer> parentId;

    private List<ParamNode> children;

    @DiffIgnore
    @JsonIgnore
    private List<ParamNode> parents;

    public ParamNode() {
        this.parentId = new ArrayList<>();
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    // TODO: throws java.lang.NullPointerException: null and in many cases hierarchies are not fetched correctly
    public void addChild(ParamNode child) {
        if (this.children!= null && !this.children.contains(child) && child != null)
            this.children.add(child);
    }

    public void addParent(ParamNode parent) {
        if (this.parents!= null && !this.parents.contains(parent) && parent != null)
            this.parents.add(parent);
    }
}
