package com.knubisoft.application.welcomeText;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultWelcomeTextService implements WelcomeTextService {

    private final WelcomeTextRepository welcomeTextRepository;

    @Autowired
    public DefaultWelcomeTextService(WelcomeTextRepository welcomeTextRepository) {
        this.welcomeTextRepository = welcomeTextRepository;
    }

    @Override
    public List<WelcomeText> getWelcomeTexts() {
        return welcomeTextRepository.findAll();
    }
}
