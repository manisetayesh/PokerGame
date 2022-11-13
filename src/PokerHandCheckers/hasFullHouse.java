package PokerHandCheckers;
import Fundamentals.Card;
import Fundamentals.sortByRank;
public class hasFullHouse extends Checker {


    //almost same deal as the 4s, with a little twist
    public static boolean check(Card[] h) {

        //Make sure the 4s have failed (there isn't a four-of-a-kind)
        if(has4OfAKind.check(h)) {
            return false;
        }
        //sort by rank and go through the options
        boolean a1,a2,a3,a4,a5;
        new sortByRank(h);

        //Fix the triples, change the pair (note that the triple has && and the pair has ||)
        a1 = h[0].rank() == h[1].rank() &&
                h[1].rank() == h[2].rank() &&
                (h[3].rank() == h[4].rank() || h[4].rank() == h[5].rank() || h[5].rank() == h[6].rank());

        a2 = h[1].rank() == h[2].rank() &&
                h[2].rank() == h[3].rank() && (h[4].rank() == h[5].rank() || h[5].rank() == h[6].rank());

        a3 = h[2].rank() == h[3].rank() &&
                h[3].rank() == h[4].rank() &&
                (h[0].rank() == h[1].rank() ||
                        h[5].rank() == h[6].rank());

        a4 = h[3].rank() == h[4].rank() &&
                h[4].rank() == h[5].rank() &&
                (h[0].rank() == h[1].rank() ||
                        h[1].rank() == h[2].rank());

        a5 =  h[4].rank() == h[5].rank() &&
                h[5].rank() == h[6].rank() &&
                (h[0].rank() == h[1].rank() ||
                        h[1].rank() == h[2].rank() ||
                        h[2].rank() == h[3].rank());

        return(a1||a2||a3||a4||a5);
    }
}
