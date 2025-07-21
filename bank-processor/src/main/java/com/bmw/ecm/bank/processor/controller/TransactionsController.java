package com.bmw.ecm.bank.processor.controller;

import com.bmw.ecm.bank.processor.dto.TransactionsDTO;
import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.services.TransactionsService;
import com.bmw.ecm.bank.processor.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {
    private final TransactionsService transactionsService;
    private final UserService userService;

    public TransactionsController(TransactionsService transactionsService, UserService userService) {
        this.transactionsService = transactionsService;
        this.userService = userService;
    }

    @GetMapping
    ModelAndView geTransactions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<TransactionsDTO> transactions = transactionsService.getTransactions(page, pageSize);
        int totalPages = transactions.getTotalPages();
        long totalElements = transactions.getTotalElements();
        ModelAndView modelAndView = new ModelAndView("transactions");
        modelAndView.addObject("transactions", transactions);
        modelAndView.addObject("transactionType", "Transactions");
        modelAndView.addObject("totalTransactions", totalElements);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("pageSize", pageSize);


        return modelAndView;
    }

    @GetMapping("/withdrawals")
    ModelAndView getWithdrawals(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<TransactionsDTO> transactions = transactionsService.getWithdrawals(page, pageSize);
        int totalPages = transactions.getTotalPages();
        long totalElements = transactions.getTotalElements();
        ModelAndView modelAndView = new ModelAndView("transactions");
        modelAndView.addObject("transactions", transactions);
        modelAndView.addObject("transactionType", "Withdrawals");
        modelAndView.addObject("totalTransactions", totalElements);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("pageSize", pageSize);

        return modelAndView;
    }

    @GetMapping("/deposits")
    ModelAndView getDeposits(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<TransactionsDTO> transactions = transactionsService.getDeposits(page, pageSize);
        int totalPages = transactions.getTotalPages();
        long totalElements = transactions.getTotalElements();
        ModelAndView modelAndView = new ModelAndView("transactions");
        modelAndView.addObject("transactions", transactions);
        modelAndView.addObject("transactionType", "Deposits");
        modelAndView.addObject("totalTransactions", totalElements);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("pageSize", pageSize);

        return modelAndView;
    }

    @GetMapping("/user")
    ModelAndView getUsersWithTransactions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<UserDTO> userTransactions = userService.getUsersWithTransactions(page, pageSize);
        int totalPages = userTransactions.getTotalPages();
        long totalElements = userTransactions.getTotalElements();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("users", userTransactions);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("totalElements", totalElements);
        modelAndView.addObject("pageSize", pageSize);

        return modelAndView;
    }
}
