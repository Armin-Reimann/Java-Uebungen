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
        System.out.println("schwierigkeit: "+this.schwierigkeit);
    }
    public int[] getTurn(char[][] boardInhalt){
        int[] turn = new int[2];
//        Board board = new Board(boardInhalt);

        if(!this.name.equals("false")){
            System.out.println(name + " - du bist am Zug!");
        }else{
            System.out.println("Spieler " + number + " - du bist am Zug!");
        }

        if(Board.getFreieFelder(boardInhalt) == 0){
//        if(board.getFreieFelder() == null){
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
    protected int [] convertInput(int input){
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
    protected int[] getBotTurn(char[][] board){
        System.out.println("Der Bot hat einen Zug gemacht");
        if(schwierigkeit == 1){
            int[][] freieFelder = Board.getFreieFelderarray(board);
            return freieFelder[new Random().nextInt(freieFelder.length)];
        }else if(schwierigkeit == 2){
            System.out.println("es ist an der richtigen stelle");
            int[] bestTurn = this.getBestMove(board);
            return bestTurn;
        }else{
            System.out.println("Fehler in Player.java funktion getBotTurn()");
            int[][] freieFelder = Board.getFreieFelderarray(board);
            return freieFelder[new Random().nextInt(freieFelder.length)];
        }

    }
    protected int[] getBestMove(char[][] board){
        double bestScore = Double.NEGATIVE_INFINITY;
        double score = Double.NEGATIVE_INFINITY;
        int[] move = new int[2];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == '-'){
                    board[i][j] = 'a';
                    score = minimax(board, 0, true);
                    System.out.println("score:"+score);
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

    protected double minimax(char[][] board, int depth, boolean isMaximazing){
        int result = Board.checkWinner(board);
        double score = 0;
        if(result != -2){
            // Der erste Spieler ist immer 0
            // Der Bot ist immer 1
            if(result == 1){
                score = 1;
            }else if (result == 0){
                score = -1;
            }
            return score;
        }
        if(isMaximazing){
            double bestScore = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board[i][j] == '-'){
                        board[i][j] = 'a';
                        score = minimax(board, depth+1, false);
                        board[i][j] = '-';
                        if(score > bestScore){
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }else{
            double bestScore = Double.POSITIVE_INFINITY;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board[i][j] == '-'){
                        board[i][j] = 'h';
                        score = minimax(board, depth+1, true);
                        board[i][j] = '-';
                        if(score < bestScore){
                            bestScore = score;
                        }
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
