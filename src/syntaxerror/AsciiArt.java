package syntaxerror;

import java.util.Scanner;

public class AsciiArt {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void consoleLeeren(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else {
                Runtime.getRuntime().exec("clear");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void printLeerzeilen(int anzahl){
        for (int i = 0; i < anzahl; i++) {
            System.out.println(" ");
        }
    }

    public static void printTicTacToe(){
        Scanner scanner = new Scanner(System.in);
        AsciiArt.printLeerzeilen(30);
        System.out.println(ANSI_RED+"▄▄▄█████▓ ██▓ ▄████▄ "+ANSI_GREEN+" ▄▄▄█████▓ ▄▄▄       ▄████▄  "+ANSI_BLUE+"▄▄▄█████▓ ▒█████  ▓█████ "+ANSI_RESET);
        System.out.println(ANSI_RED+"▓  ██▒ ▓▒▓██▒▒██▀ ▀█ "+ANSI_GREEN+" ▓  ██▒ ▓▒▒████▄    ▒██▀ ▀█  "+ANSI_BLUE+"▓  ██▒ ▓▒▒██▒  ██▒▓█   ▀ "+ANSI_RESET);
        System.out.println(ANSI_RED+"▒ ▓██░ ▒░▒██▒▒▓█    ▄"+ANSI_GREEN+" ▒ ▓██░ ▒░▒██  ▀█▄  ▒▓█    ▄ "+ANSI_BLUE+"▒ ▓██░ ▒░▒██░  ██▒▒███   "+ANSI_RESET);
        System.out.println(ANSI_RED+"░ ▓██▓ ░ ░██░▒▓▓▄ ▄██"+ANSI_GREEN+"▒░ ▓██▓ ░ ░██▄▄▄▄██ ▒▓▓▄ ▄██▒"+ANSI_BLUE+"░ ▓██▓ ░ ▒██   ██░▒▓█  ▄ "+ANSI_RESET);
        System.out.println(ANSI_RED+"  ▒██▒ ░ ░██░▒ ▓███▀ "+ANSI_GREEN+"░  ▒██▒ ░  ▓█   ▓██▒▒ ▓███▀ ░"+ANSI_BLUE+"  ▒██▒ ░ ░ ████▓▒░░▒████▒"+ANSI_RESET);
        System.out.println(ANSI_RED+"  ▒ ░░   ░▓  ░ ░▒ ▒  "+ANSI_GREEN+"░  ▒ ░░    ▒▒   ▓▒█░░ ░▒ ▒  ░"+ANSI_BLUE+"  ▒ ░░   ░ ▒░▒░▒░ ░░ ▒░ ░"+ANSI_RESET);
        System.out.println(ANSI_RED+"    ░     ▒ ░  ░  ▒  "+ANSI_GREEN+"      "+ANSI_PURPLE+"by Syntaxerror"+ANSI_GREEN+"  ░  ▒   "+ANSI_BLUE+"    ░      ░ ▒ ▒░  ░ ░  ░"+ANSI_RESET);
        System.out.println(ANSI_RED+               "  ░       ▒ ░░       "+ANSI_GREEN+"   ░        ░   ▒   ░        "+ANSI_BLUE+"  ░      ░ ░ ░ ▒     ░   "+ANSI_RESET);
        System.out.println(         "  "+ANSI_CYAN+"Enter drücken zum fortfahren"+ANSI_GREEN+"       ░  ░░ ░              "+ANSI_BLUE+"     ░ ░     ░  ░"+ANSI_RESET);
        scanner.nextLine();
    }

    public static void printTicTacToe2(){
        System.out.println("      _____                    _____                    _____                _____                    _____                    _____                _____                   _______                   _____          ");
        System.out.println("     /\\    \\                  /\\    \\                  /\\    \\              /\\    \\                  /\\    \\                  /\\    \\              /\\    \\                 /::\\    \\                 /\\    \\         ");
        System.out.println("    /::\\    \\                /::\\    \\                /::\\    \\            /::\\    \\                /::\\    \\                /::\\    \\            /::\\    \\               /::::\\    \\               /::\\    \\        ");
        System.out.println("    \\:::\\    \\               \\:::\\    \\              /::::\\    \\           \\:::\\    \\              /::::\\    \\              /::::\\    \\           \\:::\\    \\             /::::::\\    \\             /::::\\    \\       ");
        System.out.println("     \\:::\\    \\               \\:::\\    \\            /::::::\\    \\           \\:::\\    \\            /::::::\\    \\            /::::::\\    \\           \\:::\\    \\           /::::::::\\    \\           /::::::\\    \\      ");
        System.out.println("      \\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\           \\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\           \\:::\\    \\         /:::/~~\\:::\\    \\         /:::/\\:::\\    \\     ");
        System.out.println("       \\:::\\    \\               \\:::\\    \\        /:::/  \\:::\\    \\           \\:::\\    \\        /:::/__\\:::\\    \\        /:::/  \\:::\\    \\           \\:::\\    \\       /:::/    \\:::\\    \\       /:::/__\\:::\\    \\    ");
        System.out.println("       /::::\\    \\              /::::\\    \\      /:::/    \\:::\\    \\          /::::\\    \\      /::::\\   \\:::\\    \\      /:::/    \\:::\\    \\          /::::\\    \\     /:::/    / \\:::\\    \\     /::::\\   \\:::\\    \\   ");
        System.out.println("      /::::::\\    \\    ____    /::::::\\    \\    /:::/    / \\:::\\    \\        /::::::\\    \\    /::::::\\   \\:::\\    \\    /:::/    / \\:::\\    \\        /::::::\\    \\   /:::/____/   \\:::\\____\\   /::::::\\   \\:::\\    \\  ");
        System.out.println("     /:::/\\:::\\    \\  /\\   \\  /:::/\\:::\\    \\  /:::/    /   \\:::\\    \\      /:::/\\:::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/    /   \\:::\\    \\      /:::/\\:::\\    \\ |:::|    |     |:::|    | /:::/\\:::\\   \\:::\\    \\ ");
        System.out.println("    /:::/  \\:::\\____\\/::\\   \\/:::/  \\:::\\____\\/:::/____/     \\:::\\____\\    /:::/  \\:::\\____\\/:::/  \\:::\\   \\:::\\____\\/:::/____/     \\:::\\____\\    /:::/  \\:::\\____\\|:::|____|     |:::|    |/:::/__\\:::\\   \\:::\\____\\");
        System.out.println("   /:::/    \\::/    /\\:::\\  /:::/    \\::/    /\\:::\\    \\      \\::/    /   /:::/    \\::/    /\\::/    \\:::\\  /:::/    /\\:::\\    \\      \\::/    /   /:::/    \\::/    / \\:::\\    \\   /:::/    / \\:::\\   \\:::\\   \\::/    /");
        System.out.println("  /:::/    / \\/____/  \\:::\\/:::/    / \\/____/  \\:::\\    \\      \\/____/   /:::/    / \\/____/  \\/____/ \\:::\\/:::/    /  \\:::\\    \\      \\/____/   /:::/    / \\/____/   \\:::\\    \\ /:::/    /   \\:::\\   \\:::\\   \\/____/ ");
        System.out.println(" /:::/    /            \\::::::/    /            \\:::\\    \\              /:::/    /                    \\::::::/    /    \\:::\\    \\              /:::/    /             \\:::\\    /:::/    /     \\:::\\   \\:::\\    \\     ");
        System.out.println("/:::/    /              \\::::/____/              \\:::\\    \\            /:::/    /                      \\::::/    /      \\:::\\    \\            /:::/    /               \\:::\\__/:::/    /       \\:::\\   \\:::\\____\\    ");
        System.out.println("\\::/    /                \\:::\\    \\               \\:::\\    \\           \\::/    /                       /:::/    /        \\:::\\    \\           \\::/    /                 \\::::::::/    /         \\:::\\   \\::/    /    ");
        System.out.println(" \\/____/                  \\:::\\    \\               \\:::\\    \\           \\/____/                       /:::/    /          \\:::\\    \\           \\/____/                   \\::::::/    /           \\:::\\   \\/____/     ");
        System.out.println("                           \\:::\\    \\               \\:::\\    \\                                       /:::/    /            \\:::\\    \\                                     \\::::/    /             \\:::\\    \\         ");
        System.out.println("                            \\:::\\____\\               \\:::\\____\\                                     /:::/    /              \\:::\\____\\                                     \\::/____/               \\:::\\____\\        ");
        System.out.println("                             \\::/    /                \\::/    /                                     \\::/    /                \\::/    /                                      ~~                      \\::/    /        ");
        System.out.println("                              \\/____/                  \\/____/                                       \\/____/                  \\/____/                                                                \\/____/         ");
    }
}
