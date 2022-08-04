package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "param")
public class Param {

    @Id
    private String id;
    private String name;
    private double val;
    private int nodeId;
    private int treeId;
    private List<Integer> parentId;
    private List<Param> descendants;
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";



}
