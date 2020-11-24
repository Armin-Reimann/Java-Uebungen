package praktikum_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Lösung von Thomas

public class Profi2 extends JFrame {
    JLabel lblHead;
    JLabel lblRechnung;
    JLabel lblOperand;
    JLabel lblTrenner;

    JTextField tfEingabe1;
    JTextField tfEingabe2;


    JButton btnPlus;
    JButton btnMinus;
    JButton btnMal;
    JButton btnGeteilt;


    //Konstruktor
    public Profi2(){
        setTitle("SR GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 230);
        setResizable(false);
        setLayout(new FlowLayout());

        initComponents();
        addComponents();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {
        lblHead = new JLabel("<html><h1><font color='Blue'>Einfacher Rechner</h1></html>");
        lblRechnung = new JLabel("_____noch nichts eingegeben_____");
        lblOperand = new JLabel("Wähle den Operanten");
        lblTrenner = new JLabel("_______________________________");
        tfEingabe1 = new JTextField(10);
        tfEingabe2 = new JTextField(10);


        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Double dEin1 = Double.valueOf(tfEingabe1.getText());
                Double dEin2 = Double.valueOf(tfEingabe2.getText());
                Double dErg = dEin1 + dEin2;
                String strErg = Double.toString(dErg);
                lblRechnung.setText(tfEingabe1.getText() + " + " + tfEingabe2.getText() + " = " + strErg);
			}
        });
        btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Double dEin1 = Double.valueOf(tfEingabe1.getText());
                Double dEin2 = Double.valueOf(tfEingabe2.getText());
                Double dErg = dEin1 - dEin2;
                String strErg = Double.toString(dErg);
                lblRechnung.setText(tfEingabe1.getText() + " - " + tfEingabe2.getText() + " = " + strErg);
			}
        });
        btnMal = new JButton("*");
        btnMal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Double dEin1 = Double.valueOf(tfEingabe1.getText());
                Double dEin2 = Double.valueOf(tfEingabe2.getText());
                Double dErg = dEin1 * dEin2;
                String strErg = Double.toString(dErg);
                lblRechnung.setText(tfEingabe1.getText() + " * " + tfEingabe2.getText() + " = " + strErg); 
			}
        });
        btnGeteilt = new JButton("/");
        btnGeteilt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Double dEin1 = Double.valueOf(tfEingabe1.getText());
                Double dEin2 = Double.valueOf(tfEingabe2.getText());
                double dErg = dEin1 / dEin2;
                String strErg = Double.toString(dErg);
                lblRechnung.setText(tfEingabe1.getText() + " / " + tfEingabe2.getText() + " = " + strErg); 
			}
        });
    }

    public void addComponents() {
        add(lblHead);
        add(lblRechnung);
        add(lblTrenner);
        add(tfEingabe1);
        add(tfEingabe2);
        add(btnPlus);
        add(btnMinus);
        add(btnMal);
        add(btnGeteilt);
    }

    public static void main(String[] args){
        Profi2 Gui = new Profi2();
    }
}
