package com.project.demandes.gestiondemandes.service;

import com.project.demandes.gestiondemandes.dao.gestiondemandesRepository;
import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class gestiondemandesServiceImpl implements gestiondeamndesService{

    @Autowired
    gestiondemandesRepository bsRepository;

    @Override
    public Page<BourseScolaire> getAllDemandeParPage(int page, int size) {
        return bsRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public BourseScolaire sendDemande(BourseScolaire bs) {
        return bsRepository.save(bs);
    }

    @Override
    public BourseScolaire updateDemande(BourseScolaire bs){

        return bsRepository.save(bs);
    }

    @Override
    public void deleteDemande(Long id){

        bsRepository.deleteById(id);
    }

    @Override
    public BourseScolaire getDemande(Long id) {
        return bsRepository.findById(id).get();
    }
    @Override
    public List<BourseScolaire> getAllDemande() {
        return bsRepository.findAll();
    }




}
