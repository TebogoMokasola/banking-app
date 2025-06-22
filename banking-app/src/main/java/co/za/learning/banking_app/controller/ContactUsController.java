package co.za.learning.banking_app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsController {

    @GetMapping("contact-us")
    public String contactUsPage() {
        return "/common/contact-us";
    }
}
