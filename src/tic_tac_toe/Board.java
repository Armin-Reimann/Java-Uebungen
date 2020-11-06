package tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    char[][] board;
    public Board(char[][] inhalt){
//        board = new char[9];
        board = new char[3][3];
//        board[0] = new char[3];
//        board[1] = new char[3];
//        board[2] = new char[3];
//        System.out.println("scheisse");
        if(inhalt[0][0] != 'f'){
            board = inhalt;
        }else {
            Arrays.fill(board[0], '-');
            Arrays.fill(board[1], '-');
            Arrays.fill(board[2], '-');
        }

    }
    public char[][] getInhalt(){
        return board;
    }
    public void setInhalt(int zeile, int spalte, char inhalt){
        this.board[zeile][spalte] = inhalt;
    }

    protected static int getFreieFelder(char[][] board){
        // z steht für zeile und s für spalte
        int n_freieFelder = 0;

        for (int z=0; z < board.length; z++){
            for (int s=0; s < board[z].length; s++){
                if(board[z][s] == '-'){
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

//    public static int getFreieFelder(char[][] board){
//        // z steht für zeile und s für spalte
//        int n_freieFelder = 0;
//        int[][] a_freieFelder = new int[9][2];
//
//        for (int z=0; z < board.length; z++){
//            for (int s=0; s < board[z].length; s++){
//                if(board[z][s] == '-'){
//                    if (b_int){
//                        n_freieFelder++;
//                    }else{
//                        a_freieFelder[n_freieFelder][0]=z;
//                        a_freieFelder[n_freieFelder][1]=s;
//                        n_freieFelder++;
//                    }
//                    //freies feld
//
//                }
//            }
//        }


//        ArrayList<Integer> freieFelder = new ArrayList<Integer>();
//        for(int i=0;i<board.length;i++){
//            if(board[i] == '-'){
//                freieFelder.add(i);
//            }
//        }
//        if(freieFelder.size() == 0){
//            return null;
//        }
//        if(schwierigkeit == 2){
//            for(int i=0;i<freieFelder.size();i++){
//
//            }
//        }
//        int[] freieFelderArray = new int[freieFelder.size()];
//        for(int i = 0; i < freieFelder.size(); i++) {
//            freieFelderArray[i] = freieFelder.get(i);
//        }
//        return freieFelderArray;
//    }
     
    protected static int checkWinner(char[][] board){
        int winner = -1;
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
        else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][1] != '-'){
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
        }
        return winner;
    }
    protected int checkWinnerAlt(){
        //Horizontal (Zeilen)
        int winner = -2;
//        if(board[0] == board[1] && board[0] == board[2] && board[0] != '-'){
//            winner = board[0];
//        }
//        else if(board[3] == board[4] && board[3] == board[5] && board[3] != '-'){
//            winner = board[3];
//        }
//        else if(board[6] == board[7] && board[6] == board[8] && board[6] != '-'){
//            winner = board[6];
//            //Senkrecht (Spalten)
//        }
//        else if(board[0] == board[3] && board[0] == board[6] && board[0] != '-'){
//            winner = board[0];
//        }
//        else if(board[1] == board[4] && board[1] == board[7] && board[1] != '-'){
//            winner = board[1];
//        }
//        else if(board[2] == board[5] && board[2] == board[8] && board[2] != '-'){
//            winner = board[2];
//            //Diagonal
//        }
//        else if(board[0] == board[4] && board[0] == board[8] && board[0] != '-'){
//            winner = board[0];
//        }
//        else if(board[2] == board[4] && board[2] == board[6] && board[2] != '-'){
//            winner = board[2];
//        }
//        if(winner == 88){ // wegen ASCII
//            winner = 1;
//        }else if(winner == 79){
//            winner = 0;
//        }
        return winner;
    }
}
