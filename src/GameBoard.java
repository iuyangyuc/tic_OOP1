import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameBoard {

    private int size;
    private HashMap<UnitKey, Unit> board = new HashMap<>();

    public GameBoard(int size) {
        this.size = size;
        setBoard(size);
    }

    public int getSize() {
        return size;
    }

    public HashMap<UnitKey, Unit> getHashMap() {
        return board;
    }

    public Unit get(UnitKey key) {
        return board.get(key);
    }

    public void setBoard(int size) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Unit unit = new Unit(i, j);
                board.put(new UnitKey(i, j), unit);
            }
        }
    }

    public void displayBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                UnitKey key = new UnitKey(i, j);
                if(board.containsKey(key)) {
                    System.out.print("| " + board.get(key).getSymbol()+ " |");
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

public void fillUnit(char symbol) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        try {
            System.out.println("Enter the row and column number (0-" + (size - 1) + ") separated by a space:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            UnitKey key = new UnitKey(row, col);
            if (board.containsKey(key)) {
                Unit unit = board.get(key);
                if (!unit.isFilled()) {
                    unit.fill(symbol);
                    break;
                } else {
                    System.out.println("This unit is already filled. Try again.");
                }
            } else {
                System.out.println("Invalid row and column number. Try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid integers for row and column.");
            scanner.next(); // Clear the invalid input
        }
    }
}

    public boolean checkWin() {
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            char firstSymbol = board.get(new UnitKey(i, 0)).getSymbol();
            if (firstSymbol == ' ') {
                rowWin = false;
            } else {
                for (int j = 1; j < size; j++) {
                    if (board.get(new UnitKey(i, j)).getSymbol() != firstSymbol) {
                        rowWin = false;
                        break;
                    }
                }
            }
            if (rowWin) {
                return true;
            }
        }

        for (int i = 0; i < size; i++) {
            boolean colWin = true;
            char firstSymbol = board.get(new UnitKey(0, i)).getSymbol();
            if (firstSymbol == ' ') {
                colWin = false;
            } else {
                for (int j = 1; j < size; j++) {
                    if (board.get(new UnitKey(j, i)).getSymbol() != firstSymbol) {
                        colWin = false;
                        break;
                    }
                }
            }
            if (colWin) {
                return true;
            }
        }

        boolean diagWin1 = true;
        char firstSymbolDiag1 = board.get(new UnitKey(0, 0)).getSymbol();
        if (firstSymbolDiag1 == ' ') {
            diagWin1 = false;
        }
        else {
            for (int i = 1; i < size; i++) {
                if (board.get(new UnitKey(i, i)).getSymbol() != firstSymbolDiag1) {
                    diagWin1 = false;
                    break;
                }
            }
        }
        if (diagWin1) {
            return true;
        }

        boolean diagWin2 = true;
        char firstSymbolDiag2 = board.get(new UnitKey(0, size - 1)).getSymbol();
        if (firstSymbolDiag2 == ' ') {
            diagWin2 = false;
        }
        else {
            for (int i = 1; i < size; i++) {
                if (board.get(new UnitKey(i, size - i - 1)).getSymbol() != firstSymbolDiag2) {
                    diagWin2 = false;
                    break;
                }
            }
        }
        if (diagWin2) {
            return true;
        }

        return false;
    }

    public void modifyUnit(int row, int col, char symbol) {
        UnitKey key = new UnitKey(row, col);
        if(board.containsKey(key)) {
            Unit unit = board.get(key);
            unit.fill(symbol);
        }
    }
}
