/**
 * File: Simulation.java
 * Author: Hannah Soria
 * Date: 2/18/2022
 */


public class Simulation {
    
    public static void main(String[]args){ //Runs the same blackjackgame object 1000 times and records the results
        int playerTotal = 0;
        int dealerTotal = 0;
        int ties = 0;
        double totalGames = 1000;
        Blackjack blackjackGame = new Blackjack(10);

        for (int i=0; i < totalGames; i++){
            int game = blackjackGame.game(true);
            System.out.println(game);
            if (game == -1){
                dealerTotal += 1;
            }
            else if (game == 1){
                playerTotal += 1;
            }
            else{
                ties += 1;
            }
        }
        System.out.println("Total dealer wins: " + dealerTotal + "\n" + "Percentage of dealer wins: " + dealerTotal/totalGames * 100);
        System.out.println("Total player wins: " + playerTotal + "\n" + "Percentage of player wins: " + playerTotal/totalGames * 100);
        System.out.println("Total ties: " + ties + "\n" + "Percentage of ties: " + ties/totalGames * 100);

    
    }

    
}
