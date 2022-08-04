package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;


/**
 * @author karim hmadi

 * @description model structure

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {

    private Gouvernorat gouvernorat;
    private Ville ville;
    private Delegation delegation;
    private String rue_fr;
    private String rue_ar;
    private String num;
    private String postal;
}
