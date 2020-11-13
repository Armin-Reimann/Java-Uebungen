package swing;

import java.awt.event.*;
import javax.swing.*;
public class FirstSwingExample {
    public static void main(String[] args) {
        TTTFrame f = new TTTFrame("Button Example");
        f.setTitle("Tic Tac Toe by Armin Reimann");
        //erstellt die beiden X und O Icons
        //todo noch bilder für einen sieg einbinden
        Icon i_o, i_x;
        i_o = new ImageIcon("src/swing/O.png");
        i_x = new ImageIcon("src/swing/X.png");

        // ab hier beginnt das Tic Tac Toe Spiel
        JButton[] b = new JButton[9];
        for(int i=0; i<=8; i++){
            b[i] = new JButton(new ImageIcon("src/swing/leer.png"));
            int[] buttonBound = f.getButtonBounds(i, 10, 10,150,150,10 );
            b[i].setBounds(buttonBound[0],buttonBound[1],buttonBound[2],buttonBound[3]);
            b[i].addActionListener(e -> {

            });
        }
        for(int i=0; i<=8; i++){
            f.add(b[i]);
        }
//        f.add(b);
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }


}  