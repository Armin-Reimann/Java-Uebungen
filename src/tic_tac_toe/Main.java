package tic_tac_toe;

//import swing.TTTFrame;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //testkommentar12341567

        TTTFrame f = new TTTFrame("Button Example");
        f.setTitle("Tic Tac Toe by Armin Reimann");
        Image icon = Toolkit.getDefaultToolkit().getImage("src/swing/icon2.png");
        f.setIconImage(icon);

        // ab hier beginnt das Tic Tac Toe Spiel
//        f.erzeugeTTT(board, a_player, b_bot);
        // bis hier geht das tic tac toe Spiel

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(750,750);
        f.setLayout(null);
        f.setVisible(true);

    }

}
