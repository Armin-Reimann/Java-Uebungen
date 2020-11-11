package swing;

import java.awt.event.*;
import javax.swing.*;
public class FirstSwingExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");
        f.setTitle("Tic Tac Toe by Armin Reimann");
        //erstellt die beiden X und O Icons
        //todo noch bilder für einen sieg einbinden
        Icon i_o, i_x;
        i_o = new ImageIcon("src/swing/O.png");
        i_x = new ImageIcon("src/swing/X.png");



        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        JButton[] b = new JButton[9];

        for(int i=0; i<=8; i++){
            b[i] = new JButton(new ImageIcon("src/swing/X.png"));
            int[] buttonBound = getButtonBounds(i);
            b[i].setBounds(buttonBound[0],buttonBound[1],buttonBound[2],buttonBound[3]);
        }
        for(int i=0; i<=8; i++){
            f.add(b[i]);
        }
//        f.add(b);f.add(tf);
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static int[] getButtonBounds(int i){
        int[][] buttonBounds = new int[9][4];
        buttonBounds[0] = new int[]{10, 10, 150, 150};
        buttonBounds[1] = new int[]{170, 10, 150, 150};
        buttonBounds[2] = new int[]{330, 10, 150, 150};
        buttonBounds[3] = new int[]{10, 170, 150, 150};
        buttonBounds[4] = new int[]{170, 170, 150, 150};
        buttonBounds[5] = new int[]{330, 170, 150, 150};
        buttonBounds[6] = new int[]{10, 330, 150, 150};
        buttonBounds[7] = new int[]{170, 330, 150, 150};
        buttonBounds[8] = new int[]{330, 330, 150, 150};
        return buttonBounds[i];
    }
}  