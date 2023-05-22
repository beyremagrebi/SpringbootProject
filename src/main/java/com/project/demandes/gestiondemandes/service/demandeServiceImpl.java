package com.project.demandes.gestiondemandes.service;

import com.project.demandes.gestiondemandes.dao.DemandeRepositroy;
import com.project.demandes.gestiondemandes.entities.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class demandeServiceImpl implements demandeService{

    @Autowired
    DemandeRepositroy demandeRepositroy;
    @Override
    public Demande saveDemande(Demande demande) {
        return demandeRepositroy.save(demande);
    }
}
