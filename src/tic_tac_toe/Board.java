package tic_tac_toe;

import java.util.*;

public class Board {
    char[][] board;
    int turn = 0;
    public Board(char[][] inhalt){
        board = new char[3][3];
        if(inhalt[0][0] != 'f'){
            board = inhalt;
        }else {
            Arrays.fill(board[0], '-');
            Arrays.fill(board[1], '-');
            Arrays.fill(board[2], '-');
        }

    }

    public int getTurn(){
        return this.turn;
    }

    public void setTurn(){
        this.turn = ( this.turn + 1) % 2;
    }

    public char[][] getInhalt(){
        return board;
    }

    protected static int getFreieFelder(char[][] board){
        // z steht für zeile und s für spalte
        int n_freieFelder = 0;

        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == '-') {
                    n_freieFelder++;
                }
            }
        }
        return n_freieFelder;
    }

    protected static int[][] getFreieFelderarray(char[][] board){
        // z steht für zeile und s für spalte
        int n_freieFelder = 0;
        int[][] a_freieFelder = new int[9][2];

        for (int z=0; z < board.length; z++){
            for (int s=0; s < board[z].length; s++){
                if(board[z][s] == '-'){
                        a_freieFelder[n_freieFelder][0]=z;
                        a_freieFelder[n_freieFelder][1]=s;
                        n_freieFelder++;
                }
            }
        }
        return a_freieFelder;
    }
     
    protected static int checkWinner(char[][] board){
        int winner = -2;
        //horizontal
        if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != '-'){
            winner = board[0][0];
        }else if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != '-'){
            winner = board[1][0];
        }else if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != '-'){
            winner = board[2][0];
        //senkrecht
        }else if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != '-'){
            winner = board[0][0];
        }else if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != '-'){
            winner = board[0][1];
        }else if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != '-'){
            winner = board[0][2];
        }
        //diagonal
        else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-'){
            winner = board[0][0];
        }
        else if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-'){
            winner = board[0][2];
        }
        // char Zeichen werden in ASCII Zahlen umgewandelt (man könnte auch aus winner einfach nen char machen und dann eine neue rückgabevariable erstellen)
        if(winner == 88){
            winner = 1;
        }else if(winner == 79){
            winner = 0;
        }else if (Board.getFreieFelder(board) == 0){
            //unentschieden
            winner = -1;
        }
        return winner;
    }
}
