package com.annuaire.structureservice.service;

import com.annuaire.structureservice.dto.SecteureactiviteDto;
import com.annuaire.structureservice.model.Secteureactivite;

import java.util.List;

/**
 * @author karim hmadi

 * @description interface service secteur activitie

 */
public interface ISecteureActiviteService {
    Secteureactivite saveSecteureActivite(SecteureactiviteDto secteuractiviteDto);

    List<Secteureactivite> findAllSecteurActivite();

    Secteureactivite findSecteurActiviteById(String id);

    Secteureactivite updateSecteureActivite(String id, Secteureactivite secteuractiviteRequest);

    Boolean deleteSecteureActivite(String id);
}
