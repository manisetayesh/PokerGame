/*************************
 * Document details:
 * Name: Deck.java
 * Author: Mani Setayesh
 * Date: 9/11/2020
 * Description: A deck object - contains a 52-length card array, fills in the array with proper values,
 * will be able to shuffle the 52 cards, then deal one card at a time.
 * Input: N/A
 * Output: N/A
 *************************/

public class Deck{
	
	/* Setting up the deck (card array), the total number of cards, and an integer used to keep track
	 * of the current card in possession. This will help eliminate recounting a card.
	 */
	public static final int Cards = 52;
	private Card[] deckofcards;
	private int currentCard;
	
	/***************
	 * Object name: Deck
	 * Purpose: Sets up a deck of 52 cards, then fills in the deck with proper suits and ranks.
	 ***************/
	public Deck(){
		
		/*Setting up the array, with a counter for later situations*/
		deckofcards = new Card[Cards]; 
		int i = 0;
		
		/*Going through suits from lowest value to highest value*/
		for(int suit = Card.DIAMOND; suit <= Card.SPADE; suit++) {
			
			/*Going through the ranks of a suit, from Ace to King*/
			for (int rank = 1; rank <= 13; rank++) {
				
				//Filling up the array, one at a time with Card objects
		   		deckofcards[i++] = new Card(suit, rank);
			}
			
		}
		
	}

	/*Method name: Deal
	 * Input: deck of cards array of 52 cards
	 * Output: a Card from the deck of cards
	 * Description: It goes through the deck, returning the card values from the indexes of the deck.
	 */
	public Card deal(){
		
		//Checks to see if the current card is not equal to the total number of cards
		if (currentCard < Cards){
			
			//If it isn't, return the card after the current card value
			return (deckofcards[currentCard++]);
		}
		
		//If it is, return no cards remain.
		else{
			System.out.println("Out of cards error");
			return ( null ); 
		}
    }
	
	/*Method name: Shuffle
	 * Input: deck of cards + integer number for looping purposes
	 * Output: Shuffled deck of cards
	 * Description: Takes in a number and the deck. It will switch two random cards of the deck. Then another 
	 * two random cards. It keeps going until 2n amount of cards have been switched.
	 */
	public void shuffle(int n){
		
		//Set up counters
		int i,j,k;

		//Large loop: for k until it reaches n going up by one:
		for (k = 0; k < n; k++){
		  
			//pick two random numbers from 1-52
			i = (int) (Cards * Math.random());   
			j = (int) (Cards * Math.random());  

			//Switch the cards in those two indexes
			Card tmp = deckofcards[i];
			deckofcards[i] = deckofcards[j];
			deckofcards[j] = tmp;
		}

		//Set currentCard value to 0 (for the deal method - a deck is shuffled before dealing
		currentCard = 0;
      
	}
	
}