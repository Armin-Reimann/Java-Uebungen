package hello_world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hello extends JFrame {
    public Hello(){
        //testkommentar von notebook
        setTitle("Unsere GUI");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        JButton button = new JButton("test");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(button));
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(button));
        gl.setAutoCreateContainerGaps(true);
    }
}