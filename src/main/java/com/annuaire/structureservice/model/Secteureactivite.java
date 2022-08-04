package com.annuaire.structureservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


/**
 * @author karim hmadi

 * @description entity secteur activite

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Secteureactivite {
    @Id
    private String id;
    @NotNull
    private String code;
    @NotNull
    private String lib_fr;
    @NotNull
    private String lib_ar;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
