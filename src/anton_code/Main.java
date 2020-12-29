package anton_code;

public class Main {

    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am  Zug ist test ANton

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
        }
        t.printBoard();
        if (winner.equals("F")) {
            System.out.println("Unentschieden!");

        } else {
            System.out.println("Herzlichen Glückwunsch, Spieler" + winner + " Du hast gewonnen!");
        }
    }
}