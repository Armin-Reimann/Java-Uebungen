package praktikum_6;

import javax.swing.*;

public class RechteckMain {
    public static void main(String[] args){

        JFrame f= new JFrame("Praktikum 6 Pro-Aufgabe (Viereck darstellen)");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();

        DefaultListModel<String> l1 = new DefaultListModel<>();
        JList<String> list = new JList<>(l1);
        list.setBounds(40,180, 200,150);

        t1.setBounds(40,100, 200,30);
        t2.setBounds(40,140, 200,30);
        t3.setBounds(40,60, 200,30);

        JButton b= new JButton("Zeige an");
        JButton bQuader =new JButton("Berechne Quader");
        JButton ergebnis = new JButton();
        b.setBounds(250,100,120,30);
        bQuader.setBounds(370,100,120,30);
        b.addActionListener(e -> {
            double laenge = Double.parseDouble(t1.getText());
            double breite = Double.parseDouble(t2.getText());
            double umfang = Rechteck.berechneUmfang(laenge,breite);
            double flaeche = Rechteck.berechneFlaeche(laenge,breite);
            boolean quadrat = Rechteck.istQuadrat(laenge,breite);
            ergebnis.setBounds(250,220, (int)laenge,(int)breite);
            if (quadrat){
                ergebnis.setText("Quadrat");
            }else{
                ergebnis.setText("Rechteck");
            }
            l1.addElement("Breite: "+ laenge + " (ca. "+(int)laenge+" Pixel)");
            l1.addElement("Länge: "+ breite + " (ca. "+(int)breite+" Pixel)");
            l1.addElement("Umfang: "+ umfang + " (ca. "+(int)umfang+" Pixel)");
            l1.addElement("Fläche: "+ flaeche + " (ca. "+(int)flaeche+" Pixel)");

        });

        bQuader.addActionListener(e -> {
            double laenge = Double.parseDouble(t1.getText());
            double breite = Double.parseDouble(t2.getText());
            double hoehe = Double.parseDouble(t3.getText());
            double volumen = Rechteck.berechneVolumen(laenge,breite, hoehe);
            double flaeche = Rechteck.berechneFlaeche(laenge,breite, hoehe);

            l1.removeAllElements();
            l1.addElement("Breite: "+ laenge + " (ca. "+(int)laenge+" Pixel)");
            l1.addElement("Länge: "+ breite + " (ca. "+(int)breite+" Pixel)");
            l1.addElement("Höhe: "+ hoehe + " (ca. "+(int)hoehe+" Pixel)");
            l1.addElement("Fläche: "+ flaeche + " (ca. "+(int)flaeche+" Pixel)");
            l1.addElement("Volumen: "+ volumen + " (ca. "+(int)volumen+" Pixel)");
        });

        f.add(bQuader);
        f.add(t3);
        f.add(list);
        f.add(b);
        f.add(ergebnis);
        f.add(t1);
        f.add(t2);
        f.setSize(1200,1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
}
