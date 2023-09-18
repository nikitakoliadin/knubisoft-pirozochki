package com.knubisoft.application.welcome_text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultWelcomeTextService implements WelcomeTextService {

    private final WelcomeTextRepository welcomeTextRepository;

    @Autowired
    public DefaultWelcomeTextService(final WelcomeTextRepository welcomeTextRepository) {
        this.welcomeTextRepository = welcomeTextRepository;
    }

    @Override
    public List<WelcomeText> getWelcomeTexts() {
        return welcomeTextRepository.findAll();
    }
}
