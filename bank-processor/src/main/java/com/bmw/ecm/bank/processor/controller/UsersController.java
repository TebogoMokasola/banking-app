package com.bmw.ecm.bank.processor.controller;

import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    ModelAndView getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {

        Page<UserDTO> users = userService.getUsers(page, pageSize);

        int totalPages = users.getTotalPages();
        long totalElements = users.getTotalElements();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("totalElements", totalElements);
        modelAndView.addObject("pageSize", pageSize);

        return modelAndView;
    }
}
