package com.arteco.controller;

import com.arteco.service.CardService;
import model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/cards/random")
    public Set<Card> getRandomCards() {
        return cardService.getRandomCards();
    }
}
