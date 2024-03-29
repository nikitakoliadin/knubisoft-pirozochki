package com.knubisoft.application.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CardRepositoryRestController {
    private final DefaultCardService defaultCardService;

    @Autowired
    public CardRepositoryRestController(final DefaultCardService defaultCardService) {
        this.defaultCardService = defaultCardService;
    }

    @GetMapping("/cards")
    public @ResponseBody List<Card> cardsList() {
        return defaultCardService.getCards();
    }
}
