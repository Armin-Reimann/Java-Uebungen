package tic_tac_toe;

import javax.swing.*;

public class TTTFrame extends JFrame {
    Icon i_o, i_x;
    public TTTFrame(String button_example) {
        super();
        //todo noch bilder für einen sieg einbinden
        this.i_o = new ImageIcon("src/swing/O.png");
        this.i_x = new ImageIcon("src/swing/X.png");
    }

    public int[] getButtonBounds(int key, int x_start, int y_start, int button_breite , int button_hoehe , int abstand){
        int[][] buttonBounds = new int[9][4];
//        int x_start = 10;
//        int y_start = 10;
//        int button_breite = 150;
//        int button_hoehe = 150;
//        int abstand = 10;
        buttonBounds[0] = new int[]{x_start, y_start, button_breite, button_hoehe};
        buttonBounds[1] = new int[]{x_start+(abstand+button_breite), y_start, button_breite, button_hoehe};
        buttonBounds[2] = new int[]{x_start+((abstand+button_breite)*2), y_start, button_breite, button_hoehe};
        buttonBounds[3] = new int[]{x_start, y_start+(abstand+button_hoehe), button_breite, button_hoehe};
        buttonBounds[4] = new int[]{x_start+(abstand+button_breite), y_start+(abstand+button_hoehe), button_breite, button_hoehe};
        buttonBounds[5] = new int[]{x_start+((abstand+button_breite)*2), y_start+(abstand+button_hoehe), button_breite, button_hoehe};
        buttonBounds[6] = new int[]{x_start, y_start+((abstand+button_hoehe)*2), button_breite, button_hoehe};
        buttonBounds[7] = new int[]{x_start+(abstand+button_breite), y_start+((abstand+button_hoehe)*2), button_breite, button_hoehe};
        buttonBounds[8] = new int[]{x_start+((abstand+button_breite)*2), y_start+((abstand+button_hoehe)*2), button_breite, button_hoehe};
        return buttonBounds[key];
    }
}
