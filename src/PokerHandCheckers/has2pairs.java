package PokerHandCheckers;
import Fundamentals.Card;
import Fundamentals.sortByRank;

public class has2pairs extends Checker {

    public static boolean check(Card[] h) {

        boolean a1,a2,a3,a4;
        if (has4OfAKind.check(h) || hasFullHouse.check(h) || has3OfAKind.check(h)) {
            return false;
        }
        new sortByRank(h);

        a1 = h[0].rank() == h[1].rank() &&
                (h[2].rank() == h[3].rank() ||
                        h[3].rank() == h[4].rank() ||
                        h[4].rank() == h[5].rank() ||
                        h[5].rank() == h[6].rank()) ;

        a2 = h[1].rank() == h[2].rank() &&
                (h[3].rank() == h[4].rank() ||
                        h[4].rank() == h[5].rank() ||
                        h[5].rank() == h[6].rank()) ;

        a3 = h[2].rank() == h[3].rank() &&
                (h[4].rank() == h[5].rank() ||
                        h[5].rank() == h[6].rank()) ;

        a4 = h[3].rank() == h[4].rank() &&
                h[5].rank() == h[6].rank() ;

        return(a1||a2||a3||a4);
    }
}
