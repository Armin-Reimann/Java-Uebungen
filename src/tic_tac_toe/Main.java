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

        f.erstelleLabel();



        // ab hier beginnt das Tic Tac Toe Spiel
        JButton[] a_button = new JButton[9];
        char [][] tempboard = board.getInhalt();
        for(int i=0; i<=8; i++){
            a_button[i] = new JButton(new ImageIcon("src/swing/leer.png"));
            int[] buttonBound = f.getButtonBounds(i, 120, 100,150,150,10 );
            a_button[i].setBounds(buttonBound[0],buttonBound[1],buttonBound[2],buttonBound[3]);
            int finalI = i;
            a_button[i].addActionListener(e -> {
                int turn = board.getTurn();
                if (turn == 1){
                    a_button[finalI].setIcon(new ImageIcon("src/swing/O.png"));
                    int[] tempZug = a_player[0].convertInput(finalI);
                    tempboard[tempZug[0]][tempZug[1]] = 'O';
                }else{
                    a_button[finalI].setIcon(new ImageIcon("src/swing/X.png"));
                    int[] tempZug = a_player[1].convertInput(finalI);
                    tempboard[tempZug[0]][tempZug[1]] = 'X';
                }
                board.setWinner(Board.checkWinner(tempboard));
                if(checkWinner(board.getWinner(), a_player)){
                    return;
                }
                board.setTurn();
                if(b_bot.equals("j")){
                    int[] botTurn = a_player[1].getBotTurn(tempboard);
                    int convertierterInput = a_player[1].convertInputBack(botTurn);
                    if (convertierterInput == -1){
                        return;
                    }
                    a_button[convertierterInput].setIcon(new ImageIcon("src/swing/X.png"));
                    tempboard[botTurn[0]][botTurn[1]] = 'X';
                    board.setWinner(Board.checkWinner(tempboard));
                    if(!checkWinner(board.getWinner(), a_player)){
                        return;
                    }
                    board.setTurn();
                }
            });
        }
        for(int i=0; i<=8; i++){
            f.add(a_button[i]);
        }
        // bis hier geht das tic tac toe Spiel


        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(750,750);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static boolean checkWinner(int winner, Player[] player){

        if(winner == 0){
            System.out.println(player[0].name + " hat gewonnen!");
            return true;
        }else if (winner == 1){
            System.out.println(player[1].name + " hat gewonnen!");
            return true;
        }
        else if(winner == -1){
            System.out.println("Unentschieden!");
            return true;
        }else{
            return false;
        }
    }

}
