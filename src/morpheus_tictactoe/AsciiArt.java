package morpheus_tictactoe;

public class AsciiArt {

    public static void printLeerzeilen(int anzahl){
        for (int i = 0; i < anzahl; i++) {
            System.out.println(" ");
        }
    }

    public static void printTicTacToe(){
        System.out.println("▄▄▄█████▓ ██▓ ▄████▄  ▄▄▄█████▓ ▄▄▄       ▄████▄  ▄▄▄█████▓ ▒█████  ▓█████ ");
        System.out.println("▓  ██▒ ▓▒▓██▒▒██▀ ▀█  ▓  ██▒ ▓▒▒████▄    ▒██▀ ▀█  ▓  ██▒ ▓▒▒██▒  ██▒▓█   ▀ ");
        System.out.println("▒ ▓██░ ▒░▒██▒▒▓█    ▄ ▒ ▓██░ ▒░▒██  ▀█▄  ▒▓█    ▄ ▒ ▓██░ ▒░▒██░  ██▒▒███   ");
        System.out.println("░ ▓██▓ ░ ░██░▒▓▓▄ ▄██▒░ ▓██▓ ░ ░██▄▄▄▄██ ▒▓▓▄ ▄██▒░ ▓██▓ ░ ▒██   ██░▒▓█  ▄ ");
        System.out.println("  ▒██▒ ░ ░██░▒ ▓███▀ ░  ▒██▒ ░  ▓█   ▓██▒▒ ▓███▀ ░  ▒██▒ ░ ░ ████▓▒░░▒████▒");
        System.out.println("  ▒ ░░   ░▓  ░ ░▒ ▒  ░  ▒ ░░    ▒▒   ▓▒█░░ ░▒ ▒  ░  ▒ ░░   ░ ▒░▒░▒░ ░░ ▒░ ░");
        System.out.println("    ░     ▒ ░  ░  ▒        by Syntaxerror  ░  ▒       ░      ░ ▒ ▒░  ░ ░  ░");
        System.out.println("  ░       ▒ ░░          ░        ░   ▒   ░          ░      ░ ░ ░ ▒     ░   ");
        System.out.println("                                     ░  ░░ ░                   ░ ░     ░  ░");
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
