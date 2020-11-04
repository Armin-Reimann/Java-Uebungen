package tic_tac_toe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am Zug ist
        int turn = 0;
        int winner = -1;
//        char[] board = new char[9]; //Array mit 9 Feldern
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
//        Arrays.fill(board.getInhalt(), '-');
        Player a = new Player(0);
        Player b = new Player(1);
        System.out.println("Namen für ersten Spieler eingeben!");
        a.setName(scanner.next());
        System.out.println("Gegen einen Bot spielen? [j/n]");
        String b_bot = scanner.next();
        if(b_bot.equals("j")){
            b.setBot();
            System.out.println("Schwierigkeit einstellen: leicht(1) schwer(2)");
            b.setSchwierigkeit(scanner.nextInt());
        }else{
            System.out.println("Namen für zweiten Spieler eingeben!");
            b.setName(scanner.next());
        }
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        while(winner == -1){
            printBoard(board.getInhalt());
            int turnField = players[turn].getTurn(board.getInhalt());
            if(players[turn].validateTurn(board.getInhalt(), turnField)){
                if(players[turn].number == 0){
//                    board.getInhalt()[turnField] = 'O';
                    board.setInhalt(turnField, 'O');
                }else{
//                    board.getInhalt()[turnField] = 'X';
                    board.setInhalt(turnField, 'X');
                }
                //modulo! 0 1 0 1 0 1 ... da nur zwei Spieler
                turn = ( turn + 1) % 2;
            }
            winner = board.checkWinner();
//            winner = checkWinner(board.getInhalt());
        }
        if(winner == 0){
            System.out.println(a.name + " hat gewonnen!");
        }else{
            System.out.println(b.name + " hat gewonnen!");
        }

    }
//    public static int checkWinner(char[] board){
//        //Horizontal (Zeilen)
//        int winner = -1;
//        if(board[0] == board[1] && board[0] == board[2] && board[0] != '-'){
//            winner = board[0];
//        }
//        else if(board[3] == board[4] && board[3] == board[5] && board[3] != '-'){
//            winner = board[3];
//        }
//        else if(board[6] == board[7] && board[6] == board[8] && board[6] != '-'){
//            winner = board[6];
//            //Senkrecht (Spalten)
//        }
//        else if(board[0] == board[3] && board[0] == board[6] && board[0] != '-'){
//            winner = board[0];
//        }
//        else if(board[1] == board[4] && board[1] == board[7] && board[1] != '-'){
//            winner = board[1];
//        }
//        else if(board[2] == board[5] && board[2] == board[8] && board[2] != '-'){
//            winner = board[2];
//            //Diagonal
//        }
//        else if(board[0] == board[4] && board[0] == board[8] && board[0] != '-'){
//            winner = board[0];
//        }
//        else if(board[2] == board[4] && board[2] == board[6] && board[2] != '-'){
//            winner = board[2];
//        }
//        if(winner == 88){ // wegen ASCII
//            winner = 1;
//        }else if(winner == 79){
//            winner = 0;
//        }
//        return winner;
//    }
    public static void printBoard(char[] meinBoard){
        System.out.println(meinBoard[0] + " | " + meinBoard[1] + " | " + meinBoard[2]);
        System.out.println("____________");
        System.out.println(meinBoard[3] + " | " + meinBoard[4] + " | " + meinBoard[5]);
        System.out.println("____________");
        System.out.println(meinBoard[6] + " | " + meinBoard[7] + " | " + meinBoard[8]);
    }
}
