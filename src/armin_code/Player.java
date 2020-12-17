package armin_code;

import java.util.Scanner;

public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);

    public Player(int number){
        this.number = number;
    }

    public int[] getTurn(){
        System.out.println("Player" + number + " - du bist am Zug! ");
        int input = scanner.nextInt();
        if (input < 9 && input >= 0){
            return getMapping(input);
        }
        System.out.println("Ungültige Eingabe. Bitte nochmal probieren");
        return getTurn();
    }

    private int[] getMapping(int input){
        int[] rueckgabe = new int[2];
        if(input == 0){
            rueckgabe[0] = 0;
            rueckgabe[1] = 0;
        }else if(input == 1){
            rueckgabe[0] = 0;
            rueckgabe[1] = 1;
        }else if(input == 2){
            rueckgabe[0] = 0;
            rueckgabe[1] = 2;
        }else if(input == 3){
            rueckgabe[0] = 1;
            rueckgabe[1] = 0;
        }else if(input == 4){
            rueckgabe[0] = 1;
            rueckgabe[1] = 1;
        }else if(input == 5){
            rueckgabe[0] = 1;
            rueckgabe[1] = 2;
        }else if(input == 6){
            rueckgabe[0] = 2;
            rueckgabe[1] = 0;
        }else if(input == 7){
            rueckgabe[0] = 2;
            rueckgabe[1] = 1;
        }else if(input == 8){
            rueckgabe[0] = 2;
            rueckgabe[1] = 2;
        }else{
            System.out.println("Fehler in Klasse Player Methode getMapping()");
        }
        return rueckgabe;
    }



    public boolean validateTurn(int [][] board, int[] turn){
        return board[turn[0]][turn[1]] == -1;
    }
}
