package com.project.demandes.gestiondemandes.Controller;

import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import com.project.demandes.gestiondemandes.entities.Formulaire;
import com.project.demandes.gestiondemandes.service.formulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;

@Controller
public class formulaireController {
    @Autowired
    formulaireService formulaireService;

    @RequestMapping("/formBS")
    public String Formulaire(ModelMap modelMap){
        Formulaire f=new Formulaire();
        modelMap.addAttribute("f",f);
        return "addForm";
    }

    @RequestMapping("/addForm")
    public String sendForm(@ModelAttribute("formulaire") Formulaire f,
                         ModelMap modelMap)throws ParseException
    {

        formulaireService.addForm(f);


        String msg ="Demande envoyée à la date"+new Date();
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("f", f);

        return "addForm";


    }

    @RequestMapping("/listForm")
    public String listforms(ModelMap modelMap,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size){

        Page<Formulaire> formulaires=formulaireService.getAllFormulaireParPage(page,size);
        modelMap.addAttribute("forms",formulaires);

        return "listeForm";
    }

}
