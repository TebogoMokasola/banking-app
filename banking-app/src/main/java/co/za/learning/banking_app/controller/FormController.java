package co.za.learning.banking_app.controller;

import org.springframework.ui.Model;
import co.za.learning.banking_app.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    //Handler for user registrations page request
    @GetMapping("register")
    public String userRegistration(Model model) {
        //empty userform model to store form data
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        List<String> listGender = Arrays.asList("Male","Female");
        model.addAttribute("listGender", listGender);
        return "register-form";
    }
}
