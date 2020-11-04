package tic_tac_toe;

import java.util.Arrays;

public class Board {
    char[] board;
    public Board(){
        board = new char[9];
        Arrays.fill(board, '-');
    }
    public char[] getInhalt(){
        return board;
    }
    public void setInhalt(int index, char inhalt){
        board[index] = inhalt;
    }
    protected int checkWinner(){
        //Horizontal (Zeilen)
        int winner = -1;
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
