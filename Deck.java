/**
 * File: Deck.java
 * Author: Hannah Soria
 * Date: 2/18/2022
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck{ //Meredith helped me debug this class
    //private Card i;
    private Card topCard;
    private ArrayList <Card> deckList;

    public Deck(){ //builds a deck of 52 cards, 4 each of cards with values 2-9 and 11, and 16 cards with the value 10. Note, you probably want the constructor to call the build() method, below.
        deckList = new ArrayList <Card> ();
        build();
    }
    
    public void build() { // builds a deck of 52 cards, 4 each of cards with values 2-9 and 11, and 16 cards with the value 10.
        
        for(int i = 2; i < 12; i ++){
            for (int j = 0; j < 4; j ++){
                Card card = new Card(i);
                this.deckList.add(card);
            }
        }


        for (int j = 0; j < 14; j++){
            Card card2 = new Card(10);
            this.deckList.add(card2);}}

    public int size() { // returns the number of cards in the deck.
        return this.deckList.size(); 
    }

    public Card deal() { // returns the top card (position zero) and removes it from the deck.
        topCard = this.deckList.remove(0);
        return topCard;
    }

    public Card pick( int i) { //(optional) returns the card at positio//n i and removes it from the deck.
        return this.deckList.remove(i);
    }

    public void shuffle(){ // shuffles the deck. This method should put the deck in random order
        Random ran = new Random();
        ArrayList<Card> delNumber = new ArrayList<Card>();
        int size = this.deckList.size();

        for (int i = 0; i < size; i++){
            int remove = ran.nextInt(this.deckList.size());
            Card removedValue = this.deckList.remove(remove);
            delNumber.add(removedValue);
        }
        deckList = delNumber;
    }


    public String toString(){ // returns a String that has the contents of the deck "written" in a nice format (so that you can see the ordering of the card values).
        String s = " ";
        for (int i = 0; i < this.deckList.size(); i++){
            s += this.deckList.get(i).getValue();
        }
        return "Size of the deck: " + s + " ";
    }
    
    public static void main(String[]args){
        Deck deck = new Deck();
        System.out.println(deck); //test method
        deck.size(); //test method
        deck.deal(); //test method
        deck.shuffle(); //test method
        System.out.println(deck); //test method

    }

}
