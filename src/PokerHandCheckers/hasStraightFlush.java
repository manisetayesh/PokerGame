package PokerHandCheckers;
import Fundamentals.Card;

public class hasStraightFlush extends Checker {
    public static boolean check(Card[] h) {

        return hasStraight.check(h) && hasFlush.check(h) && !hasRoyalFlush.check(h);
    }
}
