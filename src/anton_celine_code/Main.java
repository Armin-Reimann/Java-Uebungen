package anton_celine_code;

public class Main {

    public static void main(String[] args) {
        // Hier wird der Spieler gespeichert, der gerade am  Zug ist test ANton

        int turn = 0; //Spieler
        int winner = -1;

        // Spielfeld erstellen
        int[][]  board = new int[3][3];

        // Spielfeld mit leeren Feldern befüllen
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                board[i][j] = -1;
           }
        }

        // 2 Spieler erstellen
        Player a = new Player(0);
        Player b = new Player(1);

        // Player-Array mit 2 Feldern
        Player[] players = new Player[2];
        players[0]= a;
        players[1]= b;

        // Schleife läuft solange es keinen Gewinner gibt
        while(winner == -1){
           //Spielfeld wird ausgegeben
           printBoard(board);

           int[] turnField = players[turn].getTurn();
           if (a.validateTurn(board, turnField)){
               board[turnField[0]][turnField[1]] = players[turn].number;
               turn = (turn + 1) % 2;
           }
            winner = checkWinner(board);
        }
        System.out.println("Herzlichen Glückwunsch, Spieler" + winner + " Du hast gewonnen!");
        printBoard(board);
    }

    public static int checkWinner (int [][] board) {
        int winner = -1;
        if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != -1){
            winner = board[0][0];
        }else if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != -1){
            winner = board[1][0];
        }else if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != -1){
            winner = board[2][0];
            //senkrecht
        }else if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != -1){
            winner = board[0][0];
        }else if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != -1){
            winner = board[0][1];
        }else if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != -1){
            winner = board[0][2];
        }else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != -1){
            winner = board[0][0];
        }else if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != -1){
            winner = board[0][2];
        }else{
            winner = -1;
        }
        return winner;
    }

    public static void printBoard(int [][] meinBoard){
        System.out.println(meinBoard[0][0] + " | " + meinBoard[0][1] + " | "+ meinBoard[0][2]);
        System.out.println("____________");
        System.out.println(meinBoard[1][0] + " | " + meinBoard[1][1] + " | "+ meinBoard[1][2]);
        System.out.println("____________");
        System.out.println(meinBoard [2][0] + " | " + meinBoard[2][1] + " | "+ meinBoard[2][2]);
    }
}