package com.project.demandes.gestiondemandes.service;

import com.project.demandes.gestiondemandes.entities.Demande;
import org.springframework.stereotype.Service;

public interface demandeService {
    Demande saveDemande(Demande demande);
}
