package com.arteco.hand;

import lombok.RequiredArgsConstructor;
import model.Card;
import model.CardValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@RequiredArgsConstructor
public class HandPlayer {

    private final IHandDealer dealer;

    public HandResult play() {
        HandResult result;

        Set<Card> cards = dealer.dealCards();

        System.out.println("This is your hand: " + cards);

        Map<CardValue, List<Card>> cardMap = cards.stream().collect(Collectors.groupingBy(Card::getValue));

        if (cardMap.size() == 5) {
            result = getNoRepetitionHand(cards);
        } else if (cardMap.size() == 4) {
            result = getPair(cardMap);
        } else if (cardMap.size() == 3) {
            result = getTwoPairsOrThreeOfAKind(cardMap);
        } else {
            result = getPokerOrFull(cardMap);
        } // There cannot be 5 cards with the same value since there are only 4 suits

        if (result != null) {
            System.out.println("Best play is " + result.getClassification().getName() + ":" + result.getCards());
        }
        return result;
    }

    private HandResult getNoRepetitionHand(Set<Card> cards) {
        HandResult result;
        List<Card> sorted = new ArrayList<>(cards);
        sorted.sort(Comparator.comparing(Card::getValue));
        boolean isStraight = isStraight(sorted);
        boolean isFlush = isFlush(sorted);

        if (isStraight) {
            if (isFlush) {
                if (sorted.get(sorted.size() - 1).getValue() == CardValue.A
                        && sorted.get(0).getValue() == CardValue.TEN) {
                    result = new HandResult(HandClassification.ROYAL_FLUSH, sorted);
                } else {
                    result = new HandResult(HandClassification.STRAIGHT_FLUSH, sorted);
                }
            } else {
                result = new HandResult(HandClassification.STRAIGHT, sorted);
            }
        } else if (isFlush) {
            result = new HandResult(HandClassification.FLUSH, sorted);
        } else {
            result = new HandResult(HandClassification.HIGHEST_CARD, sorted.subList(4, 5));
        }
        return result;
    }

    private HandResult getPokerOrFull(Map<CardValue, List<Card>> cardMap) {
        List<Card> full = new ArrayList<>();

        for (List<Card> cards : cardMap.values()) {
            if (cards.size() == 4) {
                return new HandResult(HandClassification.POKER, cards);
            } else if(cards.size() > 1) {
                full.addAll(cards);
            }
        }
        if (!full.isEmpty()) {
            return new HandResult(HandClassification.FULL_HOUSE, full);
        }
        return null;
    }

    private HandResult getTwoPairsOrThreeOfAKind(Map<CardValue, List<Card>> cardMap) {
        List<Card> twoPairs = new ArrayList<>();

        for (List<Card> cards : cardMap.values()) {
            if (cards.size() == 3) {
                return new HandResult(HandClassification.THREE_OF_A_KIND, cards);
            } else if (cards.size() == 2) {
                twoPairs.addAll(cards);
            }
        }
        if (!twoPairs.isEmpty()) {
            return new HandResult(HandClassification.DOUBLE_PAIR, twoPairs);
        }
        return null;
    }

    private HandResult getPair(Map<CardValue, List<Card>> cardMap) {
        for (List<Card> cards : cardMap.values()) {
            if (cards.size() == 2) {
                return new HandResult(HandClassification.PAIR, cards);
            }
        }
        return null;
    }

    private boolean isFlush(List<Card> sorted) {
        Card previous = sorted.get(0);

        for (int i = 1; i < sorted.size() ; i++) {
            Card current = sorted.get(i);

            if (current.getType() != previous.getType()) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    private boolean isStraight(List<Card> sorted) {
        Card previous = sorted.get(0);
        CardValue firstValue = previous.getValue();

        for (int i = 1; i < sorted.size() ; i++) {
            Card current = sorted.get(i);

            if (previous.getValue().ordinal() + 1 != current.getValue().ordinal()
                    && !(i == 4 && firstValue == CardValue.TWO && current.getValue() == CardValue.A)) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}