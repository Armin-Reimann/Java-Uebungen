package tic_tac_toe;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class TTTFrame extends JFrame {
    Icon i_o, i_x;
    int page = 0;
    JLabel[] a_label = new JLabel[4];
    JTextField[] a_textfield = new JTextField[4];
    JCheckBox[] a_checkbox = new JCheckBox[4];
    Player[] a_player = new Player[2];
    boolean b_bot = false;
    boolean b_player = false;

    public TTTFrame(String button_example) {
        super();
        //todo noch bilder für einen sieg einbinden
        this.i_o = new ImageIcon("src/swing/O.png");
        this.i_x = new ImageIcon("src/swing/X.png");
        this.erstelleWeiterButton();
        this.erzeugeAlleLabels();
        this.erzeugeAlleTextFields();
        this.erzeugeAlleCheckbox();
        this.erzeugePlayer();
        // todo um z.B. das Willkommen-Label unsichtbar zu machen kann man hoffentlich .setVisible() nutzen
        this.runPageActions();
//        this.willkommen();
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

    public void erstelleWeiterButton(){
        JButton weiter = new JButton("Weiter");
        weiter.setBounds(600,650,95,30);
        weiter.addActionListener(a->{
//            System.out.println("Page: "+this.page);
            this.runPageActions();

//            this.willkommen();
            this.page ++;
        });
        this.add(weiter);
    }

    public void erstelleLabel(String inhalt){
//        System.out.println("inhalt: " + inhalt);
        JLabel asdf = new JLabel("test");
//        asdf.setVisible(false);
        asdf.setBounds(300,50, 100,30);
//        System.out.println("test");
        System.out.println("this: "+this);
        this.add(asdf);
    }

    public void erzeugePlayer(){
        Player a = new Player(0);
        Player b = new Player(1);
        this.a_player[0] = a;
        this.a_player[1] = b;
    }

    public void erzeugeTTT(){
        String b_bot = null;
        boolean check = false;
        char[][] leer = new char[1][1];
        leer[0][0] = 'f';
        Board board = new Board(leer);

//        Scanner scanner = new Scanner(System.in);
//        Player a = new Player(0);
//        Player b = new Player(1);
//        System.out.println("Namen für ersten Spieler eingeben!");
//        a.setName(scanner.next());
//        Player[] a_player = new Player[2];
//        a_player[0] = a;
//        a_player[1] = b;

//        while (!check){
//            System.out.println("Gegen einen Bot spielen? [j/n]");
//            b_bot = scanner.next();
//            if(b_bot.equals("j")){
//                b.setBot();
//                System.out.println("Schwierigkeit einstellen: leicht(1) schwer(2)");
//                b.setSchwierigkeit(scanner.nextInt());
//                check = true;
//            }else if(b_bot.equals("n")){
//                System.out.println("Namen für zweiten Spieler eingeben!");
//                b.setName(scanner.next());
//                check = true;
//            }else {
//                System.out.println("Falsche Eingabe, bitte wiederholen!");
//            }
//        }

        JButton[] a_button = new JButton[9];
        char [][] tempboard = board.getInhalt();
        for(int i=0; i<=8; i++){
            a_button[i] = new JButton(new ImageIcon("src/swing/leer.png"));
            int[] buttonBound = this.getButtonBounds(i, 120, 100,150,150,10 );
            a_button[i].setBounds(buttonBound[0],buttonBound[1],buttonBound[2],buttonBound[3]);
            int finalI = i;
            boolean finalB_bot = this.b_bot;
            a_button[i].addActionListener(e -> {
//                System.out.println("jakfaklfklasdfklasdfjlöasdjf");
                if (board.getTurn() == 1){
                    a_button[finalI].setIcon(new ImageIcon("src/swing/O.png"));
                    int[] tempZug = this.a_player[0].convertInput(finalI);
                    tempboard[tempZug[0]][tempZug[1]] = 'O';
                }else{
                    a_button[finalI].setIcon(new ImageIcon("src/swing/X.png"));
                    int[] tempZug = this.a_player[1].convertInput(finalI);
                    tempboard[tempZug[0]][tempZug[1]] = 'X';
                }
                board.setWinner(Board.checkWinner(tempboard));
                if(this.checkWinner(board.getWinner(), this.a_player)){
                    return;
                }
                board.setTurn();
                if(finalB_bot){
                    int[] botTurn = this.a_player[1].getBotTurn(tempboard);
                    int convertierterInput = this.a_player[1].convertInputBack(botTurn);
                    if (convertierterInput == -1){
                        return;
                    }
                    a_button[convertierterInput].setIcon(new ImageIcon("src/swing/X.png"));
                    tempboard[botTurn[0]][botTurn[1]] = 'X';
                    board.setWinner(Board.checkWinner(tempboard));
                    board.setTurn();
//                    if(!checkWinner(board.getWinner(), this.a_player)){
//                        this.endbildschirm();
//                    }

                }
            });
        }
        for(int i=0; i<=8; i++){
            this.add(a_button[i]);
        }
    }

    public  boolean checkWinner(int winner, Player[] player){

        if(winner == 0){
            System.out.println(player[0].name + " hat gewonnen!");
            return true;
        }else if (winner == 1){
            System.out.println(player[1].name + " hat gewonnen!");
            return true;
        }
        else if(winner == -1){
            System.out.println("Unentschieden!");
            return true;
        }else{
            return false;
        }
    }

    protected void runPageActions(){
        switch (this.page) {
            case 0 -> {
                this.willkommen();
            }
            case 1 -> {
                this.resetVisibility();
                this.showSpielmodus();
            }
            case 2 -> {
                this.checkSpielmodus();
                this.resetVisibility();
                if(this.b_bot){
                    this.showSchwierigkeit();
                }else {
                    this.page ++;
                    this.runPageActions();
                }
            }
            case 3 -> {
                this.checkSchwierigkeit();
                this.resetVisibility();
                if(this.b_bot){
                    this.showSpielernamen(1);
                }else {
                    this.showSpielernamen(2);
                }
            }
            case 4 -> {
                this.checkNamen();
                this.resetVisibility();
                this.erzeugeTTT();
            }
            default -> System.out.println("Page nicht definiert");
        }
    }

    protected void showSpielernamen(int anzahl){
        //todo hier jeweils noch die Label für die TextFields hinzufügen
        this.a_textfield[0].setVisible(true);
        if(anzahl == 2){
            this.a_textfield[1].setVisible(true);
        }
    }

    protected void showSchwierigkeit(){
        this.a_checkbox[2].setVisible(true);
        this.a_checkbox[3].setVisible(true);
    }

    protected void showSpielmodus(){
        this.a_checkbox[0].setVisible(true);
        this.a_checkbox[1].setVisible(true);
    }

    protected void seiteZurueck(){
        this.page --;
        this.runPageActions();
    }

    protected void checkSpielmodus(){
        if(!this.b_bot && !this.b_player){
            this.seiteZurueck();
        }
    }

    protected void checkSchwierigkeit(){
        if (this.a_player[1].getSchwierigkeit() == 0){
            this.seiteZurueck();
        }
    }

    protected void checkNamen(){
        String textinput1, textinput2;
        if(this.b_bot){
            textinput1 = this.a_textfield[0].getText();
            if (textinput1.equals("")){
                this.seiteZurueck();
            }else{
                this.a_player[0].setName(textinput1);
            }
        }else {
            textinput1 = this.a_textfield[0].getText();
            textinput2 = this.a_textfield[1].getText();
            if (textinput1.equals("") || textinput2.equals("")){
                this.seiteZurueck();
            }else {
                this.a_player[0].setName(textinput1);
                this.a_player[1].setName(textinput2);
            }
        }

    }

    public void willkommen(){
        this.a_label[0].setVisible(true);
    }

    protected void resetVisibility(){
//        this.resetSeperatVisibility(this.a_label);
//        this.resetSeperatVisibility(this.a_textfield);
//        this.resetSeperatVisibility(this.a_checkbox);

        for (JLabel jLabel : this.a_label) {
            jLabel.setVisible(false);
        }
        for (JTextField jTextField : this.a_textfield) {
            jTextField.setVisible(false);
        }
        for (JCheckBox aCheckbox : this.a_checkbox) {
            aCheckbox.setVisible(false);
        }
    }

//    protected void resetSeperatVisibility(String s_input){
////        int[] input = new int[99];
//        switch (s_input) {
//            case "label" -> {
//                JLabel[] input = this.a_label;
//            }
//            case "textfield" -> {
//                JTextField[] input = this.a_textfield;
//            }
//            case "checkbox" -> {
//                JCheckBox[] input = this.a_checkbox;
//            }
//            default -> {
//                int[] input = new int[99];
//            }
//        }
//
//        for (int i = 0; i < input.length(); i++){
//
//        }
//    }

    protected void erzeugeAlleLabels(){
        JLabel lab_willkommen, lab_2, lab_3, lab_4;
        lab_willkommen = new JLabel("Willkommen zu Tic-Tac-Toc");
        lab_2 = new JLabel("Test Lab2");
        lab_3 = new JLabel("Test Lab3");
        lab_4 = new JLabel("Test Lab4");

        lab_willkommen.setBounds(300,50,200,30);
        lab_2.setBounds(300,50,100,30);
        lab_3.setBounds(300,50,100,30);
        lab_4.setBounds(300,50,100,30);

        lab_willkommen.setVisible(false);
        lab_2.setVisible(false);
        lab_3.setVisible(false);
        lab_4.setVisible(false);

        this.a_label[0] = lab_willkommen;
        this.a_label[1] = lab_2;
        this.a_label[2] = lab_3;
        this.a_label[3] = lab_4;

        this.add(lab_willkommen);
        this.add(lab_2);
        this.add(lab_3);
        this.add(lab_4);
    }

    protected void erzeugeAlleTextFields(){
        JTextField tf_name1, tf_name2, tf_3, tf_4;
        tf_name1 = new JTextField();
        tf_name2 = new JTextField();
        tf_3 = new JTextField();
        tf_4 = new JTextField();

        tf_name1.setBounds(300,100,200,50);
        tf_name2.setBounds(300,200,200,50);
        tf_3.setBounds(300,50,100,30);
        tf_4.setBounds(300,50,100,30);

        tf_name1.setVisible(false);
        tf_name2.setVisible(false);
        tf_3.setVisible(false);
        tf_4.setVisible(false);

        this.a_textfield[0] = tf_name1;
        this.a_textfield[1] = tf_name2;
        this.a_textfield[2] = tf_3;
        this.a_textfield[3] = tf_4;

        this.add(tf_name1);
        this.add(tf_name2);
        this.add(tf_3);
        this.add(tf_4);
    }

    protected void erzeugeAlleCheckbox(){
        JCheckBox cb_bot, cb_player, cb_leicht, cb_schwer;
        cb_bot = new JCheckBox("Bot");
        cb_player = new JCheckBox("Mitspieler");
        cb_leicht = new JCheckBox("leicht");
        cb_schwer = new JCheckBox("schwer");

        cb_bot.setBounds(150,250,100,50);
        cb_player.setBounds(450,250,100,50);
        cb_leicht.setBounds(300,100,100,50);
        cb_schwer.setBounds(300,200,100,50);

        cb_bot.setVisible(false);
        cb_player.setVisible(false);
        cb_leicht.setVisible(false);
        cb_schwer.setVisible(false);

        cb_bot.addActionListener(e -> {
            this.b_bot = true;
        });
        cb_player.addActionListener(e -> {
            this.b_player = true;
        });
        cb_leicht.addActionListener(e -> {
            this.a_player[1].setSchwierigkeit(1);
        });
        cb_schwer.addActionListener(e -> {
            this.a_player[1].setSchwierigkeit(2);
        });

        this.a_checkbox[0] = cb_bot;
        this.a_checkbox[1] = cb_player;
        this.a_checkbox[2] = cb_leicht;
        this.a_checkbox[3] = cb_schwer;

        this.add(cb_bot);
        this.add(cb_player);
        this.add(cb_leicht);
        this.add(cb_schwer);
    }


}
