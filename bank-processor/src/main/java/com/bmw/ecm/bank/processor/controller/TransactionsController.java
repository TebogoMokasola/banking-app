package com.bmw.ecm.bank.processor.controller;

import com.bmw.ecm.bank.processor.dto.TransactionsDTO;
import com.bmw.ecm.bank.processor.dto.UserDTO;
import com.bmw.ecm.bank.processor.entities.TransactionsEntity;
import com.bmw.ecm.bank.processor.services.TransactionsService;
import com.bmw.ecm.bank.processor.services.UserService;
import com.bmw.ecm.bank.processor.spec.TransactionSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.Date;

import static com.bmw.ecm.bank.processor.spec.TransactionSpecification.hasTransactionDate;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {
    private final TransactionsService transactionsService;
    private final UserService userService;

    public TransactionsController(TransactionsService transactionsService, UserService userService) {
        this.transactionsService = transactionsService;
        this.userService = userService;
    }

//    @GetMapping
//    ModelAndView geTransactions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
//        Page<TransactionsDTO> transactions = transactionsService.getTransactions(page, pageSize);
//        int totalPages = transactions.getTotalPages();
//        long totalElements = transactions.getTotalElements();
//        ModelAndView modelAndView = new ModelAndView("transactions");
//        modelAndView.addObject("transactions", transactions);
//        modelAndView.addObject("transactionType", "Transactions");
//        modelAndView.addObject("totalTransactions", totalElements);
//        modelAndView.addObject("currentPage", page);
//        modelAndView.addObject("totalPages", totalPages);
//        modelAndView.addObject("pageSize", pageSize);
//
//
//        return modelAndView;
//    }

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

    @GetMapping

    public String getTransactions(@RequestParam(required = false) String transactionType,

                                  @DateTimeFormat(pattern = "yyyy-MM-dd")

                           @RequestParam(required = false) Date transactionDate,

                           @RequestParam(defaultValue = "0") int page,

                           @RequestParam(defaultValue = "10") int pageSize,

                           Model model) {

        Object TransactionsSpecifications;
        Specification<TransactionsEntity> spec = Specification

                .where(hasTransactionDate(transactionDate))

                .and(TransactionSpecification.hasTransactionType(transactionType));

        //Pageable pageable = PageRequest.of(page, pageSize);

        Page<TransactionsDTO> transactions = transactionsService.getTransactions(spec,page, pageSize);

        model.addAttribute("transactions", transactions.getContent());

        model.addAttribute("currentPage", page);

        model.addAttribute("totalPages", transactions.getTotalPages());

        model.addAttribute("pageSize", transactions.getSize());

        model.addAttribute("totalElements", transactions.getTotalElements());

        model.addAttribute("transactionType", transactionType);

        model.addAttribute("transactionDate", transactionDate);



        return "transactions";}


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
