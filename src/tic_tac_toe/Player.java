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
    public int getTurn(char[] board){
        if(!this.name.equals("false")){
            System.out.println(name + " - du bist am Zug!");
        }else{
            System.out.println("Spieler " + number + " - du bist am Zug!");
        }
        if(this.bot){
            return this.getBotTurn(board);
        }else{
            int input = scanner.nextInt();
            if(input < 9 && input >= 0){
                return input;
            }
            System.out.println("Ungültige Eingabe, bitte nochmal probieren.");
            return getTurn(board);
        }

    }
    protected int getBotTurn(char[] board){
        ArrayList<Integer> freieFelder = new ArrayList<Integer>();
        for(int i=0;i<board.length;i++){
            if(board[i] == '-'){
                freieFelder.add(i);
            }
        }
        if(schwierigkeit == 2){
            for(int i=0;i<freieFelder.size();i++){

            }
        }
        System.out.println("Der Bot hat einen Zug gemacht");
        return freieFelder.get(new Random().nextInt(freieFelder.size()));
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean validateTurn(char[] board, int turn){
        return board[turn] == '-';
    }

}
