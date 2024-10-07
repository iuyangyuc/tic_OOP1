/*
    * This class represents a unit in the grid. It has a position (x, y), a symbol, and a boolean to check if it is filled.
 */

public class Unit {

    private int x;
    private int y;
    private boolean isfilled;
    private char symbol;

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
        this.isfilled = false;
        this.symbol = ' ';
    }

    public void fill(char symbol) {
        this.symbol = symbol;
        this.isfilled = true;
    }

    public boolean isFilled() {
        return this.isfilled;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isIsfilled() {
        return isfilled;
    }

    public void setIsfilled(boolean isfilled) {
        this.isfilled = isfilled;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
