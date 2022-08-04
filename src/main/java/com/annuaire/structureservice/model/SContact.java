package com.annuaire.structureservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description model contact structure

 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SContact {
    private String num_tel;
    private String num_tel2;
    private String num_fax;
    private String num_fax2;
    private String email;
    private String site_web;
    private String social_fb;
    private String social_twitter;
    private String social_linkdin;
}
