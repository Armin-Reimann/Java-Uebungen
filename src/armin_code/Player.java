package armin_code;

import java.util.Scanner;

/** Das Objekt Player wird erstellt und wenn der Spieler die Nummer 0 hat,
 * wird ihm das Zeichen "0" zugewiesen, wenn der Spieler die Nummer 1 hat,
 * wird ihm das Zeichen "X" zugewiesen.
 */
public class Player {
    protected int number;
    protected String zeichen;
    protected String name;
    protected Scanner scanner = new Scanner(System.in);

    public Player(int number){
        this.number = number;
        if(number == 0) {
            zeichen = "O";
        }else if (number == 1){
            zeichen = "X";
        }

    }


    public void setName() {
        AsciiArt.printLeerzeilen(30);
        System.out.println("Spieler " + (number+1) + ", geb deinen Namen ein:");
        name = scanner.next();
        AsciiArt.printLeerzeilen(30);
    }

    public String getName () {
        return name;
    }

    public String getZeichen() {
        return zeichen;
    }

    /** Dem aktuellem Spieler wird durch das System.out.println mittgeteilt,
     * dass er am Zug ist. Anschließend folgt eine If-Abfrage. Sie liefter, wenn
     * der input kleiner als 9 und größer gleich 0 ist Board.getMapping zurück,
     * ansonsten gibt er die Meldung zurück, dass es sich um eine Ungültige Eingabe
     * handelt und man des nochmal versuchen soll.
     * @param board
     * @return
     */
    public int[] getTurn(Brett board){
       System.out.println(name + " - du bist am Zug! ");
       int input = scanner.nextInt();
       if (input < 9 && input >= 0){
           return Board.getMapping(input);
       }
       System.out.println("Ungültige Eingabe. Bitte nochmal probieren");
       return getTurn(board);
    }

    public void test() {
    }
}
