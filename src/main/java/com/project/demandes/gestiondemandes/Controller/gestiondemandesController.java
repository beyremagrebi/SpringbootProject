package com.project.demandes.gestiondemandes.Controller;

import com.project.demandes.gestiondemandes.dao.DemandeRepositroy;
import com.project.demandes.gestiondemandes.dao.gestiondemandesRepository;
import com.project.demandes.gestiondemandes.entities.BourseScolaire;
import com.project.demandes.gestiondemandes.entities.Demande;
import com.project.demandes.gestiondemandes.entities.Formulaire;

import com.project.demandes.gestiondemandes.entities.User;
import com.project.demandes.gestiondemandes.service.demandeService;
import com.project.demandes.gestiondemandes.service.formulaireService;
import org.hibernate.mapping.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import com.project.demandes.gestiondemandes.service.gestiondeamndesService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class gestiondemandesController {
    @Autowired
    gestiondeamndesService bsService;

    @Autowired
    formulaireService formulaireService;
    @Autowired
    demandeService demandeService;

    @Autowired
    gestiondemandesRepository gestiondemandesRepository;


    @RequestMapping("/bourseScolaire")
    public String bourseScolaire(ModelMap modelMap){

        BourseScolaire bs=new BourseScolaire();


        modelMap.addAttribute("bs",bs);
        return "sendBourseScolaire";
    }

    @RequestMapping("/details")
    public String details(@RequestParam("id") Long id,ModelMap modelMap){
        BourseScolaire demande=bsService.getDemande(id);
        modelMap.addAttribute("bs",demande);
        return "detailsDemande";
    }

    @RequestMapping("/listdetails")
    public String listdetails(ModelMap modelMap,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String msg="";

        if (authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();

            List<BourseScolaire> bourseScolaires=gestiondemandesRepository.findBourseScolaireFromView(user.getUserId());
            if(bourseScolaires.isEmpty()){
                msg="Pour le moment, vous n'avez aucune demande à traiter.";
            }

                Page<BourseScolaire> pageb= new PageImpl<>(bourseScolaires);

                modelMap.addAttribute("pages", new int[pageb.getTotalPages()]);
                modelMap.addAttribute("currentPage", page);
                modelMap.addAttribute("demandes",pageb);

            modelMap.addAttribute("msg",msg);

        }




        return "ListeDemande";
    }



    @RequestMapping("/sendBS")
    public String sendBS(@ModelAttribute("boursescolaire") BourseScolaire BS,
                         ModelMap modelMap)throws ParseException
    {



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof User) {
            User user=(User) authentication.getPrincipal();
            Formulaire formulaire=formulaireService.findFormulaireById(1L);
            BS.setStatus("EnCours");
            bsService.sendDemande(BS);
            Demande d=new Demande(BS.getId(), formulaire,"EnCours",user);
            demandeService.saveDemande(d);

            String msg ="Demande envoyée à la date"+new Date();

            modelMap.addAttribute("msg", msg);
            modelMap.addAttribute("bs", BS);

        }




        return "sendBourseScolaire";


    }

    @RequestMapping("/supprimerDemande")
    public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap)
    {
        BourseScolaire bs= new BourseScolaire();
        bs.setId(id);
        bsService.deleteDemande(id);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String msg="";

        if (authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();

            List<BourseScolaire> bourseScolaires=gestiondemandesRepository.findBourseScolaireFromView(user.getUserId());
            if(bourseScolaires.isEmpty()){
                msg="Pour le moment, vous n'avez aucune demande à traiter.";
            }

            Page<BourseScolaire> pageb= new PageImpl<>(bourseScolaires);
            modelMap.addAttribute("demandes",pageb);

            modelMap.addAttribute("msg",msg);

        }

        return "ListeDemande";
    }


    @RequestMapping("/updateDemande")
    public String updateProduit(@ModelAttribute("boursescolaire") BourseScolaire bs,
                                @RequestParam("id") Long id,ModelMap modelMap)  throws ParseException
    {
        bsService.updateDemande(bs);
        String msg="dérinière mise à jour à"+new Date();
        modelMap.addAttribute("bs", bs);
        modelMap.addAttribute("msg", msg);
        return "detailsDemande";
    }

    @RequestMapping("/listdetailsadmin")
    public String listdetailsadmin(ModelMap modelMap,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String msg="";

        if (authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();


            List<BourseScolaire> bourseScolaires=gestiondemandesRepository.findBourseScolaireAdmin();
            if(bourseScolaires.isEmpty()){
                msg="Pour le moment, vous n'avez aucune demande à traiter.";
            }

            Page<BourseScolaire> pageb= new PageImpl<>(bourseScolaires);

            modelMap.addAttribute("pages", new int[pageb.getTotalPages()]);
            modelMap.addAttribute("currentPage", page);
            modelMap.addAttribute("demandes",pageb);

            modelMap.addAttribute("msg",msg);

        }




        return "ListeDemande";
    }

    @RequestMapping("/acceptdemande")
    public String accept(@RequestParam("id") Long id,ModelMap modelMap)  throws ParseException
    {
        BourseScolaire bs=bsService.getDemande(id);
        bs.setStatus("Accepté");
        bsService.updateDemande(bs);
        String msg="Demande Accepté à : "+new Date();
        modelMap.addAttribute("bs", bs);
        modelMap.addAttribute("msg", msg);
        return "detailsDemande";
    }

    @RequestMapping("/refusedemande")
    public String refuse(@RequestParam("id") Long id,ModelMap modelMap)  throws ParseException
    {
        BourseScolaire bs=bsService.getDemande(id);
        bs.setStatus("Refusé");
        bsService.updateDemande(bs);
        String msg="Demande Refusé à : "+new Date();
        modelMap.addAttribute("bs", bs);
        modelMap.addAttribute("msg", msg);
        return "detailsDemande";
    }

}
