public class has4OfAKind {

    /*Method name: has4s
     * Author: Mani setayesh
     * Description: Checks hand if it has a 4-of-a-kind
     * Input: A hand of 7-cards
     * Output: Boolean value
     */
    public static boolean has4OfAKind(Card[] h) {

        //sort by rank
        boolean a1, a2, a3, a4;
        new sortByRank(h);

        //check to see if any 4 consecutive cards have the same rank
        a1 = h[0].rank() == h[1].rank() &&
                h[1].rank() == h[2].rank() &&
                h[2].rank() == h[3].rank();

        a2 = h[1].rank() == h[2].rank() &&
                h[2].rank() == h[3].rank() &&
                h[3].rank() == h[4].rank();

        a3 = h[2].rank() == h[3].rank() &&
                h[3].rank() == h[4].rank()&&
                h[4].rank() == h[5].rank();

        a4 = h[3].rank() == h[4].rank() &&
                h[4].rank() == h[5].rank() &&
                h[5].rank() == h[6].rank();

        //return true or false if they do
        return(a1||a2||a3||a4);
    }
}
