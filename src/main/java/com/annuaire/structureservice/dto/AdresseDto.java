package com.annuaire.structureservice.dto;

import com.annuaire.structureservice.model.Adresse;
import com.annuaire.structureservice.model.Delegation;
import com.annuaire.structureservice.model.Gouvernorat;
import com.annuaire.structureservice.model.Ville;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description adresse structure DTO

 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresseDto {

    private Gouvernorat gouvernorat;
    private Ville ville;
    private Delegation delegation;
    private String rue_fr;
    private String rue_ar;
    private String num;
    private String postal;
}
