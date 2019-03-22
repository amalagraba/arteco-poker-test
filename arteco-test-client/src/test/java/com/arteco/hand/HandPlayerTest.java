package com.arteco.hand;

import model.Card;
import model.CardType;
import model.CardValue;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by amalagraba on 22/03/2019.
 * Arteco Consulting Sl
 * mailto: info@arteco-consulting.com
 */
@RunWith(JUnit4.class)
public class HandPlayerTest {

    @Test
    public void testFlush() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.DIAMONDS, CardValue.J));
        cards.add(new Card(CardType.DIAMONDS, CardValue.TWO));
        cards.add(new Card(CardType.DIAMONDS, CardValue.A));
        cards.add(new Card(CardType.DIAMONDS, CardValue.FOUR));
        cards.add(new Card(CardType.DIAMONDS, CardValue.FIVE));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.FLUSH);
        assertTrue(CollectionUtils.isEqualCollection(cards, result.getCards()));
    }

    @Test
    public void testRoyalFlush() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.SPADES, CardValue.TEN));
        cards.add(new Card(CardType.SPADES, CardValue.J));
        cards.add(new Card(CardType.SPADES, CardValue.Q));
        cards.add(new Card(CardType.SPADES, CardValue.K));
        cards.add(new Card(CardType.SPADES, CardValue.A));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.ROYAL_FLUSH);
        assertTrue(CollectionUtils.isEqualCollection(cards, result.getCards()));
    }

    @Test
    public void testStraightFlush() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.DIAMONDS, CardValue.FIVE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.SIX));
        cards.add(new Card(CardType.DIAMONDS, CardValue.SEVEN));
        cards.add(new Card(CardType.DIAMONDS, CardValue.EIGHT));
        cards.add(new Card(CardType.DIAMONDS, CardValue.NINE));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.STRAIGHT_FLUSH);
        assertTrue(CollectionUtils.isEqualCollection(cards, result.getCards()));
    }

    @Test
    public void testPoker() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.HEARTS, CardValue.A));
        cards.add(new Card(CardType.DIAMONDS, CardValue.A));
        cards.add(new Card(CardType.SPADES, CardValue.A));
        cards.add(new Card(CardType.CLUBS, CardValue.A));
        cards.add(new Card(CardType.DIAMONDS, CardValue.NINE));

        List<Card> expected = Arrays.asList(new Card(CardType.HEARTS, CardValue.A), new Card(CardType.DIAMONDS, CardValue.A),
                new Card(CardType.SPADES, CardValue.A), new Card(CardType.CLUBS, CardValue.A));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.POKER);
        assertTrue(CollectionUtils.isEqualCollection(expected, result.getCards()));
    }

    @Test
    public void testFull() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.HEARTS, CardValue.A));
        cards.add(new Card(CardType.DIAMONDS, CardValue.A));
        cards.add(new Card(CardType.SPADES, CardValue.A));
        cards.add(new Card(CardType.CLUBS, CardValue.NINE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.NINE));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.FULL_HOUSE);
        assertTrue(CollectionUtils.isEqualCollection(cards, result.getCards()));
    }

    @Test
    public void testStraight() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.DIAMONDS, CardValue.THREE));
        cards.add(new Card(CardType.CLUBS, CardValue.FIVE));
        cards.add(new Card(CardType.SPADES, CardValue.FOUR));
        cards.add(new Card(CardType.DIAMONDS, CardValue.A));
        cards.add(new Card(CardType.HEARTS, CardValue.TWO));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.STRAIGHT);
        assertTrue(CollectionUtils.isEqualCollection(cards, result.getCards()));
    }

    @Test
    public void testStraight2() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.DIAMONDS, CardValue.THREE));
        cards.add(new Card(CardType.CLUBS, CardValue.FIVE));
        cards.add(new Card(CardType.SPADES, CardValue.FOUR));
        cards.add(new Card(CardType.DIAMONDS, CardValue.SIX));
        cards.add(new Card(CardType.HEARTS, CardValue.TWO));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.STRAIGHT);
        assertTrue(CollectionUtils.isEqualCollection(cards, result.getCards()));
    }

    @Test
    public void testThreeOfAKind() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.HEARTS, CardValue.THREE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.THREE));
        cards.add(new Card(CardType.SPADES, CardValue.THREE));
        cards.add(new Card(CardType.CLUBS, CardValue.FIVE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.SIX));

        List<Card> expected = Arrays.asList(new Card(CardType.HEARTS, CardValue.THREE), new Card(CardType.DIAMONDS, CardValue.THREE),
                new Card(CardType.SPADES, CardValue.THREE));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.THREE_OF_A_KIND);
        assertTrue(CollectionUtils.isEqualCollection(expected, result.getCards()));
    }

    @Test
    public void testDoublePair() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.HEARTS, CardValue.THREE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.THREE));
        cards.add(new Card(CardType.SPADES, CardValue.FIVE));
        cards.add(new Card(CardType.CLUBS, CardValue.FIVE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.SIX));

        List<Card> expected = Arrays.asList(new Card(CardType.HEARTS, CardValue.THREE), new Card(CardType.DIAMONDS, CardValue.THREE),
                new Card(CardType.SPADES, CardValue.FIVE), new Card(CardType.CLUBS, CardValue.FIVE));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.DOUBLE_PAIR);
        assertTrue(CollectionUtils.isEqualCollection(expected, result.getCards()));
    }

    @Test
    public void testPair() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.HEARTS, CardValue.THREE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.THREE));
        cards.add(new Card(CardType.SPADES, CardValue.SEVEN));
        cards.add(new Card(CardType.CLUBS, CardValue.EIGHT));
        cards.add(new Card(CardType.DIAMONDS, CardValue.SIX));

        List<Card> expected = Arrays.asList(new Card(CardType.HEARTS, CardValue.THREE), new Card(CardType.DIAMONDS, CardValue.THREE));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.PAIR);
        assertTrue(CollectionUtils.isEqualCollection(expected, result.getCards()));
    }

    @Test
    public void testHighestCard() {
        Set<Card> cards = new HashSet<>();
        cards.add(new Card(CardType.HEARTS, CardValue.THREE));
        cards.add(new Card(CardType.DIAMONDS, CardValue.TWO));
        cards.add(new Card(CardType.SPADES, CardValue.SEVEN));
        cards.add(new Card(CardType.CLUBS, CardValue.EIGHT));
        cards.add(new Card(CardType.DIAMONDS, CardValue.A));

        List<Card> expected = Collections.singletonList(new Card(CardType.DIAMONDS, CardValue.A));

        HandResult result = new HandPlayer(() -> cards).play();

        assertNotNull(result);
        assertEquals(result.getClassification(), HandClassification.HIGHEST_CARD);
        assertTrue(CollectionUtils.isEqualCollection(expected, result.getCards()));
    }
}
