package praktikum_5;

import java.util.Scanner;

public class Praktikum5 {

    public static void main(String[] args) {


        
        /*  int monat = 5; // Aufgabe 1
          
          String jahreszeit = "";
          
          switch (monat) { case 1, 2, 12: jahreszeit = "Winter"; break; case 3, 4, 5:
          jahreszeit = "Frühling"; break; case 6, 7, 8: jahreszeit = "Sommer"; break;
          case 9, 10, 11: jahreszeit = "Herbst"; break;
          
          default: break; }
          
          System.out.println("Der Monat " + monat + " ist die Jahreszeit " +
          jahreszeit); */
         
        // -------------------------------------------------------------------------------

        double x = new Scanner(System.in).nextDouble(); // Aufgabe 2
        char operator = new Scanner(System.in).nextLine().charAt(0);
        double y = new Scanner(System.in).nextDouble();

        if (operator == '+') {
            System.out.println(x + y);
        } else if (operator == '-') {
            System.out.println(x - y);
        } else if (operator == '*') {
            System.out.println(x * y);
        } else if (operator == '/') {
            System.out.println(x / y);
        }

        // ----------------------------------------------------------------------

        /*int pos = 1; //Aufgabe 3
        System.out.println(pos); 
        pos++;
        while(pos <= 10){
            System.out.println(pos);
            pos++;
        }*/

        //---------------------------------------------------------------------------

     }
//---------------------------------------------------------------------------
//     class Gerade { //Aufgabe 4
//
//        int x = 0
//        while(x < 20){
//            if(x%2 == 0)
//                System.out.println(x);
//        }
//    }
//---------------------------------------------------------------------------------


    



}
