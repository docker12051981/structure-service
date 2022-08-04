package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author karim hmadi

 * @description entity theme but not used now

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    public String code;
    public String lib_fr;
    public String lib_ar;
}
