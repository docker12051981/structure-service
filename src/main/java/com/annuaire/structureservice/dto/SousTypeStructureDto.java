package com.annuaire.structureservice.dto;

import com.annuaire.structureservice.model.TypeStructure;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description sous type DTO

 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SousTypeStructureDto {
    private String id;
    private String lib_fr;
    private String lib_ar;
    private String typeId;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
