package com.arteco.hand;

import model.Card;

import java.util.Set;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@FunctionalInterface
public interface IHandDealer {

    Set<Card> dealCards();
}
