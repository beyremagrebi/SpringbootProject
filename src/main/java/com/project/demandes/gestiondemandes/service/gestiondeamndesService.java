package com.project.demandes.gestiondemandes.service;

import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface gestiondeamndesService {

    Page<BourseScolaire> getAllDemandeParPage(int page, int size);
    BourseScolaire sendDemande(BourseScolaire bs);
    BourseScolaire updateDemande(BourseScolaire bs);

    void deleteDemande(Long id);


    BourseScolaire getDemande(Long id);
    List<BourseScolaire> getAllDemande();

}
