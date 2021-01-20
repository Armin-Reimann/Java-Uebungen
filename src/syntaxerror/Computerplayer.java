package syntaxerror;

import java.util.Random;

public class Computerplayer extends Player {
    protected int schwierigkeit = 0;

    public Computerplayer(int number) {
        super(number);
    }

    @Override
    public void setName(){
        name = "Computer";
    }

    /**
     * Diese Funktion gibt einen Zug des Computergegners zurück
     * @param board  ist das aktuelle Spielfeld
     * @return Der Zug wird in Form eines Arrays mit zwei Einträgen (Zeile und Spalte) des Zuges zurückgegeben
     */
    @Override
    public int[] getTurn(Brett board) {
        System.out.println(name + " - du bist am Zug! ");
        try
        {
            Thread.sleep(700);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
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

    /**
     * Hier wird die Schwierigkeit des Computergegners gesetzt
     * Die AsciiArt-Funktion printLeerezeilen() ist nur dafür da, dass die Konsole immer wieder "geleert" wird
     */
    public void setSchwierigkeit(){
        AsciiArt.printLeerzeilen(30);
        System.out.println("Bitte wähle die Schwierigkeit aus (1 = leicht | 2 = schwer)");
        this.schwierigkeit = scanner.nextInt();
        AsciiArt.printLeerzeilen(30);
    }

    /**
     * Dies ist die Startfunktion des Minimax-Algorithmus
     * @param board das aktuelle Spielfeld
     * @return gibt den bestmöglichen Zug, den der Computer mit dem aktuellen Spielfeld machen kann, zurück
     */
    protected int[] getBestMove(String[][] board){
        double bestScore = Double.NEGATIVE_INFINITY;
        double score;
        int[] move = new int[2];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j].equals("-")){
                    board[i][j] = "X";
                    score = minimax(board, 0, false);
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

    /**
     * Hauptfunktion des Minimax-Algorithmus
     * @param board das aktuelle Spielfeld
     * @param depth gibt die aktuelle Tiefe im Baum an (also wieviele Züge der Algorithmus vorausschaut)
     * @param isMaximazing gibt an, ob man den niedrigsten oder höchsten Score übernimmt
     * @return gibt den Score zurück
     */
    protected double minimax(String[][] board, int depth, boolean isMaximazing){
        Board o_board = new Board(board);
        String result = o_board.checkWinner();
        double score;
        // falls es einen Gewinner gibt
        if(!result.equals("-")){
            // Der erste Spieler ist immer X
            // Der Bot ist immer O
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
