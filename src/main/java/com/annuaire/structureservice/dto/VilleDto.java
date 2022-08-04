package com.annuaire.structureservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description ville DTO but use delegation DTO

 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VilleDto {
    private String code;
    private String codegouv;
    private String lib_fr;
    private String lib_ar;
}
