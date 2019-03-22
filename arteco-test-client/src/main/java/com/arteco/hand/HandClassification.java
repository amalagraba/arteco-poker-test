package com.arteco.hand;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@Getter
@AllArgsConstructor
public enum HandClassification {

    ROYAL_FLUSH("Royal flush"),
    STRAIGHT_FLUSH("Straight flush"),
    STRAIGHT("Straight"),
    FLUSH("Flush"),
    POKER("Poker"),
    FULL_HOUSE("Full house"),
    DOUBLE_PAIR("Double pair"),
    THREE_OF_A_KIND("Three of a kind"),
    PAIR("Pair"),
    HIGHEST_CARD("Highest card");

    private String name;
}
