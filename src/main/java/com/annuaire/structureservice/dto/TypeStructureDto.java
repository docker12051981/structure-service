package com.annuaire.structureservice.dto;

import lombok.*;

import java.time.LocalDateTime;


/**
 * @author karim hmadi

 * @description type structure DTO

 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TypeStructureDto {
    private String id;
    private String lib_fr;
    private String lib_ar;
    public Boolean isorganisme;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
