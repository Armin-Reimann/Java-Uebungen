package praktikum_2;

import javax.swing.*;

public class gui_uebung
{
    public static void main(String[] args)
    {
        JFrame f= new JFrame("Praktikum 2 Pro-Aufgabe");

        JTextField t1 = new JTextField();
        DefaultListModel<String> l1 = new DefaultListModel<>();

        JList<String> list = new JList<>(l1);
        list.setBounds(40,150, 200,100);

        t1.setBounds(40,100, 200,30);

        JButton b=new JButton("Auswertung");
        b.setBounds(250,100,120,30);
        b.addActionListener(e -> {
            long[] auswertung = auswerten(t1.getText());
            l1.addElement("Anzahl Vokale: "+ auswertung[0]);
            l1.addElement("Anzahl Konsonanten: "+ auswertung[3]);
            l1.addElement("Anzahl Zeichen: "+ auswertung[1]);
            l1.addElement("Anzahl Satzzeichen: "+ auswertung[2]);
        });

        f.add(list);
        f.add(b);
        f.add(t1);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static long[] auswerten(String text){
        long[] auswertung = new long[4];
        auswertung[0] = text.chars().filter(ch -> ch == 'e' || ch == 'a' || ch == 'o' || ch == 'i' || ch == 'u').count();
        auswertung[1] = text.chars().filter(ch -> ch != ' ').count();
        auswertung[2] = text.chars().filter(ch -> ch == '.' || ch == ';' || ch == ',' || ch == ':' || ch == '-' || ch == '_').count();
        auswertung[3] = text.chars().filter(ch -> ch != 'e' && ch != 'a' && ch != 'o' && ch != 'i' && ch != 'u' && ch != '.' && ch != ';' && ch != ',' && ch != ':' && ch != '-' && ch != '_' && ch != ' ').count();
        return auswertung;
    }

}