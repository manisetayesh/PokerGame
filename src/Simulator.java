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
	   		
	   		if(hasRoyalFlush.hasRoyalFlush(hand)) {
	   			hands[0]++;
	   		}
	   	
	   		else if (hasStraightFlush.hasStraightFlush(hand)) {
	   			hands[1]++;
	   		}
	      
	   		//Checks if hand has a 4-of-a-kind, returns value
	   		else if (has4OfAKind.has4OfAKind(hand)) {
	   			hands[2]++;
	   		}
	      
	   		//Check if hand has a full house, returns value
	   		else if (hasFullHouse.hasFullHouse(hand)) {
	   			hands[3]++;
	   		}
	      
	   		//check if the hand has a flush, returns value
	   		else if (hasFlush.hasFlush(hand)) {
	   			hands[4]++;
	   		}
	      
	   		//check if the hand has a straight, returns value
	   		else if (hasStraight.hasStraight(hand)) {
	   			hands[5]++;
	   		}
	      
	   		//Three-of-a-kind (also known as set)
	   		else if (has3OfAKind.has3OfAKind(hand)) {
	   			hands[6]++;
	   		}
	      
	   		//Two-pairs
	   		else if (has2pairs.has2pairs(hand)) {
	   			hands[7]++;
	   		}
	      
	   		//One pair
	   		else if (hasPair.hasPair(hand)) {
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
}
