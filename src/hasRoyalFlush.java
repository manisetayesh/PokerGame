public class hasRoyalFlush {

    public static boolean hasRoyalFlush(Card[] h) {

        new sortBySuit(h);
        boolean a1;
        if(h[0].suit() == h[4].suit()) {

            new sortByRank(h);
            a1 = h[0].rank() == 10 &&
                    h[1].rank() == 11 &&
                    h[2].rank() == 12 &&
                    h[3].rank() == 13 &&
                    h[4].rank() == 14;
            return(a1);

        }
        else if(h[1].suit() == h[5].suit()) {

            new sortByRank(h);
            a1 = h[1].rank() == 10 &&
                    h[2].rank() == 11 &&
                    h[3].rank() == 12 &&
                    h[4].rank() == 13 &&
                    h[5].rank() == 14;
            return(a1);

        }
        else if(h[2].suit() == h[6].suit()) {

            new sortByRank(h);
            a1 = h[2].rank() == 10 &&
                    h[3].rank() == 11 &&
                    h[4].rank() == 12 &&
                    h[5].rank() == 13 &&
                    h[6].rank() == 14;
            return(a1);
        }
        else {
            return false;
        }
    }
}
