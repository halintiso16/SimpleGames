// Hanqaamo A Lintiso

import java.util.Scanner;
import java.util.regex.*;


public class Tic_Tac_Toe_Game {


    public static void main(String [] arg){
        gamePlay();
    }

    public static void gamePlay(){
        GameObjective();
        System.out.println("Let's Play Tic-Tac-Toe!\n");
        String GameArena[][] = { {"*","*","*"}, {"*","*","*"}, {"*","*","*"} };   //initialize table
        String [] Players;
        Players = new String[] {"X","0"};                              // Players X and 0
        int index = 0;                                                 // index needed to switch between players
        int turns = 0;                                                 // counts each turn before a draw
        boolean win = false;
        while(true){
            System.out.println("Game: In Progress\n");                 // State of the game
            print(GameArena);                                          // Always print the tic-tac-toe table to show its state
            System.out.println(Players[index]+", your Turn\n");
            System.out.print("$> ");                                   // Denotes the command line waiting for the user to enter text.
            String [] coordinate = isValid();                          // Calls method for valid
            int row = Integer.parseInt(coordinate[0]);                 // Stores row as an integer
            int col = Integer.parseInt(coordinate[1]);                 // Stores column as an integer
            if(GameArena[row][col] == "*") {                           // Only input if coordinate is has not been used
                GameArena[row][col] = Players[index];
                if(turns >= 4) {
                    win = DetermineWin(GameArena, row, col);            // Calls another method to determine win after a win can occur
                }
                turns++;                                                // increments at each turn
                if(win == true){                                        // Checks for a win
                    System.out.println("Game: Win\n");
                    System.out.println(Players[index] + " Won the game\n");
                    print(GameArena);
                    break;
                }
                if(turns > 8){
                    System.out.println("Game: Draw\n");
                    print(GameArena);
                    break;
                }
                index = index < 1 ? 1 : 0;                                          // Makes the switch between players
            }
            else{
                System.out.println("Coordinate taken, Please try again!!!\n");      // Let the user know if user inputs a non-null coordinate
            }

        }
        System.out.println("### Program Terminates ###");                           // Game is Over

    }


    public static boolean DetermineWin(String [][] GameArena,int row,int col){      //Method that checks if a win occurred

        String Player = GameArena[row][col];

        if (Player.equals(GameArena[row][0]) && Player.equals(GameArena[row][1]) && Player.equals(GameArena[row][2])){
            return true;
        }
        if(Player.equals(GameArena[0][col]) && Player.equals(GameArena[1][col]) && Player.equals(GameArena[2][col])){
            return true;
        }
        if(Player.equals(GameArena[0][0]) && Player.equals(GameArena[1][1]) && Player.equals(GameArena[2][2])){
            return true;
        }
        if(Player.equals(GameArena[0][2]) && Player.equals(GameArena[1][1]) && Player.equals(GameArena[2][0])){
            return true;
        }
        return false;
    }

    public static String [] isValid(){                                              //Method returns array of valid coordinate positions
        while(true) {
            String inputFormat = "^\\s*+[0-2]\\s*+,\\s*+[0-2]\\s*+$";               //rules how inputs must be entered
            Scanner userInput = new Scanner(System.in);
            String readInput = userInput.nextLine();
            System.out.println();                                                   // print statement used to create newline for clean view on terminal
            boolean isValid = Pattern.matches(inputFormat,readInput);               //checks if user input aligns with rules
            if (!isValid) {
                System.out.print("Invalid Input: Please input valid integer coordinate positions\n" +
                    "Coordinate position begin at 0,0 and ends at 2,2 \n" +
                    "Example of a valid coordinate position: 0,1\n\n$> ");
            } else {
                String NoSpaces = readInput.replaceAll("\\s+","");
                String [] coordinate = NoSpaces.split(",");
                return coordinate;
            }
        }
    }

    public static void GameObjective(){
        System.out.println("Objective: The object of Tic Tac Toe is to get three in a row.\n" +
            "You play on a three by three game board. The first player is known as X and the second is 0.\n" +
            "Players alternate placing Xs and 0s on the game board until either oppent has three in a " +
            "row or all nine squares are filled.\nInput Direction: Input accepts integer coordinate positions seperated by a comma.\n" +
            "The table begin at the origin 0,0 and ends at 2,2. Anything outside of these coordinate positions is considered invalid.\n" +
            "EX of valid coordinate position: 0,2 | 1,1 | 2,1\n");

        System.out.println("----------------------------------------------------------------------------\n");
    }


    public static void print(String [][] GameArena){                            // Displays table
        for (int row = 0; row < GameArena.length; row++){
            for (int col = 0; col < GameArena.length; col++){
                System.out.print(GameArena[row][col] + " ");
            }
            System.out.println("\n");


        }
    }


}
