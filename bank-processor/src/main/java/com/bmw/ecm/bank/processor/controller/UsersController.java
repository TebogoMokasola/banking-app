package com.bmw.ecm.bank.processor.controller;

import com.bmw.ecm.bank.processor.Specification.UserSpecifications;
import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.entities.UsersEntity;
import com.bmw.ecm.bank.processor.repository.UserRepository;
import com.bmw.ecm.bank.processor.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

   @RequestMapping("/users")
    public String getUsers(@RequestParam(required = false) String firstname,
                           @RequestParam(required = false) String lastname,
                           @RequestParam(required = false) String gender,
                           @RequestParam(required = false) String email,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int pageSize,
                           Model model) {
        Specification<UsersEntity> spec = Specification
                .where(UserSpecifications.hasFirstName(firstname))
                .and(UserSpecifications.hasLastName(lastname))
                .and(UserSpecifications.hasGender(gender))
                .and(UserSpecifications.hasEmail(email));
        Page<UserDTO> users = userService.getUsers(spec,page, pageSize);

        model.addAttribute("users", users.getContent());
        model.addAttribute("currentPage", users.getNumber());
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("pageSize", users.getSize());
        model.addAttribute("totalElements", users.getTotalElements());
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        model.addAttribute("gender", gender);
        model.addAttribute("email", email);


        return "users";}



}
