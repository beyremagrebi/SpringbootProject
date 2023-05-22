package com.project.demandes.gestiondemandes.Controller;

import com.project.demandes.gestiondemandes.entities.Formulaire;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class bourcerechercheController {
    @RequestMapping("/bourserecherche")
    public String Formulaire(ModelMap modelMap){
       /* Formulaire f=new Formulaire();
        modelMap.addAttribute("f",f);*/
        return "sendBourseRecherche";
    }
}
