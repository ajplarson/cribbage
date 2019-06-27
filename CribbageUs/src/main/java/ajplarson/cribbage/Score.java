/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.cribbage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class Score {

    public int scoreHand(List<Card> deck) {
        int score = 0;
        score += getFifteensScore(deck);
        score += getPairsScore(deck);
        score += getRunsScore(deck);
        score += getFlushScore(deck);
        return score;
    }

    public int scoreHand(List<Card> deck, Card upCard) {
        int score = 0;
        score += getKnobsScore(deck, upCard);
        deck.add(upCard);
        score += getFifteensScore(deck);
        score += getPairsScore(deck);
        score += getRunsScore(deck);
        score += getFlushScore(deck);
        return score;
    }

    public int getRunsScore(List<Card> deck) {
        int runScore = 0;
        boolean foundRunFour = false;
        List<Integer> cardValues = new ArrayList<>();
        //reads in card values to a list
        for (int i = 0; i < deck.size(); i++) {
            cardValues.add(deck.get(i).getValue());
        }
        Collections.sort(cardValues);

        if (cardValues.get(0) == cardValues.get(1) - 1 && cardValues.get(1) == cardValues.get(2) - 1
                && cardValues.get(2) == cardValues.get(3) - 1 && cardValues.get(3) == cardValues.get(4) - 1) {
            runScore = 5;
            return runScore;
        }

        for (int i = 0; i < deck.size() - 3; i++) {
            for (int j = i + 1; j < deck.size() - 2; j++) {
                for (int k = j + 1; k < deck.size() - 1; k++) {
                    for (int l = k + 1; l < deck.size(); l++) {
                        if (cardValues.get(i) == cardValues.get(j) - 1
                                && cardValues.get(j) == cardValues.get(k) - 1
                                && cardValues.get(k) == cardValues.get(l) - 1) {
                            runScore += 4;
                            foundRunFour = true;
                        }
                    }
                }
            }
        }

        if (!foundRunFour) {
            for (int i = 0; i < deck.size() - 2; i++) {
                for (int j = i + 1; j < deck.size() - 1; j++) {
                    for (int k = j + 1; k < deck.size(); k++) {
                        if (cardValues.get(i) == cardValues.get(j) - 1
                                && cardValues.get(j) == cardValues.get(k) - 1) {
                            runScore += 3;
                        }
                    }
                }
            }
        }
        return runScore;
    }

    public int getFifteensScore(List<Card> deck) {
        int numFifteens = 0;
        
        //loop to set J, Q, K to 10
        for(int i = 0; i < deck.size(); i++) {
            if(deck.get(i).getValue() > 10) {
                deck.get(i).setValue(10);
            }
        }
        
        numFifteens += getFifteensTwo(deck);
        numFifteens += getFifteensThree(deck);
        numFifteens += getFifteensFour(deck);
        numFifteens += getFifteensFive(deck);

        return numFifteens * 2;
    }

    public int getFifteensTwo(List<Card> deck) {
        int numFifteens = 0;
        for (int i = 0; i < deck.size() - 1; i++) {
            for (int j = i + 1; j < deck.size(); j++) {
                if ((deck.get(i).getValue() + deck.get(j).getValue()) == 15) {
                    numFifteens++;
                }
            }
        }
        return numFifteens;
    }

    public int getFifteensThree(List<Card> deck) {
        int numFifteens = 0;
        for (int i = 0; i < deck.size() - 2; i++) {
            for (int j = i + 1; j < deck.size() - 1; j++) {
                for (int k = j + 1; k < deck.size(); k++) {
                    if ((deck.get(i).getValue() + deck.get(j).getValue() + deck.get(k).getValue()) == 15) {
                        numFifteens++;
                    }
                }
            }
        }
        return numFifteens;
    }

    public int getFifteensFour(List<Card> deck) {
        int numFifteens = 0;
        for (int i = 0; i < deck.size() - 3; i++) {
            for (int j = i + 1; j < deck.size() - 2; j++) {
                for (int k = j + 1; k < deck.size() - 1; k++) {
                    for (int l = k + 1; l < deck.size(); l++) {
                        if ((deck.get(i).getValue() + deck.get(j).getValue()
                                + deck.get(k).getValue()) + deck.get(l).getValue() == 15) {
                            numFifteens++;
                        }
                    }
                }
            }
        }
        return numFifteens;
    }

    public int getFifteensFive(List<Card> deck) {
        int sum = 0;
        for (int i = 0; i < deck.size(); i++) {
            sum += deck.get(i).getValue();
        }
        if (sum == 15) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getPairsScore(List<Card> deck) {
        int numPairs = 0;
        for (int i = 0; i < deck.size() - 1; i++) {
            for (int j = i + 1; j < deck.size(); j++) {
                if (deck.get(i).getValue() == deck.get(j).getValue()) {
                    numPairs++;
                }
            }
        }
        return numPairs * 2;
    }

    public int getFlushScore(List<Card> deck) {
        List<Suit> suits = new ArrayList<>();
        //reads in card suits to a list
        for (int i = 0; i < deck.size(); i++) {
            suits.add(deck.get(i).getSuit());
        }

        if (suits.get(0) == suits.get(1) && suits.get(1) == suits.get(2) && suits.get(2) == suits.get(3) && suits.get(3) == suits.get(4)) {
            return 5;
        }

        //checks how many of the same suit are there
        for (int i = 0; i < deck.size() - 3; i++) {
            for (int j = i + 1; j < deck.size() - 2; j++) {
                for (int k = j + 1; k < deck.size() - 1; k++) {
                    for (int l = k + 1; l < deck.size(); l++) {
                        if (suits.get(i) == suits.get(j) && suits.get(j) == suits.get(k) && suits.get(k) == suits.get(l)) {
                            return 4;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int getKnobsScore(List<Card> deck, Card upCard) {
        List<Card> jacks = new ArrayList<>();
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getValue() == 11) {
                jacks.add(deck.get(i));
            }
        }

        for (int j = 0; j < jacks.size(); j++) {
            if (upCard.getSuit() == jacks.get(j).getSuit()) {
                return 1;
            }
        }
        return 0;
    }
}
