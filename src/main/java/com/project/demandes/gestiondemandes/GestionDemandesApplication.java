package com.project.demandes.gestiondemandes;

import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import com.project.demandes.gestiondemandes.service.gestiondemandesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionDemandesApplication implements CommandLineRunner {

    @Autowired
    private gestiondemandesServiceImpl service;
    public static void main(String[] args) {

        SpringApplication.run(GestionDemandesApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
// TODO Auto-generated method stub
        //BourseScolaire bs=new BourseScolaire("14509251","Ariana 7 rue destinateur",new Date(),"Beyrem agrebi",6000.000,"29160972","beyremagrebi58@gmail.com");
        //service.sendDemande(bs);
    }



}
