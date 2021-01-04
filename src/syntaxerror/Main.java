package syntaxerror;

public class Main {

    public static void main(String[] args) {

        int turn = 0; //Spieler
        String winner = "-";

        // Spielfeld erstellen
        Board t = new Board();

        // 2 Spieler erstellen
        Player a = new Player(0);
        Player b = new Player(1);

        // Player-Array mit 2 Feldern
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        AsciiArt.printTicTacToe();

        a.setName();
        b.setName();

        // Schleife läuft solange es keinen Gewinner gibt
        while (winner.equals("-")) {
            //Spielfeld wird ausgegeben
            t.printBoard();

            int[] turnField = players[turn].getTurn();
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
            if (a.getZeichen().equals(winner)) {
                System.out.println("Herzlichen Glückwunsch, " + a.getName() + " Du hast gewonnen!");
            } else {
                System.out.println("Herzlichen Glückwunsch, " + b.getName() + " Du hast gewonnen!");

            }

        }
    }
}