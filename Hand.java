/**
 * File: Hand.java
 * Author: Hannah Soria
 * Date: 2/18/2022
 */

import java.util.ArrayList;
 //Meredith helped me debug this class
public class Hand { //class holds a set of cards
private ArrayList <Card> handList;
    
    public Hand(){ //initilaze the ArrayList
        handList = new ArrayList<Card>();
        
    }

    public void reset(){ //reset the hand to empty
        this.handList.clear();

    }

    public void add( Card card ){ //add the card object to the hand
        this.handList.add(card);

    }

    public int size(){//returns the number of cards in the hand
        return this.handList.size(); 
    }

    public Card getcard( int i ){// returns the card with index i. cast as apporproate
        Card pos = this.handList.get(i); 
        return pos;

    }

    public int getTotalValue(){//returns the sum of the values of the cards in the hand`
        int total = 0;
        for (int i=0; i< handList.size(); i++){
            total += getcard(i).getValue();
        }
        return total; 

    }

    public String toString(){ // returns a String that has the contents of the hand presented in a nice format 
        String string = "";
        for (int i = 0; i< this.handList.size(); i++){
            string += getcard(i).getValue();
            string += " ";
        }
        return "Contents of the hand: " + string;
    }

    public static void main(String[]args){
        Hand hand = new Hand();
        Card card1 = new Card(10); //test method
        Card card2 = new Card(5); //test method
        hand.add(card1); //test method
        hand.reset(); //test method
        hand.add(card2); //test method
        System.out.println(hand);//test method
        System.out.println(hand.size()); //test method
        System.out.println(hand.getcard(0)); //test method
        System.out.println(hand.getTotalValue()); //test method
        System.out.println(hand.toString()); //test method
    }
}