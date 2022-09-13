package Lab01;

/**
 * File: Shuffle.java
 * Author: Hannah Soria
 * Date: 02/08/2022
 */

 import java.util.ArrayList;
 import java.util.Random;

public class Shuffle {
    
    public static void main(String[]args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> delNumbers = new ArrayList<Integer>();
        Random ran = new Random();
        for(int i=0; i<10; i++){
            arr.add(i+1);     
        }
        for(int i=0; i<10; i++){
            Integer x = arr.get(i);
            System.out.println(x);
        }
        for(int i=0; i<10; i++){
            int del = ran.nextInt(arr.size());
            int removedVal = arr.remove(del);
            delNumbers.add(removedVal);
            System.out.println("removed number = " + del);
            System.out.println("array = " + arr);
        }
        System.out.println("new array = " + delNumbers);
    }
}
