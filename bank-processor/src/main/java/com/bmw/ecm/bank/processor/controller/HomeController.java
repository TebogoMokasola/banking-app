package com.bmw.ecm.bank.processor.controller;


import com.bmw.ecm.bank.processor.entities.UsersEntity;
import com.bmw.ecm.bank.processor.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    String getUsers(){
        log.info("Getting users {} ", 1);
        return "home";
    }

    @RequestMapping("/users")
    ModelAndView getTransactions(Model model){
        log.info("Getting users");
        ModelAndView modelAndView = new ModelAndView("users");
        List<UsersEntity> users = userService.getUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("name", "Tshina");

        return modelAndView;
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

        userService.saveUser(usersEntity);

        ModelAndView modelAndView = new ModelAndView("update-user");
        return modelAndView;
    }

}
