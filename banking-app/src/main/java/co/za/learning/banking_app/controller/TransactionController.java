package co.za.learning.banking_app.controller;

import co.za.learning.banking_app.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {

    @GetMapping("/transaction")
    public String transactionPage(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transactions";
    }

    @PostMapping("/transaction/submit")
    public String submitTransaction(Transaction transaction, Model model) {
        // Logic to process the transaction (e.g., save to database)
        model.addAttribute("message", "Transaction completed successfully!");
        return "redirect:/transactions";
    }
}
