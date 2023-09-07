package com.knubisoft.application.card;

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
