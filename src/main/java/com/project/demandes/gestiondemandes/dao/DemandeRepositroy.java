package com.project.demandes.gestiondemandes.dao;

import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import com.project.demandes.gestiondemandes.entities.Demande;
import com.project.demandes.gestiondemandes.entities.Formulaire;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeRepositroy extends JpaRepository<Demande,Long> {





}
