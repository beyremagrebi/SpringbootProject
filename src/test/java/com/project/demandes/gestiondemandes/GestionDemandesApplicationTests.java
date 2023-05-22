package com.project.demandes.gestiondemandes;

import com.project.demandes.gestiondemandes.dao.gestiondemandesRepository;
import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GestionDemandesApplicationTests {

    @Autowired
    private gestiondemandesRepository gdRepository;
    @Test
    void testsenddemande() {

        BourseScolaire bs=new BourseScolaire("14509251","Ariana 7 rue destinateur","Beyrem agrebi",6000.000,"29160972","beyremagrebi58@gmail.com");
        gdRepository.save(bs);
    }

}
