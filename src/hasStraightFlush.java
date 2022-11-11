public class hasStraightFlush {

    //Please check the hasStraight and hasFlush methods first. This would make sense more then.
    public static boolean hasStraightFlush(Card[] h) {

        int testRank,i;
        new sortBySuit(h);

        //This is, effectively, the has Straight method woven in with the hasFlush method

        //Check for where the flush is
        if(h[0].suit() == h[4].suit()) {

            //Sort by rank and see if there is a straight there
            new sortByRank(h);

            //This code was ripped from the hasStraight method (slightly modified)
            if (h[4].rank() == 14){

                boolean a = h[0].rank() == 2 && h[1].rank() == 3 && h[2].rank() == 4 && h[3].rank() == 5 ;
                boolean b = h[0].rank() == 10 && h[1].rank() == 11 && h[2].rank() == 12 && h[3].rank() == 13 ;

                return (a || b);
            }
            else {
                testRank = h[0].rank() + 1;

                for (i = 1; i < 5; i++){
                    if ( h[i].rank() != testRank )
                        return(false);
                    testRank++;
                }
                return(true);
            }
        }

        //Other possibilities of where the flush might be
        else if(h[1].suit() == h[5].suit()) {
            new sortByRank(h);
            if (h[5].rank() == 14){

                boolean a = h[1].rank() == 2 && h[2].rank() == 3 && h[3].rank() == 4 && h[4].rank() == 5 ;
                boolean b = h[1].rank() == 10 && h[2].rank() == 11 && h[3].rank() == 12 && h[4].rank() == 13 ;

                return ( a || b );
            }
            else {
                testRank = h[1].rank() + 1;

                for (i = 2; i < 6; i++){
                    if ( h[i].rank() != testRank )
                        return(false);
                    testRank++;
                }
                return(true);
            }
        }
        else if(h[2].suit() == h[6].suit()) {
            new sortByRank(h);
            if (h[6].rank() == 14){

                boolean a = h[2].rank() == 2 && h[3].rank() == 3 && h[4].rank() == 4 && h[5].rank() == 5 ;
                boolean b = h[2].rank() == 10 && h[3].rank() == 11 && h[4].rank() == 12 && h[5].rank() == 13 ;

                return ( a || b );
            }
            else {
                testRank = h[2].rank() + 1;

                for (i = 3; i < 7; i++){
                    if ( h[i].rank() != testRank )
                        return(false);
                    testRank++;
                }
                return(true);
            }
        }
        else {
            return false;
        }
    }
}
