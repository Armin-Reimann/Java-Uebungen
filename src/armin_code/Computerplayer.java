package armin_code;

import java.util.Random;

public class Computerplayer extends Player{
    protected int schwierigkeit = 0;

    public Computerplayer(int number) {
        super(number);
    }

    @Override
    public void setName(){
        name = "Computer";
    }

    @Override
    public int[] getTurn(Board board) {
        if(schwierigkeit == 1){
            int[][] freieFelder = board.getFreieFelderarray();
            return freieFelder[new Random().nextInt(freieFelder.length)];
        }else if(schwierigkeit == 2){
            return this.getBestMove(board.getBoard());
        }else{
            System.out.println("Fehler in Player.java funktion getBotTurn()");
            int[][] freieFelder = board.getFreieFelderarray();
            return freieFelder[new Random().nextInt(freieFelder.length)];
        }
    }

    public void setSchwierigkeit(){
        AsciiArt.printLeerzeilen(30);
        System.out.println("Bitte wähle die Schwierigkeit aus (1 = leicht | 2 = schwer)");
        this.schwierigkeit = scanner.nextInt();
        AsciiArt.printLeerzeilen(30);
    }

    protected int[] getBestMove(String[][] board){
        double bestScore = Double.NEGATIVE_INFINITY;
        double score;
        int[] move = new int[2];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j].equals("-")){
                    board[i][j] = "X";
                    score = minimax(board, 0, false);
//                    System.out.println("score:"+score);
                    board[i][j] = "-";
                    if(score > bestScore){
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        return move;
    }

    protected double minimax(String[][] board, int depth, boolean isMaximazing){
        Board o_board = new Board(board);
        String result = o_board.checkWinner();
        double score;
        if(!result.equals("-")){
            // Der erste Spieler ist immer 0
            // Der Bot ist immer 1
            if(result.equals("X")){
                score = 1;
            }else if (result.equals("O")){
                score = -1;
            }else{
                score = 0;
            }
            return score;
        }
        if(isMaximazing){

            double bestScore = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board[i][j].equals("-")){
                        board[i][j] = "X";
//                        Main.printBoard(board);
                        score = minimax(board, depth+1, false);
                        board[i][j] = "-";
                        bestScore = Math.max(score,bestScore);
                    }
                }
            }
            return bestScore;
        }else{
            double bestScore = Double.POSITIVE_INFINITY;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board[i][j].equals("-")){
                        board[i][j] = "O";
//                        Main.printBoard(board);
                        score = minimax(board, depth+1, true);
                        board[i][j] = "-";
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}
