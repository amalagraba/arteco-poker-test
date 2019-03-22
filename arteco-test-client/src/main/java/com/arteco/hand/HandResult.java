package com.arteco.hand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Card;

import java.util.List;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandResult {

    private HandClassification classification;
    private List<Card> cards;
}
