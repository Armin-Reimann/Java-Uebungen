package syntaxerror;

public interface Brett {
    void printBoard();
    String checkWinner();
    boolean validateTurn(int[] turn);
    void setFeld(int[] turnField, String zeichen);

    int[][] getFreieFelderarray();

    String[][] getBoard();
}
