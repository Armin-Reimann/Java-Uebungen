package tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    char[] board;
    public Board(char[] inhalt){
        board = new char[9];
        System.out.println("scheisse");
        if(inhalt[0] != 'f'){
            board = inhalt;
        }
        Arrays.fill(board, '-');
    }
    public char[] getInhalt(){
        return board;
    }
    public void setInhalt(int index, char inhalt){
        System.out.println(board);
        this.board[index] = inhalt;
        System.out.println(board);
    }
    public int[] getFreieFelder(){
        ArrayList<Integer> freieFelder = new ArrayList<Integer>();
        for(int i=0;i<board.length;i++){
            if(board[i] == '-'){
                freieFelder.add(i);
            }
        }
        if(freieFelder.size() == 0){
            return null;
        }
//        if(schwierigkeit == 2){
//            for(int i=0;i<freieFelder.size();i++){
//
//            }
//        }
        int[] freieFelderArray = new int[freieFelder.size()];
        for(int i = 0; i < freieFelder.size(); i++) {
            freieFelderArray[i] = freieFelder.get(i);
        }
        return freieFelderArray;
    }
    protected int checkWinner(){
        //Horizontal (Zeilen)
        int winner = -2;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != '-'){
            winner = board[0];
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != '-'){
            winner = board[3];
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[6] != '-'){
            winner = board[6];
            //Senkrecht (Spalten)
        }
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != '-'){
            winner = board[0];
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[1] != '-'){
            winner = board[1];
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[2] != '-'){
            winner = board[2];
            //Diagonal
        }
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != '-'){
            winner = board[0];
        }
        else if(board[2] == board[4] && board[2] == board[6] && board[2] != '-'){
            winner = board[2];
        }
        if(winner == 88){ // wegen ASCII
            winner = 1;
        }else if(winner == 79){
            winner = 0;
        }
        return winner;
    }
}
