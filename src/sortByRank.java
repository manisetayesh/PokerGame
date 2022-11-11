public class sortByRank {
    /*Method name: sortByRank
     * Author: Mani setayesh
     * Description: Sorts a hand by the rank values of its cards (2-14)
     * Input: A hand of 7-cards
     * Output: sorted hand
     */
    public sortByRank(Card[] h){

        //Sequential sort algorithm
        int i, j, min;

        for ( i = 0 ; i < h.length ; i ++ ){

            min = i;

            for ( j = i+1 ; j < h.length ; j++ ){

                if (h[j].rank() < h[min].rank()){

                    min = j;

                }
            }

            Card temp = h[i];
            h[i] = h[min];
            h[min] = temp;
        }
    }
}
