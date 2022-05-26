public class Simulator {

	public static int[] hands = new int[10];

	public static void main(String []args){

		int i;
		Card[] hand = new Card[7];
		int b = 0;
		
		while(b!=100000) {
	   		Deck a = new Deck();
			a.shuffle(1000);
			
	   		for(i=0; i<7; i++) {
	   			hand[i] = a.deal();
	   		}
	   		
	   		if(hasRoyalFlush(hand)) {
	   			hands[0]++;
	   		}
	   	
	   		else if (hasStraightFlush(hand)) {
	   			hands[1]++;
	   		}
	      
	   		//Checks if hand has a 4-of-a-kind, returns value
	   		else if (has4s(hand)) {
	   			hands[2]++;
	   		}
	      
	   		//Check if hand has a full house, returns value
	   		else if (hasFullHouse(hand)) {
	   			hands[3]++;
	   		}
	      
	   		//check if the hand has a flush, returns value
	   		else if (hasFlush(hand)) {
	   			hands[4]++;
	   		}
	      
	   		//check if the hand has a straight, returns value
	   		else if (hasStraight(hand)) {
	   			hands[5]++;
	   		}
	      
	   		//Three-of-a-kind (also known as set)
	   		else if (has3s(hand)) {
	   			hands[6]++;
	   		}
	      
	   		//Two-pairs
	   		else if (has22s(hand)) {
	   			hands[7]++;
	   		}
	      
	   		//One pair
	   		else if (has2s(hand)) {
	   			hands[8]++;
	   		}
	      
	   		else {
	   			hands[9]++;
	   		}
	   		b++;
		}
	   	for(int j=0;j<10;j++) {
	   		System.out.println(hands[j]);
	   	}
	}
		
	public static boolean hasRoyalFlush(Card[] h) {
		
		sortBySuit(h);
		boolean a1;
		if(h[0].suit() == h[4].suit()) {
			
			sortByRank(h);
			a1 = h[0].rank() == 10 &&
				 h[1].rank() == 11 &&
				 h[2].rank() == 12 &&
				 h[3].rank() == 13 &&
				 h[4].rank() == 14;
			return(a1);
			
		}
		else if(h[1].suit() == h[5].suit()) {
			
			sortByRank(h);
			a1 = h[1].rank() == 10 &&
				 h[2].rank() == 11 &&
				 h[3].rank() == 12 &&
				 h[4].rank() == 13 &&
				 h[5].rank() == 14;
			return(a1);
			
		}
		else if(h[2].suit() == h[6].suit()) {
			
			sortByRank(h);
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
	//Please check the hasStraight and hasFlush methods first. This would make sense more then.
		public static boolean hasStraightFlush(Card[] h) {
			
			int testRank,i;
			sortBySuit(h);
			
			//This is, effectively, the has Straight method woven in with the hasFlush method
			
			//Check for where the flush is
			if(h[0].suit() == h[4].suit()) {
				
				//Sort by rank and see if there is a straight there
				sortByRank(h);
				
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
				sortByRank(h);
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
				sortByRank(h);
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
		/*Method name: hasFlush
		 * Author: Mani setayesh
		 * Description: Checks hand if it has a flush
		 * Input: A hand of 7-cards
		 * Output: Boolean value
		 */
		public static boolean hasFlush(Card[] h) {
			
			//Sort the hand by suit
			boolean hasflush = false;
			sortBySuit(h);
			
			//If the suit of card a and card a + 4 are the same, there is a flush
			//This is a 5-card gap, and if they are the same it would mean that all the middle cards are the same as well
			if(h[0].suit() == h[4].suit() || h[1].suit() == h[5].suit() || h[2].suit() == h[6].suit()) {
				hasflush = true;
			}
			return hasflush;
		}
		
		/*Method name: hasStraight
		 * Author: Mani setayesh
		 * Description: Checks hand if it has a straight
		 * Input: A hand of 7-cards
		 * Output: Boolean value
		 */
		public static boolean hasStraight(Card[] h) {
			
			//sort hand by rank, set up integers
			int testRank,i;
			sortByRank(h);
			
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
				 if(returner == false) {
					 returner = true;
					 testRank = h[1].rank() + 1;
					 for (i = 2; i < 6; i++){
		        	 
			            if (h[i].rank() != testRank) {
			            	returner = false;
			            }
			            testRank++;   
					 }
				 }
				 if(returner == false) {
					 
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
		/*Method name: has4s
		 * Author: Mani setayesh
		 * Description: Checks hand if it has a 4-of-a-kind
		 * Input: A hand of 7-cards
		 * Output: Boolean value
		 */
		public static boolean has4s(Card[] h) {
			 
			//sort by rank
			boolean a1, a2, a3, a4;
			sortByRank(h);
			
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
		
		//almost same deal as the 4s, with a little twist
		public static boolean hasFullHouse(Card[] h) {
			
			//Make sure the 4s have failed (there isn't a four-of-a-kind)
			if(has4s(h)) {
				return false;
			}
			//sort by rank and go through the options
			boolean a1,a2,a3,a4,a5;
			sortByRank(h);
			
			//Fix the triples, change the pair (note that the triple has && and the pair has ||)
			a1 = h[0].rank() == h[1].rank() &&
				 h[1].rank() == h[2].rank() &&
				 (h[3].rank() == h[4].rank() || h[4].rank() == h[5].rank() || h[5].rank() == h[6].rank());
			
			a2 = h[1].rank() == h[2].rank() &&
				 h[2].rank() == h[3].rank() && (h[4].rank() == h[5].rank() || h[5].rank() == h[6].rank());
			
			a3 = h[2].rank() == h[3].rank() &&
				 h[3].rank() == h[4].rank() &&
				 (h[0].rank() == h[1].rank() ||
				 h[5].rank() == h[6].rank());
			
			a4 = h[3].rank() == h[4].rank() &&
				 h[4].rank() == h[5].rank() &&
				 (h[0].rank() == h[1].rank() ||
				 h[1].rank() == h[2].rank());
			
			a5 =  h[4].rank() == h[5].rank() &&
				  h[5].rank() == h[6].rank() &&
				  (h[0].rank() == h[1].rank() ||
				  h[1].rank() == h[2].rank() ||
				  h[2].rank() == h[3].rank());
			
			return(a1||a2||a3||a4||a5);
		}
		
		//same deal
		public static boolean has3s(Card[] h) {
			
			//Make sure no four-of-a-kind, and no full house
			if ( has4s(h) || hasFullHouse(h) ) {
				return false;
			}
			
			//Sort and search for three consecutive indexes with the same value
			boolean a1,a2,a3,a4,a5;
			sortByRank(h);
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

		//Like the fullhouse searcher method
		public static boolean has22s(Card[] h) {
			
			boolean a1,a2,a3,a4;
			if (has4s(h) || hasFullHouse(h) || has3s(h)) {
		       return false;
			}
			sortByRank(h);

			a1 = h[0].rank() == h[1].rank() &&
				 (h[2].rank() == h[3].rank() ||
				 h[3].rank() == h[4].rank() ||
				 h[4].rank() == h[5].rank() ||
			     h[5].rank() == h[6].rank()) ;
			
			a2 = h[1].rank() == h[2].rank() &&
				 (h[3].rank() == h[4].rank() ||
				 h[4].rank() == h[5].rank() ||
			     h[5].rank() == h[6].rank()) ;
			
			a3 = h[2].rank() == h[3].rank() &&
				 (h[4].rank() == h[5].rank() ||
			     h[5].rank() == h[6].rank()) ;

			a4 = h[3].rank() == h[4].rank() &&
				 h[5].rank() == h[6].rank() ;
			
			return(a1||a2||a3||a4);
		}
		
		//Like previous methods
		public static boolean has2s(Card[] h) {
			
			boolean a1,a2,a3,a4,a5,a6;
			if (has4s(h) || hasFullHouse(h) || has3s(h) || has22s(h)) {
		       return false;
			}
			sortByRank(h);
			a1 = h[0].rank() == h[1].rank() ;
		    a2 = h[1].rank() == h[2].rank() ;
		    a3 = h[2].rank() == h[3].rank() ;
		    a4 = h[3].rank() == h[4].rank() ;
		    a5 = h[4].rank() == h[5].rank() ;
		    a6 = h[5].rank() == h[6].rank() ;
		    return( a1 || a2 || a3 || a4 || a5 || a6);
		    
		}
		/*Method name: sortByRank
		 * Author: Mani setayesh
		 * Description: Sorts a hand by the rank values of its cards (2-14)
		 * Input: A hand of 7-cards
		 * Output: sorted hand
		 */
		public static void sortByRank(Card[] h){
			 
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
		
		//same method, but instead of h[j].rank it is h[j].suit
		public static void sortBySuit(Card[] h){
			 
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
