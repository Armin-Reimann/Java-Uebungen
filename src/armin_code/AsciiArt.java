package armin_code;

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

    public static String[] getAnsiColors(){
        String code;
        String[] farben = new String[256];
        int zahler = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                code = String.valueOf(i*16+j);
                farben[zahler] = "\u001b[38;5;"+code+"m";
                zahler++;
            }
        }
        return farben;
    }

    public static void rgbRainbow(){
//        String[] farben = new String[6];
//        farben[0] = ANSI_RED;
//        farben[1] = ANSI_GREEN;
//        farben[2] = ANSI_YELLOW;
//        farben[3] = ANSI_BLUE;
//        farben[4] = ANSI_PURPLE;
//        farben[5] = ANSI_CYAN;


        String[] farben = AsciiArt.getAnsiColors();



//        for (int j = 0; j < farben.length; j++) {
//            System.out.println(farben[j]+ "FARBE: "+ j);
//        }
//
//        int rechnung = 0;
//        while (true){
//            rechnung = rechnung+1;
//        }


        String text = "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm";
        char[] textarray = text.toCharArray();

        int farblaenge = 0;

        int farbzaehler = 52;
        int farbzaehler2 = 52;

        while (true){
            for (int i = 0; i < text.length(); i++) {
                if(farbzaehler > 57){
                    farbzaehler = 52;
                }
                System.out.print(farben[farbzaehler]+textarray[i]);
                farblaenge++;
                farbzaehler++;
                if(farblaenge == 1){

                    farblaenge = 0;
                }

            }
            System.out.println();
            for (int i = 0; i < text.length(); i++) {
                if(farbzaehler2 > 57){
                    farbzaehler2 = 52;
                }
                System.out.print(farben[farbzaehler2]+textarray[i]);
//                farblaenge++;
                farbzaehler2++;
//                if(farblaenge == 1){
//
//                    farblaenge = 0;
//                }

            }
            try
            {
                Thread.sleep(300);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            farbzaehler++;
            AsciiArt.printLeerzeilen(2);
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
