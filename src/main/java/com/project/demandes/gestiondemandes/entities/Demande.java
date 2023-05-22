package com.project.demandes.gestiondemandes.entities;

import javax.persistence.*;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formulaire_id")
    private Formulaire formulaire;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Long id_doc;

    private String Status;

    public Demande(Long id_doc,Formulaire formulaire,String Status,User user){
        this.id_doc=id_doc;
        this.formulaire=formulaire;
        this.Status=Status;
        this.user=user;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Demande(){

    }

    public Long getId() {
        return id;
    }

    public Formulaire getFormulaire() {
        return formulaire;
    }

    public Long getId_doc() {
        return id_doc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;
    }

    public void setId_doc(Long id_doc) {
        this.id_doc = id_doc;
    }
}
