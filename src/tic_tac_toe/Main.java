package tic_tac_toe;

import swing.TTTFrame;

import javax.swing.*;
import java.util.*;
// test armin hat was geändert
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




        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//        char [][] tempboard = board.getInhalt();
//        while(winner == -2){
//            printBoard(board.getInhalt());
//            int[] turnField = players[turn].getTurn(board.getInhalt());
//            if (turnField == null){
//                break;
//            }


//            turn = ( turn + 1) % 2;
//            if(players[turn].validateTurn(board.getInhalt(), turnField)){
//                if(players[turn].number == 0){
//                    tempboard[turnField[0]][turnField[1]] = 'O';
//                }else{
//                    tempboard[turnField[0]][turnField[1]] = 'X';
//                }
//                //modulo! 0 1 0 1 0 1 ... da nur zwei Spieler
//                turn = ( turn + 1) % 2;
//            }


//            winner = Board.checkWinner(tempboard);
//        }


//        if(winner == 0){
//            System.out.println(a.name + " hat gewonnen!");
//        }else if (winner == 1){
//            System.out.println(b.name + " hat gewonnen!");
//        }
//        else if(winner == -2 || winner == -1){
//            System.out.println("Unentschieden!");
//        }
    }

    public static void printBoard(char[][] meinBoard){
        System.out.println(meinBoard[0][0] + " | " + meinBoard[0][1] + " | " + meinBoard[0][2]);
        System.out.println("____________");
        System.out.println(meinBoard[1][0] + " | " + meinBoard[1][1] + " | " + meinBoard[1][2]);
        System.out.println("____________");
        System.out.println(meinBoard[2][0] + " | " + meinBoard[2][1] + " | " + meinBoard[2][2]);
    }

    public static void erstelleSpielfeld(String b_bot, Player[] player){
        char[][] leer = new char[1][1];
        leer[0][0] = 'f';
        Board board = new Board(leer);
        int turn = 0;
        Player[] a_players = player;

        swing.TTTFrame f = new TTTFrame("Button Example");
        f.setTitle("Tic Tac Toe by Armin Reimann");
        //erstellt die beiden X und O Icons


        // ab hier beginnt das Tic Tac Toe Spiel
        JButton[] a_button = new JButton[9];
        for(int i=0; i<=8; i++){
            a_button[i] = new JButton(new ImageIcon("src/swing/leer.png"));
            int[] buttonBound = f.getButtonBounds(i, 10, 10,150,150,10 );
            a_button[i].setBounds(buttonBound[0],buttonBound[1],buttonBound[2],buttonBound[3]);
            int finalI = i;
            a_button[i].addActionListener(e -> {
                if (board.getTurn() == 1){

                    a_button[finalI].setIcon(new ImageIcon("src/swing/O.png"));
                }else{
                    a_button[finalI].setIcon(new ImageIcon("src/swing/X.png"));
                }
                board.setTurn();
            });
        }
        for(int i=0; i<=8; i++){
            f.add(a_button[i]);
        }
//        f.add(b);
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }

}
