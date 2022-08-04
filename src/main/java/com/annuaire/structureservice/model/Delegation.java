package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description model delegation
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delegation {
    private String code;
    private String codeville;
    private String lib_fr;
    private String lib_ar;
}
