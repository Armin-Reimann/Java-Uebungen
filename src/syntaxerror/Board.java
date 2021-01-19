package syntaxerror;

import java.util.Scanner;

public class Board implements Brett{
    protected String[][] board;
    protected boolean schoenesSpielfeld;
    protected Scanner scanner = new Scanner(System.in);

    /**
     * Spielbrett als zweidimensionales Array wird erstellt und befüllt
     */
    public Board() {
        board = new String[3][3];
        befuellungSpielfeld();
    }
    public Board(String[][] inhalt) {
        board = inhalt;
    }

    /**
     * Hier wird das Array komplett durchlaufen und mit "-" befüllt
     */
    protected void befuellungSpielfeld() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }
    }




    /**
     * An dieser Stelle werden alle möglichen Gewinnreihen
     * durchlaufen. Wenn alle Möglichkeiten nicht zutreffen, wird geprüft, ob
     * es noch freie Felder gibt. Wenn dies der Fall ist bleibt der Gewinner
     * "-", ansonsten geht das Spiel unentschieden aus.
     * @return Zeichen vom Gewinner
     */
    public String checkWinner() {
        String winner = "-";
        boolean stopp = false;
        //waagerecht
        if (board[0][0].equals(board[0][1])        && board[0][0].equals(board[0][2]) && !board[0][0].equals("-")) {
            winner = board[0][0];
        } else if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && !board[1][0].equals("-")) {
            winner = board[1][0];
        } else if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && !board[2][0].equals("-")) {
            winner = board[2][0];
            //senkrecht
        } else if (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && !board[0][0].equals("-")) {
            winner = board[0][0];
        } else if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && !board[0][1].equals("-")) {
            winner = board[0][1];
        } else if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && !board[0][2].equals("-")) {
            winner = board[0][2];
            //diagonal
        } else if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("-")) {
            winner = board[0][0];
        } else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("-")) {
            winner = board[0][2];
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
//                    System.out.println(board[i][j]);
                    if (board[i][j].equals("-")) {
                        winner = "-";
                        stopp = true;
                        break;
                    } else {
                        winner = "F";
                    }
                }
                if (stopp) {
                    break;
                }
            }
        }
        return winner;
    }


    /**
     * je nachdem was man ausgewählt hat wird entweder ein schönes oder ein normales Spielfeld in der Konsole ausgegeben
     */
    public void printBoard() {
        if(schoenesSpielfeld){
            System.out.println(" __| |_____________________________| |__");
            System.out.println("(__   _____________________________   __)");
            System.out.println("   | |" + "   " + board[0][0] + "    " + " | " + "    " + board[0][1] + "    " + " | " + board[0][2] + "     " + "| |");
            System.out.println("   | |" + " " + "___________________________" + " " + "| |");
            System.out.println("   | |" + "   " + board[1][0] + "    " + " | " + "    " + board[1][1] + "    " + " | " + board[1][2] + "     " + "| |");
            System.out.println("   | |" + " " + "___________________________" + " " + "| |");
            System.out.println("   | |" + "   " + board[2][0] + "    " + " | " + "    " + board[2][1] + "    " + " | " + board[2][2] + "     " + "| |");
            System.out.println(" __| |_____________________________| |__");
            System.out.println("(__   _____________________________   __)");
            System.out.println("   | |                             | |");
        }else {
            System.out.println(board[0][0] + " | " + board[0][1] + " | "+ board[0][2]);
            System.out.println("____________");
            System.out.println(board[1][0] + " | " + board[1][1] + " | "+ board[1][2]);
            System.out.println("____________");
            System.out.println(board [2][0] + " | " + board[2][1] + " | "+ board[2][2]);
        }

    }

    /**
     * Prüft, ob man auf das Feld noch setzten darf oder es schon befüllt ist
     * @param turn array das "zeile" und "spalte" vom Spielfeld enthält
     * @return boolean
     */
    public boolean validateTurn(int[] turn) {
        return board[turn[0]][turn[1]].equals("-");
    }

    /**
     * @param turnField Bekommt die Daten, welches Zeichen gesetzt wurde in der Konsole und gibt dieses aus.
     * @param zeichen Zahl von 0-8
     */
    public void setFeld(int[] turnField, String zeichen) {
        board[turnField[0]][turnField[1]] = zeichen;
    }

    /**
     * Diese Funktion wandelt die Eingabe von 0-8 (neuen Möglichkeiten/ Felder) in eine Eingabe auf dem Feld um.
     * @param input Zahl von 0-8
     * @return Array mit der Größe 2
     */
    public static int[] getMapping(int input) {
        int[] rueckgabe = new int[2];
        if (input == 0) {
            rueckgabe[0] = 0;
            rueckgabe[1] = 0;
        } else if (input == 1) {
            rueckgabe[0] = 0;
            rueckgabe[1] = 1;
        } else if (input == 2) {
            rueckgabe[0] = 0;
            rueckgabe[1] = 2;
        } else if (input == 3) {
            rueckgabe[0] = 1;
            rueckgabe[1] = 0;
        } else if (input == 4) {
            rueckgabe[0] = 1;
            rueckgabe[1] = 1;
        } else if (input == 5) {
            rueckgabe[0] = 1;
            rueckgabe[1] = 2;
        } else if (input == 6) {
            rueckgabe[0] = 2;
            rueckgabe[1] = 0;
        } else if (input == 7) {
            rueckgabe[0] = 2;
            rueckgabe[1] = 1;
        } else if (input == 8) {
            rueckgabe[0] = 2;
            rueckgabe[1] = 2;
        } else {
            System.out.println("Fehler in Klasse Board Methode getMapping()");
        }
        return rueckgabe;
    }

    /**
     * Diese Funktion geht einmal das ganze Spielfeld durch
     * und prüft welche Felder leer sind und ob dort gesetzt werden kann.
     * gibt die dann zwei Arrays zurück.
     * @return Array mit den freien Feldern
     */
    public int[][] getFreieFelderarray(){
        // z steht für zeile und s für spalte
        int n_freieFelder = 0;
        int[][] a_freieFelder = new int[9][2];

        for (int z=0; z < board.length; z++){
            for (int s=0; s < board[z].length; s++){
                if(board[z][s].equals("-")){
                    a_freieFelder[n_freieFelder][0]=z;
                    a_freieFelder[n_freieFelder][1]=s;
                    n_freieFelder++;
                }
            }
        }
        return a_freieFelder;
    }

    public String[][] getBoard(){
        return board;
    }

    @Override
    public void setSpielfeldart(){
        System.out.println("Soll ein auf einem schönen Spielfeld gespielt werden? (true/false)");
        boolean tmpSchoenesSpielfeld;
        tmpSchoenesSpielfeld = scanner.nextBoolean();
        this.schoenesSpielfeld = tmpSchoenesSpielfeld;
    }
}
