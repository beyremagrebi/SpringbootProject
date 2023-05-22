package com.project.demandes.gestiondemandes.service;

import com.project.demandes.gestiondemandes.dao.formulaireRepository;
import com.project.demandes.gestiondemandes.entities.Formulaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class formulaireServiceImpl implements formulaireService{
    @Autowired
    formulaireRepository formulaireRepository;

    @Override
    public Formulaire addForm(Formulaire formulaire) {
       return  formulaireRepository.save(formulaire);
    }

    @Override
    public Page<Formulaire> getAllFormulaireParPage(int page, int size) {
        return formulaireRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Formulaire findFormulaireById(Long id){
        return formulaireRepository.findById(id).get();
    }
}
