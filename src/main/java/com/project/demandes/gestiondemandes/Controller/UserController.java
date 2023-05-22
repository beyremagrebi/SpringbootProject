package com.project.demandes.gestiondemandes.Controller;


import com.project.demandes.gestiondemandes.dao.UserRepository;
import com.project.demandes.gestiondemandes.entities.User;
import com.project.demandes.gestiondemandes.service.UserForm;
import com.project.demandes.gestiondemandes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/reg")
    public String show(@ModelAttribute("user") User user){
        return "register";
    }

    @RequestMapping("/register")
    public String addUser(@ModelAttribute("user") UserForm user, ModelMap modelMap){
        String error="";

        if(user.getPassword().equals(user.getConfirmedPassword())){

            userService.saveUser(user.getUsername(),user.getPassword(),user.getConfirmedPassword());
        }
        else{
            error="Check Field Confirm Password";
            modelMap.addAttribute("error",error);
            return "register";
        }

        return "login";
    }
    @RequestMapping("/")
    public String index(){
        return "listeForm";
    }

}
