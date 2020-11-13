package tic_tac_toe;

//import swing.TTTFrame;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String b_bot = null;
        boolean check = false;

        Scanner scanner = new Scanner(System.in);
        Player a = new Player(0);
        Player b = new Player(1);
        System.out.println("Namen für ersten Spieler eingeben!");
        a.setName(scanner.next());
        Player[] a_players = new Player[2];
        a_players[0] = a;
        a_players[1] = b;

        while (!check){
            System.out.println("Gegen einen Bot spielen? [j/n]");
            b_bot = scanner.next();
            if(b_bot.equals("j")){
                b.setBot();
                System.out.println("Schwierigkeit einstellen: leicht(1) schwer(2)");
                b.setSchwierigkeit(scanner.nextInt());
                check = true;
            }else if(b_bot.equals("n")){
                System.out.println("Namen für zweiten Spieler eingeben!");
                b.setName(scanner.next());
                check = true;
            }else {
                System.out.println("Falsche Eingabe, bitte wiederholen!");
            }
        }

        erstelleSpielfeld(b_bot, a_players);

    }

    public static void erstelleSpielfeld(String b_bot, Player[] a_player){
        char[][] leer = new char[1][1];
        leer[0][0] = 'f';
        Board board = new Board(leer);
        TTTFrame f = new TTTFrame("Button Example");
        f.setTitle("Tic Tac Toe by Armin Reimann");
        Image icon = Toolkit.getDefaultToolkit().getImage("src/swing/icon2.png");
        f.setIconImage(icon);

        f.willkommen();



        // ab hier beginnt das Tic Tac Toe Spiel
//        f.erzeugeTTT(board, a_player, b_bot);
        // bis hier geht das tic tac toe Spiel


        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(750,750);
        f.setLayout(null);
        f.setVisible(true);
    }



}
