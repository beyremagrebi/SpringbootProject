package com.project.demandes.gestiondemandes.entities;



import javax.persistence.*;

@Entity
public class BourseScolaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cin;

    private String adresse;
    private String nomComplet;
    private Double revenuAnnuel;
    private String numerotel;
    private String email;
    private String Status;
    @ManyToOne
    @JoinColumn(name = "formulaire_id")
    private Formulaire formulaire;

    public BourseScolaire(String cin, String adresse, String nomComplet, Double revenuAnnuel, String numerotel, String email,String Staus){
        this.cin=cin;
        this.adresse=adresse;
        this.nomComplet=nomComplet;
        this.revenuAnnuel=revenuAnnuel;
        this.numerotel=numerotel;
        this.email=email;
        this.Status=Staus;


    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public BourseScolaire() {

    }

    public Formulaire getFormulaires() {
        return formulaire;
    }

    public void setFormulaires(Formulaire formulaires) {
        this.formulaire = formulaires;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }


    public String getAdresse() {
        return adresse;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public Double getRevenuAnnuel() {
        return revenuAnnuel;
    }

    public String getNumerotel() {
        return numerotel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumerotel(String numerotel) {
        this.numerotel = numerotel;
    }

    public void setRevenuAnnuel(Double revenuAnnuel) {
        this.revenuAnnuel = revenuAnnuel;
    }

    public Formulaire getFormulaire() {
        return formulaire;
    }
}
