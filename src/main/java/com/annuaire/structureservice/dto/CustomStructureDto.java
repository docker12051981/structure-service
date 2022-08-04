package com.annuaire.structureservice.dto;

import lombok.*;

/**
 * @author karim hmadi

 * @description custom structure DTO used for resttemplate whene search by matricule

 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomStructureDto {
    private String id;
    private int key;
    private String title;
    private String abr_fr;
}
