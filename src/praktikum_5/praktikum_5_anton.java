package praktikum_5;

public class praktikum_5_anton {
    public static void main (String[] args) {
        int i = new java.util.Scanner(System.in) .nextInt();
        switch (i) {
            case 1, 2, 12 -> System.out.println("Es ist Winter");
            case 3, 4, 5 -> System.out.println("Es ist Frühling");
            case 6, 7, 8 -> System.out.println("Es ist Sommer");
            case 9, 10, 11 -> System.out.println("Es ist Herbst");
            default -> System.out.println("- unbekannter Monat -");
        }
    }
}
