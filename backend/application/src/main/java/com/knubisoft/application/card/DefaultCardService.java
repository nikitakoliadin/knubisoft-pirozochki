package com.knubisoft.application.card;

import com.knubisoft.application.card.Card;
import com.knubisoft.application.card.CardRepository;
import com.knubisoft.application.card.CardService;
import com.knubisoft.application.welcomeText.WelcomeText;
import com.knubisoft.application.welcomeText.WelcomeTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCardService implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public DefaultCardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }
}
