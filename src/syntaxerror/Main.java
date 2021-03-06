package syntaxerror;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int turn = 0;
        String winner = "-";

        Brett t = new Board();

        AsciiArt.printTicTacToe();
        AsciiArt.printLeerzeilen(30);

        t.setSpielfeldart();

        Player[] players = erstelleSpieler();

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
            AsciiArt.printLeerzeilen(30);
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

    /**
     * Spieler werden erstellt
     * Auswahl zwischen Computerplayer oder Humanplayer
     * @return Array mit 2 Player Objekten
     */
    public static Player[] erstelleSpieler(){
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[2];
        AsciiArt.printLeerzeilen(30);
        System.out.println("Gegen den Computer spielen? (true/false)");
        boolean bot = scanner.nextBoolean();
        players[0] = new Player(0);
        if (bot){
            Computerplayer tmp = new Computerplayer(1);
            tmp.setSchwierigkeit();
            players[1] = tmp;
        }else {
            players[1] = new Player(1);
        }
        return  players;
    }
}