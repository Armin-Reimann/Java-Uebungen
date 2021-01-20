package syntaxerror;

import java.util.Scanner;

public class AsciiArt {

    public static void printLeerzeilen(int anzahl){
        for (int i = 0; i < anzahl; i++) {
            System.out.println(" ");
        }
    }

    public static void printTicTacToe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("▄▄▄█████▓ ██▓ ▄████▄  ▄▄▄█████▓ ▄▄▄       ▄████▄  ▄▄▄█████▓ ▒█████  ▓█████ ");
        System.out.println("▓  ██▒ ▓▒▓██▒▒██▀ ▀█  ▓  ██▒ ▓▒▒████▄    ▒██▀ ▀█  ▓  ██▒ ▓▒▒██▒  ██▒▓█   ▀ ");
        System.out.println("▒ ▓██░ ▒░▒██▒▒▓█    ▄ ▒ ▓██░ ▒░▒██  ▀█▄  ▒▓█    ▄ ▒ ▓██░ ▒░▒██░  ██▒▒███   ");
        System.out.println("░ ▓██▓ ░ ░██░▒▓▓▄ ▄██▒░ ▓██▓ ░ ░██▄▄▄▄██ ▒▓▓▄ ▄██▒░ ▓██▓ ░ ▒██   ██░▒▓█  ▄ ");
        System.out.println("  ▒██▒ ░ ░██░▒ ▓███▀ ░  ▒██▒ ░  ▓█   ▓██▒▒ ▓███▀ ░  ▒██▒ ░ ░ ████▓▒░░▒████▒");
        System.out.println("  ▒ ░░   ░▓  ░ ░▒ ▒  ░  ▒ ░░    ▒▒   ▓▒█░░ ░▒ ▒  ░  ▒ ░░   ░ ▒░▒░▒░ ░░ ▒░ ░");
        System.out.println("    ░     ▒ ░  ░  ▒        by Syntaxerror  ░  ▒       ░      ░ ▒ ▒░  ░ ░  ░");
        System.out.println("  ░       ▒ ░░          ░        ░   ▒   ░          ░      ░ ░ ░ ▒     ░   ");
        System.out.println("  Enter drücken zum fortfahren       ░  ░░ ░                   ░ ░     ░  ░");
        scanner.nextLine();
    }
}
