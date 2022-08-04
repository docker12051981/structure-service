package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description entity type structure

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "typestructure")
public class TypeStructure {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String lib_fr;
    @NotNull
    private String lib_ar;
    public Boolean isorganisme;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
