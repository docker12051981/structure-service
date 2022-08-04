package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description entity soustype

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "soustypestructure")
public class SousTypeStructure {
    @Id
    private String id;
    private String typeId;
    @NotNull
    private String lib_fr;
    @NotNull
    private String lib_ar;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
