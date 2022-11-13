package PokerHandCheckers;
import Fundamentals.Card;
import Fundamentals.sortBySuit;
public class hasFlush extends Checker {

    /*Method name: PokerHandCheckers.hasFlush
     * Author: Mani setayesh
     * Description: Checks hand if it has a flush
     * Input: A hand of 7-cards
     * Output: Boolean value
     */
    public static boolean check(Card[] h) {

        //Sort the hand by suit
        boolean hasflush = false;
        new sortBySuit(h);

        //If the suit of card a and card a + 4 are the same, there is a flush
        //This is a 5-card gap, and if they are the same it would mean that all the middle cards are the same as well
        if(h[0].suit() == h[4].suit() || h[1].suit() == h[5].suit() || h[2].suit() == h[6].suit()) {
            hasflush = true;
        }
        return hasflush;
    }
}
