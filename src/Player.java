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

    public void play(HashMap<UnitKey, Unit> board, char symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row and column number (0-2) separated " +
                "by a space:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        UnitKey key = new UnitKey(row, col);
        if(board.containsKey(key)) {
            Unit unit = board.get(key);
            if(!unit.isFilled()) {
                unit.fill(symbol);
            } else {
                System.out.println("This unit is already filled. Try again.");
                play(board, symbol);
            }
        } else {
            System.out.println("Invalid row and column number. Try again.");
            play(board, symbol);
        }
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
