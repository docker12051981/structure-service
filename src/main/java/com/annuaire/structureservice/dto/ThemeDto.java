package com.annuaire.structureservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description categorie DTO

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDto {
    public String id;
    public String code;
    public String lib_fr;
    public String lib_ar;
}
