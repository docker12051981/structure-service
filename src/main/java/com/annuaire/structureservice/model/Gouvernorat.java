package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @author karim hmadi

 * @description model gouvernorat

 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gouvernorat {
    private String code;
    private String lib_fr;
    private String lib_ar;
}
