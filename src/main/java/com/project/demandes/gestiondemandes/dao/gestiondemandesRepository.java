package com.project.demandes.gestiondemandes.dao;

import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public interface gestiondemandesRepository extends JpaRepository<BourseScolaire, Long> {
    @Query(value = "SELECT bourse_scolaire.* FROM demande JOIN formulaire ON formulaire.id = demande.formulaire_id JOIN bourse_scolaire ON demande.id_doc = bourse_scolaire.id WHERE demande.user_id = :userId", nativeQuery = true)
    List<BourseScolaire> findBourseScolaireFromView(@Param("userId") Integer userId);

    @Query(value = "SELECT * from Demande_BS where Status='EnCours'", nativeQuery = true)
    List<BourseScolaire> findBourseScolaireAdmin();
}
