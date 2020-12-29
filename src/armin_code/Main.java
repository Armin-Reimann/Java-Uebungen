package armin_code;

public class Main {

    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am  Zug ist test ANton

        int turn = 0; //Spieler
        String winner = "-";

        // Spielfeld erstellen
        String[][] board = new String[3][3];

        // Spielfeld mit leeren Feldern befüllen
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }

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
            printBoard(board);

            int[] turnField = players[turn].getTurn();
            if (a.validateTurn(board, turnField)) {
                board[turnField[0]][turnField[1]] = players[turn].getZeichen();
                turn = (turn + 1) % 2;
            }
            winner = checkWinner(board);
        }
        printBoard(board);
        if (winner.equals("F")) {
            System.out.println("Unentschieden!");

        } else {
            System.out.println("Herzlichen Glückwunsch, Spieler" + winner + " Du hast gewonnen!");
        }
    }
    public static String checkWinner (String [][] board) {
        String winner = "-";
        boolean stopp = false;
        if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]) && !board[0][0].equals("-")){
            winner = board[0][0];
        }else if(board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && board[1][0].equals("-")){
            winner = board[1][0];
        }else if(board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && board[2][0].equals("-")){
            winner = board[2][0];
            //senkrecht
        }else if(board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && board[0][0].equals("-")){
            winner = board[0][0];
        }else if(board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && board[0][1].equals("-")){
            winner = board[0][1];
        }else if(board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && board[0][2].equals("-")){
            winner = board[0][2];
        }else if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0].equals("-")){
            winner = board[0][0];
        }else if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && board[0][2].equals("-")){
            winner = board[0][2];
        }else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.println(board[i][j]);
                    if(board[i][j].equals("-")) {
                        winner = "-";
                        stopp = true;
                        break;
                    }else {
                        winner = "F";
                    }
                }
                if (stopp){
                    break;
                }
            }
        }
        System.out.println(winner);
        return winner;
    }

    public static void printBoard(String [][] meinBoard){
        System.out.println(meinBoard[0][0] + " | " + meinBoard[0][1] + " | "+ meinBoard[0][2]);
        System.out.println("____________");
        System.out.println(meinBoard[1][0] + " | " + meinBoard[1][1] + " | "+ meinBoard[1][2]);
        System.out.println("____________");
        System.out.println(meinBoard [2][0] + " | " + meinBoard[2][1] + " | "+ meinBoard[2][2]);
    }
}