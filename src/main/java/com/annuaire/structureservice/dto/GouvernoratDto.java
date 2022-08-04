package com.annuaire.structureservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description gouvernorat DTO

 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GouvernoratDto {
    private String code;
    private String lib_fr;
    private String lib_ar;
}
