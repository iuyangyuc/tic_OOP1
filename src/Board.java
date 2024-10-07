
/*
Interface for the Board class
 */

public interface Board {
    public void displayBoard();
    public boolean checkWin();
    public void fillUnit(char symbol);
    public void modifyUnit(int row, int col, char symbol);
    public void setBoard(int size);
}
