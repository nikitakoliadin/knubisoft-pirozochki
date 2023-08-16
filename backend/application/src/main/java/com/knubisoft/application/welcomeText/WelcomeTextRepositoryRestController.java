package com.knubisoft.application.welcomeText;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class WelcomeTextRepositoryRestController {
    private final DefaultWelcomeTextService defaultWelcomeTextService;

    @Autowired
    public WelcomeTextRepositoryRestController(DefaultWelcomeTextService defaultWelcomeTextService) {
        this.defaultWelcomeTextService = defaultWelcomeTextService;
    }

    @GetMapping("/welcomeTexts")
    public @ResponseBody List<WelcomeText> textsList() {
        return defaultWelcomeTextService.getWelcomeTexts();
    }
}
