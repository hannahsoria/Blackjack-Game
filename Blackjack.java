/**
 * File: Blackjack.java
 * Author: Hannah Soria
 * Date: 2/18/2022
**/

public class Blackjack{ //In this class Anna helped me debug a lot of it and build the game method
    private Hand player1;
    private Hand dealer;
    private Deck deck;
    private int cutOff;

    public Blackjack ( int reshuffleCutoff ){ // the constructor should store the reshuffleCuttoff and set up a game
        player1 = new Hand();
        dealer = new Hand();
        deck = new Deck();
        cutOff = reshuffleCutoff;
    }

    public void reset(){ // should reset the game. both the player hand and the dealer hand should start with no cards.if the number of cards in the deck in less than the reshuffle cutoff - method create a complete set. otherwise do not modify just clear player and dealer hands
        this.deck.shuffle();
        this.player1.reset();
        this.dealer.reset();
        if (this.cutOff > this.deck.size()){
            this.deck.build();
            this.deck.shuffle();
        }
    }

    public void deal() { // should deal out two cards to both player from the deck
        player1.add(deck.deal());
        dealer.add(deck.deal());
        player1.add(deck.deal());
        dealer.add(deck.deal());

    }

    public boolean playerTurn(){// have the player draw cards until the total value of the players hand is equal or above 16. return false if over 21
        while (player1.getTotalValue() < 16){
            player1.add(deck.deal());
            
        }
        if (player1.getTotalValue() > 21){
            return false;

        }
        else {
            return true;
        }
    }

    public boolean dealerTurn(){ // have the player draw cards until the total value is equal or above 17. method should return false if dealer goes over 21
        while (dealer.getTotalValue() < 17){
            dealer.add(deck.deal());
        }
        if (dealer.getTotalValue() > 21){
            return false;
        }
        else {
            return true;
        }
    }

    public void setReshuffleCutoff( int cutoff ){ // should assign the new cutoff value to the internal reshuffle cutoff field.
        cutOff = cutoff;
    }

    public int getReshuffleCutoff(){ //returns the current value of the reshuffle cutoff field.
        return this.cutOff;
    }

    public String toString(){ // returns a String that represents the state of the game. show the player and dealer hands as well as their current total value
        String s = "";
        s += "The players hand total: " + player1.getTotalValue() + "\n";
        s += player1.toString()+ "\n"; 
        s += "The dealers hand total: " + dealer.getTotalValue() + "\n";
        s += dealer.toString();
        return s;
    }

    public int game(boolean verbose){//the game method should play a single game of Blackjack. Calls the reset method at the start of each game. Returns a -1 if the dealer wins, 0 in case of a push (tie), and a 1 if the player wins.
        reset();
        deal();
        boolean playerT = playerTurn();
        boolean dealerT = true;
        if (playerT == true){
            dealerT = dealerTurn();
        }
        
        if (playerT & dealerT == false){
            return 1;

        }
        else if (dealerT & playerT == false){
            return -1;

        }
        else {
            if (player1.getTotalValue() < dealer.getTotalValue()){
                return -1;
            }
            else if (player1.getTotalValue() > dealer.getTotalValue()){
                return 1;
            }
            return 0; //Prof. Wolfe helped me figure out how to make the dealer win more
        }
        
    }

    public static void main(String[]args){
        Blackjack blackjack = new Blackjack(10);
        System.out.println(blackjack.game(true));
        System.out.println(blackjack);
        System.out.println(blackjack.game(true));
        System.out.println(blackjack);
        System.out.println(blackjack.game(true));
        System.out.println(blackjack);
    }
}
