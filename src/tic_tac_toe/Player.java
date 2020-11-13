package tic_tac_toe;

import java.util.*;
public class Player {
    int number;
    boolean bot = false;
    String name = "false";
    int schwierigkeit;
    Scanner scanner = new Scanner(System.in);

    public Player(int number){
        this.number = number;
    }

    public void setBot(){
        this.bot = true;
        this.name = "Bot";
    }

    public void setSchwierigkeit(int schwierigkeit){
        this.schwierigkeit = schwierigkeit;
    }

    /**
     * @param boardInhalt das spielbrett
     * @return Gibt einen einen Zug zurück
     */
    public int[] getTurn(char[][] boardInhalt){
        int[] turn;
        if(!this.name.equals("false")){
            System.out.println(name + " - du bist am Zug!");
        }else{
            System.out.println("Spieler " + number + " - du bist am Zug!");
        }

        if(Board.getFreieFelder(boardInhalt) == 0){
            return null;
        }else{
            if(this.bot){
                //todo hier den bot turn mit Minimax
                turn = this.getBotTurn(boardInhalt);
            }else{
                int input = scanner.nextInt();
                if(input < 9 && input >= 0){
                    turn = this.convertInput(input);
                }else {
                    System.out.println("Ungültige Eingabe, bitte nochmal probieren.");
                    return getTurn(boardInhalt);
                }
            }
            return turn;
        }

    }

    /**
     * sorgt dafür, dass man als eingabe für tic tac toe die zahlen 0-8 nehmen kann
     * @param input zahl zwischen 0 und 8
     * @return stelle im array
     */
    public int [] convertInput(int input){
        int[] returnArray = new int[2];
        switch (input) {
            case 0 -> {
                returnArray[0] = 0;
                returnArray[1] = 0;
            }
            case 1 -> {
                returnArray[0] = 0;
                returnArray[1] = 1;
            }
            case 2 -> {
                returnArray[0] = 0;
                returnArray[1] = 2;
            }
            case 3 -> {
                returnArray[0] = 1;
                returnArray[1] = 0;
            }
            case 4 -> {
                returnArray[0] = 1;
                returnArray[1] = 1;
            }
            case 5 -> {
                returnArray[0] = 1;
                returnArray[1] = 2;
            }
            case 6 -> {
                returnArray[0] = 2;
                returnArray[1] = 0;
            }
            case 7 -> {
                returnArray[0] = 2;
                returnArray[1] = 1;
            }
            case 8 -> {
                returnArray[0] = 2;
                returnArray[1] = 2;
            }
            default -> System.out.println("Fehler in Klasse Player Methode convertInput()");
        }
        return returnArray;
    }


    public int convertInputBack(int[] input){
        int returnWert = -1;
        if (input[0] == 0 && input[1] == 0) {
            returnWert = 0;
        } else if (input[0] == 0 && input[1] == 1) {
            returnWert = 1;
        } else if (input[0] == 0 && input[1] == 2) {
            returnWert = 2;
        } else if (input[0] == 1 && input[1] == 0) {
            returnWert = 3;
        } else if (input[0] == 1 && input[1] == 1) {
            returnWert = 4;
        } else if (input[0] == 1 && input[1] == 2) {
            returnWert = 5;
        } else if (input[0] == 2 && input[1] == 0) {
            returnWert = 6;
        } else if (input[0] == 2 && input[1] == 1) {
            returnWert = 7;
        } else if (input[0] == 2 && input[1] == 2) {
            returnWert = 8;
        } else {
            System.out.println("Fehler in Klasse Player Methode convertInput()");
        }
        return returnWert;
    }

    /**
     *
     * @param board das spielbrett
     * @return gibt alle Botzüge zurück (von allen Schwierigkeitsstufen)
     */
    protected int[] getBotTurn(char[][] board){
//        System.out.println("Der Bot hat einen Zug gemacht");
        if(schwierigkeit == 1){
            int[][] freieFelder = Board.getFreieFelderarray(board);
            return freieFelder[new Random().nextInt(freieFelder.length)];
        }else if(schwierigkeit == 2){
            return this.getBestMove(board);
        }else{
            System.out.println("Fehler in Player.java funktion getBotTurn()");
            int[][] freieFelder = Board.getFreieFelderarray(board);
            return freieFelder[new Random().nextInt(freieFelder.length)];
        }

    }

    /**
     * Startfunktion für den Minimax-Algorithmus
     * @param board das spielbrett
     * @return den besten zug, den der bot machen kann
     */
    protected int[] getBestMove(char[][] board){
        double bestScore = Double.NEGATIVE_INFINITY;
        double score;
        int[] move = new int[2];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == '-'){
                    board[i][j] = 'X';
                    score = minimax(board, 0, false);
//                    System.out.println("score:"+score);
                    board[i][j] = '-';
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
     * @param board das spielbrett
     * @param depth aktuelle tiefe (wird interessant wenn man danach begrenzen will,
     *              also wenn depth einen bestimmten wert erreicht hat soll er abbrechen)
     * @param isMaximazing kommt als nächstes der Maximizer-Spieler oder der Minimizer-Spieler?
     * @return gibt den score zurück, also ob man potzenziell bei diesem zug verliert oder gewinnt oder unentschieden herauskommt
     */
    protected double minimax(char[][] board, int depth, boolean isMaximazing){
        int result = Board.checkWinner(board);
        double score;
        if(result != -2){
            // Der erste Spieler ist immer 0
            // Der Bot ist immer 1
            if(result == 1){
                score = 1;
            }else if (result == 0){
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
                    if (board[i][j] == '-'){
                        board[i][j] = 'X';
//                        Main.printBoard(board);
                        score = minimax(board, depth+1, false);
                        board[i][j] = '-';
                        bestScore = Math.max(score,bestScore);
                    }
                }
            }
            return bestScore;
        }else{
            double bestScore = Double.POSITIVE_INFINITY;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board[i][j] == '-'){
                        board[i][j] = 'O';
//                        Main.printBoard(board);
                        score = minimax(board, depth+1, true);
                        board[i][j] = '-';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean validateTurn(char[][] board, int[] turn){
        try {
            //  Block of code to try
            return board[turn[0]][turn[1]] == '-';
        }
        catch(Exception e) {
            System.out.println("Fehler in Player.java funktion validateTurn()");
            return false;
        }
//        return board[turn[0]][turn[1]] == '-';
    }

}
