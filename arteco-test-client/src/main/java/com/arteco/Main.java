package com.arteco;

import com.arteco.hand.HandDealer;
import com.arteco.hand.HandPlayer;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
public class Main {

    public static void main(String... args) {
        new HandPlayer(new HandDealer()).play();
    }
}
