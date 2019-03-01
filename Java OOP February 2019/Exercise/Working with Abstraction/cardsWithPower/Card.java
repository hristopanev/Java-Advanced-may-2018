package cardsWithPower;

import cardRank.CardRank;
import cardSuit.CardSuit;

public class Card {
    private static final int[] RANK_POWER = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static final int[] SUIT_POWER = {0, 13, 26, 39};

    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int calculatePower() {

        return Card.RANK_POWER[this.cardRank.ordinal()] + Card.SUIT_POWER[this.cardSuit.ordinal()];
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.cardRank.toString(), this.cardSuit.toString(), this.calculatePower());
    }
}
