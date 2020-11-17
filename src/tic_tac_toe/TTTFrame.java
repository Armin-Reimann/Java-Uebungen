package tic_tac_toe;

import javax.swing.*;

public class TTTFrame extends JFrame {
    Icon i_o, i_x;
    int page;
    JLabel[] a_label = new JLabel[4];

    public TTTFrame(String button_example) {
        super();
        //todo noch bilder für einen sieg einbinden
        this.i_o = new ImageIcon("src/swing/O.png");
        this.i_x = new ImageIcon("src/swing/X.png");
        this.erstelleWeiterButton();
        this.erzeugeAlleLabels();

        // todo um z.B. das Willkommen-Label unsichtbar zu machen kann man hoffentlich .setVisible() nutzen
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
//            this.runPageActions();

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

    public void erzeugeTTT(Board board, Player[] a_player, String b_bot){
        JButton[] a_button = new JButton[9];
        char [][] tempboard = board.getInhalt();
        for(int i=0; i<=8; i++){
            a_button[i] = new JButton(new ImageIcon("src/swing/leer.png"));
            int[] buttonBound = this.getButtonBounds(i, 120, 100,150,150,10 );
            a_button[i].setBounds(buttonBound[0],buttonBound[1],buttonBound[2],buttonBound[3]);
            int finalI = i;
            a_button[i].addActionListener(e -> {
//                System.out.println("jakfaklfklasdfklasdfjlöasdjf");
                if (board.getTurn() == 1){
                    a_button[finalI].setIcon(new ImageIcon("src/swing/O.png"));
                    int[] tempZug = a_player[0].convertInput(finalI);
                    tempboard[tempZug[0]][tempZug[1]] = 'O';
                }else{
                    a_button[finalI].setIcon(new ImageIcon("src/swing/X.png"));
                    int[] tempZug = a_player[1].convertInput(finalI);
                    tempboard[tempZug[0]][tempZug[1]] = 'X';
                }
                board.setWinner(Board.checkWinner(tempboard));
                if(this.checkWinner(board.getWinner(), a_player)){
                    return;
                }
                board.setTurn();
                if(b_bot.equals("j")){
                    int[] botTurn = a_player[1].getBotTurn(tempboard);
                    int convertierterInput = a_player[1].convertInputBack(botTurn);
                    if (convertierterInput == -1){
                        return;
                    }
                    a_button[convertierterInput].setIcon(new ImageIcon("src/swing/X.png"));
                    tempboard[botTurn[0]][botTurn[1]] = 'X';
                    board.setWinner(Board.checkWinner(tempboard));
                    board.setTurn();
//                    if(!checkWinner(board.getWinner(), a_player)){
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
//                this.getContentPane().removeAll();
                this.willkommen();
//                this.erstelleWeiterButton();
            }
            case 1 -> {
//                this.getContentPane().removeAll();
//                this.erstelleLabel("Seite2");
//                this.erstelleWeiterButton();
            }
            default -> System.out.println("Page nicht definiert");
        }
    }

    public void willkommen(){
        this.a_label[0].setVisible(true);
    }

    public void erzeugeAlleLabels(){
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
}
