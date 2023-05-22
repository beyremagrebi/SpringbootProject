package com.project.demandes.gestiondemandes.dao;

import com.project.demandes.gestiondemandes.entities.Formulaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface formulaireRepository extends JpaRepository<Formulaire,Long> {
}
