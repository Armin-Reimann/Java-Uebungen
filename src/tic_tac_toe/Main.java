package tic_tac_toe;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am Zug ist
        int turn = 0;
        int winner = -1;
        char[] board = new char[9]; //Array mit 9 Feldern
        //For Schleife
        Arrays.fill(board, '-');
        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        while(winner == -1){
            printBoard(board);
            int turnField = players[turn].getTurn();
            if(players[turn].validateTurn(board, turnField)){
                if(players[turn].number == 0){
                    board[turnField] = 'O';
                }else{
                    board[turnField] = 'X';
                }

                //modulo! 0 1 0 1 0 1 ... da nur zwei Spieler
                turn = ( turn + 1) % 2;
            }
            winner = checkWinner(board);
        }
        System.out.println("Spieler " + winner + " hat gewonnen!");
    }
    public static int checkWinner(char[] board){
        //Horizontal (Zeilen)
        int winner = -1;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != '-'){
            winner = board[0];
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != '-'){
            winner = board[3];
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[6] != '-'){
            winner = board[6];
            //Senkrecht (Spalten)
        }
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != '-'){
            winner = board[0];
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[1] != '-'){
            winner = board[1];
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[2] != '-'){
            winner = board[2];
            //Diagonal
        }
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != '-'){
            winner = board[0];
        }
        else if(board[2] == board[4] && board[2] == board[6] && board[2] != '-'){
            winner = board[2];
        }
        if(winner == 88){ // wegen ASCII
            winner = 1;
        }else if(winner == 79){
            winner = 2;
        }
        return winner;
    }
    public static void printBoard(char[] meinBoard){
        System.out.println(meinBoard[0] + " | " + meinBoard[1] + " | " + meinBoard[2]);
        System.out.println("____________");
        System.out.println(meinBoard[3] + " | " + meinBoard[4] + " | " + meinBoard[5]);
        System.out.println("____________");
        System.out.println(meinBoard[6] + " | " + meinBoard[7] + " | " + meinBoard[8]);
    }
}
