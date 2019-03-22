package com.arteco.hand;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Card;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
public class HandDealer implements IHandDealer {

    private ObjectMapper mapper = new ObjectMapper();

    public Set<Card> dealCards() {
        HttpURLConnection con = null;
        try {
            URL url = new URL("http://localhost:8080/cards/random");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            Card[] cards = mapper.readValue(con.getInputStream(), Card[].class);

            return Arrays.stream(cards).collect(Collectors.toSet());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
}
