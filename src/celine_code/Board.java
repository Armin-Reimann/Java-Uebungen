package celine_code;

public class Board {
    protected String[][] board;

    public Board() {
        board = new String[3][3];
        befuellungSpielfeld();
    }
    public Board(String[][] inhalt) {
        board = inhalt;
    }

    protected void befuellungSpielfeld() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }
    }

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
                    System.out.println(board[i][j]);
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
        System.out.println(winner);
        return winner;
    }

    public void printBoard() {
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
    }

    public boolean validateTurn(int[] turn) {
        return board[turn[0]][turn[1]].equals("-");
    }

    public void setFeld(int[] turnField, String zeichen) {
        board[turnField[0]][turnField[1]] = zeichen;
    }

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
}
