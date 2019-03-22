package com.arteco.service;

import model.Card;
import model.CardType;
import model.CardValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@Service
public class CardService {

    private List<Card> availableCards = new ArrayList<>();

    public CardService() {
        for (CardType type : CardType.values()) {
            for (CardValue value : CardValue.values()) {
                availableCards.add(new Card(type, value));
            }
        }
    }

    public Set<Card> getRandomCards() {
        List<Card> allCards = new ArrayList<>(availableCards);
        Collections.shuffle(allCards);

        return new HashSet<>(allCards.subList(0, 5));
    }
}
