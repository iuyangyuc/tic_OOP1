import java.util.HashMap;
import java.util.Scanner;

public class Player {

    private String name;
    private char symbol;
    private int wins;
    private int losses;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public double getWinRate() {
        return (double) wins / (wins + losses);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }
}
