package com.project.demandes.gestiondemandes.service;

import com.project.demandes.gestiondemandes.entities.Formulaire;
import org.springframework.data.domain.Page;

import java.util.List;

public interface formulaireService {
    Formulaire addForm(Formulaire formulaire);
    Page<Formulaire> getAllFormulaireParPage(int page, int size);

    Formulaire findFormulaireById(Long id);


}
