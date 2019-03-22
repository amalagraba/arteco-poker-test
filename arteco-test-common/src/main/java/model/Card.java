package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private CardType type;
    private CardValue value;
}
