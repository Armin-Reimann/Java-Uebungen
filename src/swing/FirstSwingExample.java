package swing;

import java.awt.event.*;
import javax.swing.*;
public class FirstSwingExample {
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example");
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        JButton b=new JButton(new ImageIcon("src/swing/O.png"));
        b.setBounds(10,10,270,270);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to Javatpoint.");
            }
        });
        f.add(b);f.add(tf);
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }
}  