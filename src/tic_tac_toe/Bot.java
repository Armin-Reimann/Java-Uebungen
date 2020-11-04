package tic_tac_toe;
import java.util.Scanner;
public class Bot {
    public boolean macheZug(int[] board, int turn){
        if(board[turn] == -1) {
            return true;
        }
        return false;
    }

}
