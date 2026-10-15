
package com.example.passwordchecker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/check")
    public String checkPassword(
            @RequestParam("password") String password,
            Model model) {

        model.addAttribute(
                "strength",
                passwordService.checkStrength(password)
        );

        return "result";
    }
}
