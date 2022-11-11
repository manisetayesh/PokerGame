

	/*************************
	 * Document details:
	 * Name: Card.java
	 * Author: Mani Setayesh
	 * Date: 9/11/2020
	 * Description: A card object - with suit and rank definitions + methods on how to get 
	 * a card's suit, rank, suit-string and rank-string
	 * Input: N/A
	 * Output: N/A
	 *************************/

	public class Card{

		/*Making suits, each with their own value. Values are determined from the internet.
		 * (spade is worth more than diamond, etc.)
		 */
		public static final int SPADE   = 4;
		public static final int HEART   = 3;
		public static final int CLUB    = 2;
		public static final int DIAMOND = 1;

		/*Two arrays, for the card's suit and rank (string format, not value)
		 * there has been an error marker placed at the beginning to solve the outofbounds.issue
		 */
		private static final String[] Suit = {"*", "diamonds", "clubs", "hearts", "spades"};
	    private static final String[] Rank = {"*", "*", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};  
	    
	    //Two bytes - holding the card's suit and rank
	    private byte cardSuit;
	    private byte cardRank;
	    
	    /***********
	     * Object name: Card
	     * @param suit: integer value of the suit (from 1-4) of the card
	     * @param rank: integer value of the rank (from 1-13) of the card
	     * Input: parameters
	     * Output: card
	     * Description: Checks for aces (value 14 not 1), creates a card with the rank and the suit (byte)
	     ***********/
	    public Card(int suit, int rank){
	    	
	    	if (rank == 1) {
	    		cardRank = 14;    
	    	}
	    	else {
	    		cardRank = (byte) rank;
	    	}
	 	 
	    	cardSuit = (byte) suit;
	    }
	    
	    //Suit method - returns card's suit's value (integer, used for computing)
	    public int suit(){
	    	
	    	return (cardSuit);
	    	
	    }

	    //Suit String method - returns card's suit's name (String, used for display)
	    public String suitStr(){
	    	
	    	return(Suit[cardSuit]); 
	    
	    }
	  
	    //Rank method - returns card's value (integer)
	    public int rank(){
	    	
	    	return (cardRank);
	    	
	    }

	    //Rank String method - returns card's name (String from two to ace - for display)
	    public String rankStr(){
	    	
	       return (Rank[cardRank]);
	       
	    }

	}
