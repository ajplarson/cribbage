package ajplarson.cribbage;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ajplarson
 */
public class ScoreTest {

    private Score score = new Score();

    public ScoreTest() {
    }

    @Test
    public void testScoreHand20() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(8, Suit.HEARTS));
        cards.add(new Card(8, Suit.SPADES));

        assertEquals(20, score.scoreHand(cards));
    }

    @Test
    public void testScoreHand8() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(1, Suit.CLUBS));
        cards.add(new Card(8, Suit.HEARTS));
        cards.add(new Card(3, Suit.SPADES));

        assertEquals(8, score.scoreHand(cards));
    }

    @Test
    public void testRunsScore12233() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(1, Suit.CLUBS));
        cards.add(new Card(2, Suit.HEARTS));
        cards.add(new Card(2, Suit.CLUBS));
        cards.add(new Card(3, Suit.HEARTS));
        cards.add(new Card(3, Suit.SPADES));

        assertEquals(12, score.getRunsScore(cards));
    }

    @Test
    public void testRunsScore14567() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(1, Suit.CLUBS));
        cards.add(new Card(4, Suit.HEARTS));
        cards.add(new Card(5, Suit.CLUBS));
        cards.add(new Card(6, Suit.HEARTS));
        cards.add(new Card(7, Suit.SPADES));

        assertEquals(4, score.getRunsScore(cards));
    }

    @Test
    public void testRunsScore11123() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(1, Suit.CLUBS));
        cards.add(new Card(1, Suit.HEARTS));
        cards.add(new Card(1, Suit.CLUBS));
        cards.add(new Card(2, Suit.HEARTS));
        cards.add(new Card(3, Suit.SPADES));

        assertEquals(9, score.getRunsScore(cards));
    }

    @Test
    public void testRunsScore34567() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(3, Suit.CLUBS));
        cards.add(new Card(4, Suit.HEARTS));
        cards.add(new Card(5, Suit.CLUBS));
        cards.add(new Card(6, Suit.HEARTS));
        cards.add(new Card(7, Suit.SPADES));

        assertEquals(5, score.getRunsScore(cards));
    }

    @Test
    public void testGetPairs() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(9, Suit.HEARTS));

        assertEquals(6, score.getPairsScore(cards));
    }

    @Test
    public void testGetFlushScore1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(9, Suit.CLUBS));
        cards.add(new Card(7, Suit.CLUBS));

        assertEquals(4, score.getFlushScore(cards));
    }

    @Test
    public void testGetFlushScore2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(9, Suit.CLUBS));
        cards.add(new Card(7, Suit.CLUBS));

        assertEquals(5, score.getFlushScore(cards));
    }

    @Test
    public void testGetFlushScore3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.DIAMONDS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(7, Suit.DIAMONDS));
        cards.add(new Card(9, Suit.DIAMONDS));
        cards.add(new Card(7, Suit.CLUBS));

        assertEquals(0, score.getFlushScore(cards));
    }

    @Test
    public void testGetFlushScore4() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.SPADES));
        cards.add(new Card(7, Suit.SPADES));
        cards.add(new Card(7, Suit.SPADES));
        cards.add(new Card(9, Suit.SPADES));
        cards.add(new Card(7, Suit.CLUBS));

        assertEquals(4, score.getFlushScore(cards));
    }

    @Test
    public void testGetKnobsScore1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(11, Suit.SPADES));
        cards.add(new Card(7, Suit.SPADES));
        cards.add(new Card(6, Suit.SPADES));
        cards.add(new Card(9, Suit.SPADES));
        Card upCard = (new Card(7, Suit.CLUBS));

        assertEquals(0, score.getKnobsScore(cards, upCard));
    }

    @Test
    public void testGetKnobsScore2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(11, Suit.SPADES));
        cards.add(new Card(7, Suit.SPADES));
        cards.add(new Card(6, Suit.SPADES));
        cards.add(new Card(9, Suit.SPADES));
        Card upCard = (new Card(7, Suit.SPADES));

        assertEquals(1, score.getKnobsScore(cards, upCard));
    }

    @Test 
    public void testHand29() {
       List<Card> cards = new ArrayList<>();
        cards.add(new Card(11, Suit.SPADES));
        cards.add(new Card(5, Suit.HEARTS));
        cards.add(new Card(5, Suit.CLUBS));
        cards.add(new Card(5, Suit.DIAMONDS));
        Card upCard = (new Card(5, Suit.SPADES)); 
        
        assertEquals(29, score.scoreHand(cards, upCard));
    }
}
