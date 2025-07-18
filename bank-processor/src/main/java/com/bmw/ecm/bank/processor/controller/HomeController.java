package com.bmw.ecm.bank.processor.controller;

import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.entities.UsersEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping("/")
    String getHomePage(Model model) {
        log.info("Loading home page");
        return "home";
    }

    @GetMapping("register")
    public String userRegistration(Model model) {
        UsersEntity usersEntity = new UsersEntity();
        model.addAttribute("userForm", usersEntity);
        List<String> listGender = Arrays.asList("Male", "Female");
        model.addAttribute("listGender", listGender);
        return "register-form";
    }

    @GetMapping("/login")
    public String loginform(Model model){
        model.addAttribute("login", new UserDTO());
        return "login";
    }

    @RequestMapping("/update-user")
    String updateUserForm(){
        log.info("Getting users for update");
        return "update-user";
    }

    @PostMapping("/update-user")
    ModelAndView updateUser(Model model, @ModelAttribute(name = "lastname") String lastname,
                            @ModelAttribute(name = "firstname") String firstname, @ModelAttribute(name = "email") String email) {

        log.info("Getting users");


        //TODO this should be done in the BUILDER utility
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setFirstname(firstname);
        usersEntity.setLastname(lastname);
        usersEntity.setEmail(email);
        usersEntity.setGender("Male");


        ModelAndView modelAndView = new ModelAndView("update-user");
        return modelAndView;
    }

}
