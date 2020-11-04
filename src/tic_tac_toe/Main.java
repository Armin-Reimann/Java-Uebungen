package tic_tac_toe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am Zug ist
        int turn = 0;
        int winner = -2;
        char[] leer = new char[1];
        leer[0] = 'f';
        Board board = new Board(leer);
        Scanner scanner = new Scanner(System.in);
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

        while(winner == -2){
            System.out.println("winner:");
            System.out.println(winner);
            printBoard(board.getInhalt());
            int turnField = players[turn].getTurn(board.getInhalt());
//            if (turnField == -10){
//                System.out.println("turnField");
//                System.out.println(turnField);
//                break;
//            }
            //todo anscheinend kann man ein Objekt während der Schleife nicht verändern, deswegen alle sachen vorher mit getInhalt holen,
            // und dann in der schleife nur temporär bearbeiten, damit man es dann später mit einer set-Methode wieder setzen kann
            if(players[turn].validateTurn(board.getInhalt(), turnField)){
                if(players[turn].number == 0){
                    board.setInhalt(turnField, 'O');
                }else{
                    board.setInhalt(turnField, 'X');
                }
                //modulo! 0 1 0 1 0 1 ... da nur zwei Spieler
                turn = ( turn + 1) % 2;
            }
            winner = board.checkWinner();
        }
        System.out.println("winner2:");
        System.out.println(winner);
        if(winner == 0){
            System.out.println(a.name + " hat gewonnen!");
        }else if (winner == 1){
            System.out.println(b.name + " hat gewonnen!");
        }
//        else if(winner == -1){
//            System.out.println("Unentschieden!");
//        }
    }

    public static void printBoard(char[] meinBoard){
        System.out.println(meinBoard[0] + " | " + meinBoard[1] + " | " + meinBoard[2]);
        System.out.println("____________");
        System.out.println(meinBoard[3] + " | " + meinBoard[4] + " | " + meinBoard[5]);
        System.out.println("____________");
        System.out.println(meinBoard[6] + " | " + meinBoard[7] + " | " + meinBoard[8]);
    }
}
