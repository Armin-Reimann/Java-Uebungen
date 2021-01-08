package celine_code;

import syntaxerror.AsciiArt;
import syntaxerror.Board;
import syntaxerror.Computerplayer;
import syntaxerror.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int turn = 0; //Spieler
        String winner = "-";

        // Spielfeld erstellen
        syntaxerror.Board t = new Board();

        syntaxerror.AsciiArt.printTicTacToe();

        syntaxerror.Player[] players = erstelleSpieler();

        players[0].setName();
        players[1].setName();

        // Schleife läuft solange es keinen Gewinner gibt
        while (winner.equals("-")) {
            //Spielfeld wird ausgegeben
            t.printBoard();

            int[] turnField = players[turn].getTurn(t);
            if (t.validateTurn(turnField)) {
                t.setFeld(turnField, players[turn].getZeichen());
                turn = (turn + 1) % 2;
            }
            winner = t.checkWinner();
            syntaxerror.AsciiArt.printLeerzeilen(30);
        }
        t.printBoard();
        if (winner.equals("F")) {
            System.out.println("Unentschieden!");

        } else {
            if (players[0].getZeichen().equals(winner)) {
                System.out.println("Herzlichen Glückwunsch, " + players[0].getName() + " Du hast gewonnen!");
            } else {
                System.out.println("Herzlichen Glückwunsch, " + players[1].getName() + " Du hast gewonnen!");

            }

        }
    }

    public static syntaxerror.Player[] erstelleSpieler() {
        Scanner scanner = new Scanner(System.in);
        // 2 Spieler erstellen
        syntaxerror.Player[] players = new syntaxerror.Player[2];
        AsciiArt.printLeerzeilen(30);
        System.out.println("Gegen den Computer spielen? (true/false)");
        boolean bot = scanner.nextBoolean();
        players[0] = new syntaxerror.Player(0);
        if (bot) {
            syntaxerror.Computerplayer tmp = new Computerplayer(1);
            tmp.setSchwierigkeit();
            players[1] = tmp;
        } else {
            players[1] = new Player(1);
        }
        return players;
    }
}
