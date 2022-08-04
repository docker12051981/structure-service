package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author karim hmadi

 * @description model custom structure used for rest template

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "structure")
public class CustomStructure {
    private String id;
    private int key;
    private String title;
    private String abr_fr;
}
