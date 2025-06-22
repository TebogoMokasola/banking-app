package co.za.learning.banking_app.controller;


import co.za.learning.banking_app.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {

    //Handler for login page
    @GetMapping("/login")
    public String loginform(Model model){
        model.addAttribute("login", new LoginForm());
        return "login";
    }


}
