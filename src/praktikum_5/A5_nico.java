package praktikum_5;

import java.util.Scanner;

public class A5_nico {
    public static void main (String[]args) {

        //Nr1
 /*         int monat = 5;
         

        switch (monat) {
             case 12, 1, 2:
             System.out.println("Es ist Winter");
             break;

             case 3, 4, 5:
             System.out.println("Es ist Frühling");    //Break, damit nicht alles ab der Zahl von Monat ausgegeben wird
             break;

             case 6, 7, 8:
             System.out.println("Es ist Sommer");
             break;

             case 9, 10, 11:
             System.out.println("Es ist Herbst");
             break;

              }
        */

        //Nr2
        double x= new Scanner(System.in).nextDouble();
        char operator = new Scanner(System.in).nextLine().charAt(0);
        double y = new Scanner(System.in).nextDouble();

        if (operator == '+') {
            System.out.println (x+y);
        } else if (operator== '-') {
            System.out.println(x-y);
        } else if (operator== '*') {
            System.out.println (x*y);
        } else if (operator== '/') {
            System.out.println(x/y);
        } else {
            System.out.println("Kein Operator");
        }
        
        //Nr3

   /*     int pos = 1;

        while(pos<=10) {
            System.out.println(pos);
            pos++;
        }
*/
       

        




     }

    }  
    
    
