package com.annuaire.structureservice.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description secteur activite DTO

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecteureactiviteDto {
    private String id;
    private String code;
    private String lib_fr;
    private String lib_ar;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
