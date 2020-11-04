package tic_tac_toe;

import java.util.Scanner;
public class Player {
    int number;
    boolean bot = false;
    Scanner scanner = new Scanner(System.in);
    public Player(int number){
        this.number = number;
    }
    public void setBot(){
        this.bot = true;
    }
    public int getTurn(char[] board){
        System.out.println("Spieler " + number + " - du bist am Zug!");
        if(this.bot){
            return this.getBotTurn(board);
        }else{
            int input = scanner.nextInt();
            if(input < 9 && input >= 0){
                return input;
            }
            System.out.println("Ungültige Eingabe, bitte nochmal probieren.");
            return getTurn(board);
        }

    }
    protected int getBotTurn(char[] board){
        for(int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }
        return 1;
    }
    public boolean validateTurn(char[] board, int turn){
        return board[turn] == '-';
    }
}
