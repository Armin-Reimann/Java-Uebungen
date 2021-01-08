package nico_code;

import syntaxerror.Board;
import syntaxerror.Player;

public class Main {

    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am  Zug ist test ANton

        int turn = 0; //Spieler
        String winner = "-";

        // Spielfeld erstellen
        Board t = new Board();

        // 2 Spieler erstellen
        syntaxerror.Player a = new syntaxerror.Player(0);
        syntaxerror.Player b = new syntaxerror.Player(1);

        // Player-Array mit 2 Feldern
        syntaxerror.Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        a.setName();
        b.setName();
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
        }
        t.printBoard();
        if (winner.equals("F")) {
            System.out.println("Unentschieden!");

        } else {
            if (a.getZeichen().equals(winner)) {
                System.out.println("Herzlichen Glückwunsch, " + a.getName() + " Du hast gewonnen!");
            } else {
                System.out.println("Herzlichen Glückwunsch, " + b.getName() + " Du hast gewonnen!");

            }

        }
    }
}