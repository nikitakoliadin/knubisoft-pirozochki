package com.knubisoft.application.welcome_text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WelcomeTextRepositoryRestController {
    private final DefaultWelcomeTextService defaultWelcomeTextService;

    @Autowired
    public WelcomeTextRepositoryRestController(final DefaultWelcomeTextService defaultWelcomeTextService) {
        this.defaultWelcomeTextService = defaultWelcomeTextService;
    }

    @GetMapping("/welcomeTexts")
    public @ResponseBody List<WelcomeText> textsList() {
        return defaultWelcomeTextService.getWelcomeTexts();
    }
}
