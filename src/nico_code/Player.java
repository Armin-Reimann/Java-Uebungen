package nico_code;

import syntaxerror.Board;

import java.util.Scanner;

public class Player {
    protected int number;
    protected String zeichen;
    protected String name;
    protected Scanner scanner = new Scanner(System.in);

    public Player(int number){
        this.number = number;
        if(number == 0) {
            zeichen = "O";
        }else if (number == 1){
            zeichen = "X";
        }

    }


    public void setName() {
        System.out.println("Spieler " + (number+1) + ", geb deinen Namen ein:");
        name = scanner.next();
    }

    public String getName () {
        return name;
    }

    public String getZeichen() {
        return zeichen;
    }

    public int[] getTurn(){
        System.out.println(name + " - du bist am Zug! ");
        int input = scanner.nextInt();
        if (input < 9 && input >= 0){
            return Board.getMapping(input);
        }
        System.out.println("Ungültige Eingabe. Bitte nochmal probieren");
        return getTurn();
    }
}