package praktikum_6;

public class Rechteck {

    public static double berechneFlaeche(double a, double b) {
        return a*b;
    }

    public static double berechneFlaeche(double a, double b, double c) {
        return (2*a*b)+(2*a*c)+(2*b*c);
    }

    public static double berechneVolumen(double a, double b, double c) {
        return a*b*c;
    }

    public static double berechneUmfang(double a, double b){
        return (2*a)+(2*b);
    }

    public static boolean istQuadrat(double a, double b){
        return a == b;
    }
}
