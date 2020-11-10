package tic_tac_toe;

import java.util.*;
// test anton rogalsko
public class Main {
    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am Zug ist
        int turn = 0;
        int winner = -2;
        char[][] leer = new char[1][1];
        String b_bot;
        boolean check = false;
        leer[0][0] = 'f';
        Board board = new Board(leer);
        Scanner scanner = new Scanner(System.in);
        Player a = new Player(0);
        Player b = new Player(1);
        System.out.println("Namen für ersten Spieler eingeben!");
        a.setName(scanner.next());

        while (!check){
            System.out.println("Gegen einen Bot spielen? [j/n]");
            b_bot = scanner.next();
            if(b_bot.equals("j")){
                b.setBot();
                System.out.println("Schwierigkeit einstellen: leicht(1) schwer(2)");
                b.setSchwierigkeit(scanner.nextInt());
                check = true;
            }else if(b_bot.equals("n")){
                System.out.println("Namen für zweiten Spieler eingeben!");
                b.setName(scanner.next());
                check = true;
            }else {
                System.out.println("Falsche Eingabe, bitte wiederholen!");
            }
        }

        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        char [][] tempboard = board.getInhalt();
        while(winner == -2){
            printBoard(board.getInhalt());
            int[] turnField = players[turn].getTurn(board.getInhalt());
            if (turnField == null){
                break;
            }
            if(players[turn].validateTurn(board.getInhalt(), turnField)){
                if(players[turn].number == 0){
                    tempboard[turnField[0]][turnField[1]] = 'O';
                }else{
                    tempboard[turnField[0]][turnField[1]] = 'X';
                }
                //modulo! 0 1 0 1 0 1 ... da nur zwei Spieler
                turn = ( turn + 1) % 2;
            }
            winner = Board.checkWinner(tempboard);
        }
        if(winner == 0){
            System.out.println(a.name + " hat gewonnen!");
        }else if (winner == 1){
            System.out.println(b.name + " hat gewonnen!");
        }
        else if(winner == -2 || winner == -1){
            System.out.println("Unentschieden!");
        }
    }

    public static void printBoard(char[][] meinBoard){
        System.out.println(meinBoard[0][0] + " | " + meinBoard[0][1] + " | " + meinBoard[0][2]);
        System.out.println("____________");
        System.out.println(meinBoard[1][0] + " | " + meinBoard[1][1] + " | " + meinBoard[1][2]);
        System.out.println("____________");
        System.out.println(meinBoard[2][0] + " | " + meinBoard[2][1] + " | " + meinBoard[2][2]);
    }

}
