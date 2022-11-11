public class hasStraight {

    /*Method name: hasStraight
     * Author: Mani setayesh
     * Description: Checks hand if it has a straight
     * Input: A hand of 7-cards
     * Output: Boolean value
     */
    public static boolean hasStraight(Card[] h) {

        //sort hand by rank, set up integers
        int testRank,i;
        new sortByRank(h);

        //check for ace cases at the top 3 locations. A straight can be "A,2,3,4,5" and "A,K,Q,J,10".
        if (h[4].rank() == 14){

            boolean a = h[0].rank() == 2 && h[1].rank() == 3 && h[2].rank() == 4 && h[3].rank() == 5 ;
            boolean b = h[0].rank() == 10 && h[1].rank() == 11 && h[2].rank() == 12 && h[3].rank() == 13 ;

            return ( a || b );
        }
        if (h[5].rank() == 14){

            boolean a = h[1].rank() == 2 && h[2].rank() == 3 && h[3].rank() == 4 && h[4].rank() == 5 ;
            boolean b = h[1].rank() == 10 && h[2].rank() == 11 && h[3].rank() == 12 && h[4].rank() == 13 ;

            return ( a || b );

        }
        if (h[6].rank() == 14){

            boolean a = h[2].rank() == 2 && h[3].rank() == 3 && h[4].rank() == 4 && h[5].rank() == 5 ;
            boolean b = h[2].rank() == 10 && h[3].rank() == 11 && h[4].rank() == 12 && h[5].rank() == 13 ;

            return ( a || b );

        }

        else {

            boolean returner = true;
            testRank = h[0].rank() + 1;
            for (i = 1; i < 5; i++){

                if (h[i].rank() != testRank) {
                    returner = false;
                }
                testRank++;
            }
            if(!returner) {
                returner = true;
                testRank = h[1].rank() + 1;
                for (i = 2; i < 6; i++){

                    if (h[i].rank() != testRank) {
                        returner = false;
                    }
                    testRank++;
                }
            }
            if(!returner) {

                returner = true;
                testRank = h[2].rank() + 1;
                for (i = 3; i < 7; i++){

                    if (h[i].rank() != testRank) {
                        returner = false;
                    }
                    testRank++;
                }
            }
            return returner;
        }
    }
}
