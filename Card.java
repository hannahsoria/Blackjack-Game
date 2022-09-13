/**
 * File: Card.java
 * Author: Hannah Soria
 * Date: 2/18/2022
 */
import java.util.Random;

//Gretchen helped me with the toString
public class Card { //class holds all of the information unique to the card: value of the card (2-11)
    private int v;

    public Card(int value){ //constructor with the value of the card, possibly doing range checking
    v = value;
    }

    public int getValue(){//return the numeric value of the card
        return v; 
    }

    public String toString(){//return a string that represents the object. this will overrride the default toString method in obj class
        String s = "value of the card is: ";
        s = s + v; 
        return s;
    }
    public static void main(String[]args){
        Random ran = new Random();
        Card test = new Card(ran.nextInt(10)+2); //test method
        System.out.println(test.getValue());//test method
        System.out.println(test.toString());//test method
    }

}