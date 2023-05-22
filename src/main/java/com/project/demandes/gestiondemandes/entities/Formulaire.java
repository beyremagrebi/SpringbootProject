package com.project.demandes.gestiondemandes.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Formulaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nomForm;


    private String description;

    private String hrefForm;

    @OneToMany(mappedBy = "formulaire")
    private List<BourseScolaire> bourseScolaires;



    public Formulaire(){

    }

    public Formulaire(String nomForm, List<BourseScolaire> bourseScolaires,String description,String hrefForm){
        this.nomForm=nomForm;
        this.description=description;
        this.hrefForm=hrefForm;
        this.bourseScolaires=bourseScolaires;
    }

    public String getNomForm() {
        return nomForm;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<BourseScolaire> getBourseScolaires() {
        return bourseScolaires;
    }

    public String getHrefForm() {
        return hrefForm;
    }

    public void setBourseScolaires(List<BourseScolaire> bourseScolaires) {
        this.bourseScolaires = bourseScolaires;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHrefForm(String hrefForm) {
        this.hrefForm = hrefForm;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomForm(String nomForm) {
        this.nomForm = nomForm;
    }
}
