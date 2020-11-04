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
    }
    public int getTurn(char[] boardInhalt){
        int turn;
        Board board = new Board(boardInhalt);

        if(!this.name.equals("false")){
            System.out.println(name + " - du bist am Zug!");
        }else{
            System.out.println("Spieler " + number + " - du bist am Zug!");
        }
        if(board.getFreieFelder() == null){
            return -1;
        }else{
            if(this.bot){
                turn = this.getBotTurn(board.getFreieFelder());
            }else{
                int input = scanner.nextInt();
                if(input < 9 && input >= 0){
                    turn = input;
                }else {
                    System.out.println("Ungültige Eingabe, bitte nochmal probieren.");
                    return getTurn(board.getInhalt());
                }
            }
            return turn;
        }
    }
    protected int getBotTurn(int[] freieFelder){
        System.out.println("Der Bot hat einen Zug gemacht");
        return freieFelder[new Random().nextInt(freieFelder.length)];
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean validateTurn(char[] board, int turn){
        return board[turn] == '-';
    }

}
