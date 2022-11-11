public class has3OfAKind {

    public static boolean has3OfAKind(Card[] h) {

        //Make sure no four-of-a-kind, and no full house
        if (has4OfAKind.has4OfAKind(h) || hasFullHouse.hasFullHouse(h) ) {
            return false;
        }

        //Sort and search for three consecutive indexes with the same value
        boolean a1,a2,a3,a4,a5;
        new sortByRank(h);
        a1 = h[0].rank() == h[1].rank() &&
                h[1].rank() == h[2].rank();

        a2 = h[1].rank() == h[2].rank() &&
                h[2].rank() == h[3].rank();

        a3 = h[2].rank() == h[3].rank() &&
                h[3].rank() == h[4].rank();

        a4 = h[3].rank() == h[4].rank() &&
                h[4].rank() == h[5].rank();

        a5 = h[4].rank() == h[5].rank() &&
                h[5].rank() == h[6].rank();

        return(a1||a2||a3||a4||a5);

    }
}
