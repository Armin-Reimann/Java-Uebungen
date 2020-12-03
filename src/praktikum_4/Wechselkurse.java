package praktikum_4;

import java.lang.reflect.Array;
import java.util.*;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wechselkurse {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double euro = 0;
        String wechselWaehrung;
        double wechselkurs = 1;
        double endergebnis = 0;
        System.out.println("Bitte Eurobetrag eingeben:");
        euro = s.nextDouble();
        System.out.println("Bitte Währung (usd oder yen) eingeben:");
        wechselWaehrung = s.next();
        wechselkurs = getWechselkurs(wechselWaehrung);
        endergebnis = euro*wechselkurs;
        System.out.println("Der eingegebene Eurobetrag: "+round(euro,2)+"€ ist "+endergebnis+" "+wechselWaehrung+" wert");
        long test[] = new long[11];
//        int anzahl = test.
    }

    /**
     * Rundet den übergebenen Wert auf die Anzahl der übergebenen Nachkommastellen
     * @param value ist der zu rundende Wert.
     * @param decimalPoints ist die Anzahl der Nachkommastellen, auf die gerundet werden soll.
     */
    public static double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }

    public static double getWechselkurs(String waehrung){
        double wechselkurs = 1;
        if (waehrung.equals("usd")){

            try {
                // Dokument von URL laden
                Document doc = Jsoup.connect("https://wechselkurse-euro.de/kurse/USD-dollar-vereinigte-staaten-von-amerika/").get();
                // Liste der Anker holen
                Elements values = doc
                        .select("#kurzy_table > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)");
                // Liste durchlaufen und Ankertexte und Sprungziele darstellen
                for (Element elem : values) {
//                System.out.println(elem.text());
                    wechselkurs =  Double.parseDouble(elem.text().split(" ")[0]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                // Dokument von URL laden
                Document doc = Jsoup.connect("https://wechselkurse-euro.de/kurse/JPY-yen-japan/").get();
                // Liste der Anker holen
                Elements values = doc
                        .select("#kurzy_table > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)");
                // Liste durchlaufen und Ankertexte und Sprungziele darstellen
                for (Element elem : values) {
//                System.out.println(elem.text());
                    wechselkurs =  Double.parseDouble(elem.text().split(" ")[0]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wechselkurs;
    }
}
