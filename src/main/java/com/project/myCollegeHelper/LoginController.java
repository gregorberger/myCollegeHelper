package com.project.myCollegeHelper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        String loginUrl = "/oauth2/authorization/google";
        model.addAttribute("loginUrl", loginUrl);
        return "login";
    }
}
