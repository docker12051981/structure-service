package com.annuaire.structureservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description delegation DTO

 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DelegationDto {
    private String code;
    private String codeville;
    private String lib_fr;
    private String lib_ar;
}
