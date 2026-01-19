package org.example.pvt.controller;

import org.example.pvt.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {
    @Autowired
   private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact/sendmail")
    public String handleContact(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String message) {
        // Optional: send email or save message
        System.out.println("Name: " + name + ", email: " + email+",message:"+message);
        emailService.sendContactEmail(name,email,message);
        return "redirect:/#contact";


    }
}

