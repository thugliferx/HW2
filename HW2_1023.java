
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * 學號: B0444247
 * 姓名: 陳彥廷
 */
public class HW2_1023 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("input N(deck of cards):");
		String testn= keyboard.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO(finish): please check your output, make sure that you print all cards on your screen
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>8||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/*
 * Description: TODO(finish): 處理要輸出幾副牌的class，並有printDeck(印出幾副牌)、
 * 							  ArrayList<Card>(把每張排放到一陣列ALLCARD) getAllCards的兩種instance方法
 *                            
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO(finish): Please implement the constructor
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		for(int i=1;i<=nDeck;i++){
			for(int x=1;x<=4;x++){
				for(int y=1;y<=13;y++){
					Card card=new Card(x,y);
					cards.add(card);
				}
			}
		}
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end

	}	
	//TODO(finish): Please implement the method to print all cards on screen
	public void printDeck(){
		for(int index=0;index<cards.size();index++){
			Card account = cards.get(index);
			account.printCard();
		}
		//Hint: print all items in ArrayList<Card> cards, 
		//please implement and reuse printCard method in Card class

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/*
 * Description: TODO(finish): 處理每副牌的花色、點數的class，並有printCard、getSuit
 * 							  、getRank的三種instance方法。			
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO(finish): 1. Please implement the printCard method
	public void printCard(){
		System.out.println(suit+","+rank);
			
		
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}