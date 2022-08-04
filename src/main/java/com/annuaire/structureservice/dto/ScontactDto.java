package com.annuaire.structureservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * @author karim hmadi

 * @description structure contact DTO

 */
public class ScontactDto {

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
