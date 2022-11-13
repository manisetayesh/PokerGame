package Fundamentals;

public class sortBySuit {
    public sortBySuit(Card[] h) {
        int i, j, min;

        for ( i = 0 ; i < h.length ; i ++ ){

            min = i;

            for ( j = i+1 ; j < h.length ; j++ ){

                if (h[j].suit() < h[min].suit()){

                    min = j;

                }
            }

            Card temp = h[i];
            h[i] = h[min];
            h[min] = temp;
        }
    }
}
