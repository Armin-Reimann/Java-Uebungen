package tic_tac_toe;

import java.util.Scanner;
public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);
    public Player(int number){
        this.number = number;
    }
    public int getTurn(){
        System.out.println("Player " + number + " - du bist am Zug!");
        int input = scanner.nextInt();
        if(input < 9 && input >= 0){
            return input;
        }
        System.out.println("Ungültige Eingabe, bitte nochmal probieren.");
        return getTurn();
    }
    public boolean validateTurn(char[] board, int turn){
        if(board[turn] == '-') {
            return true;
        }
        return false;
    }
}
