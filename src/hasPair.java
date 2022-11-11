public class hasPair {

    public static boolean hasPair(Card[] h) {

        boolean a1,a2,a3,a4,a5,a6;
        if (has4OfAKind.has4OfAKind(h) || hasFullHouse.hasFullHouse(h) ||
                has3OfAKind.has3OfAKind(h) || has2pairs.has2pairs(h)) {
            return false;
        }
        new sortByRank(h);
        a1 = h[0].rank() == h[1].rank() ;
        a2 = h[1].rank() == h[2].rank() ;
        a3 = h[2].rank() == h[3].rank() ;
        a4 = h[3].rank() == h[4].rank() ;
        a5 = h[4].rank() == h[5].rank() ;
        a6 = h[5].rank() == h[6].rank() ;
        return( a1 || a2 || a3 || a4 || a5 || a6);

    }
}