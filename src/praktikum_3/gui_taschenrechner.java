package praktikum_3;

import javax.swing.*;

public class gui_taschenrechner
{
    public static void main(String[] args)
    {
        JFrame f= new JFrame("Praktikum 3 Pro-Aufgabe (Taschenrechner)");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();

        t1.setBounds(40,100, 200,30);
        t2.setBounds(40,140, 200,30);

        JButton b=new JButton("Berechne");
        b.setBounds(250,100,120,30);
        b.addActionListener(e -> {
            double ergebnis = getErgebnis(t1.getText());
            t2.setText(String.valueOf(ergebnis));
        });

        f.add(b);
        f.add(t1);
        f.add(t2);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static double getErgebnis(String input){
        String[] zahlen;
        double ergebnis = 0;
        if(input.contains("+")){
            zahlen = input.split("\\+");
            ergebnis = berechne(zahlen, "+");
        }else if(input.contains("-")){
            zahlen = input.split("-");
            ergebnis = berechne(zahlen, "-");
        }else if(input.contains("*")){
            zahlen = input.split("\\*");
            ergebnis = berechne(zahlen, "*");
        }else if(input.contains("/")){
            zahlen = input.split("/");
            ergebnis = berechne(zahlen, "/");
        }else if(input.contains(":")){
            zahlen = input.split(":");
            ergebnis = berechne(zahlen, ";");
        }
        return ergebnis;
    }

    public static double berechne(String[] input, String rechenzeichen){
        double zahl1 = Double.parseDouble(input[0]);
        double zahl2 = Double.parseDouble(input[1]);
        return switch (rechenzeichen) {
            case "+" -> zahl1 + zahl2;
            case "-" -> zahl1 - zahl2;
            case "*" -> zahl1 * zahl2;
            case "/", ":" -> zahl1 / zahl2;
            default -> 0;
        };
    }

}