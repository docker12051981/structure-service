package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description model ville we can use delegation

 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
    private String code;
    private String codegouv;
    private String lib_fr;
    private String lib_ar;
}
