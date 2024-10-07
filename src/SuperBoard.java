import java.util.HashMap;
import java.util.Scanner;


/*
SuperBoard class to store and manipulate the super board for the Super Tic Tac Toe game.
 */
public class SuperBoard implements Board{

    private HashMap<Integer, BaseBoard> superBoard;
    private Play tool;

    public SuperBoard() {
        superBoard = new HashMap<>();
        tool = new Play();
        setBoard(3);
    }

    public void displayBoard() {
        for (int i = 0; i < 9; i++) {
            BaseBoard board = superBoard.get(i);
            System.out.println("Board " + i + ":");
            board.displayBoard();
        }
    }

    private void buildWinningBoard() {
        for (int i = 0; i < 9; i++) {
            BaseBoard board = superBoard.get(i);
            board.setWinner(board.getWinningSymbol());
        }
    }

    public boolean checkWin() {
        buildWinningBoard();
        for (int i = 0; i < 3; i++) {
            if (superBoard.get(i * 3).checkWin() &&
                superBoard.get(i * 3).getWinner() == superBoard.get(i * 3 + 1).getWinner() &&
                superBoard.get(i * 3 + 1).getWinner() == superBoard.get(i * 3 + 2).getWinner()) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (superBoard.get(i).checkWin() &&
                superBoard.get(i).getWinner() == superBoard.get(i + 3).getWinner() &&
                superBoard.get(i + 3).getWinner() == superBoard.get(i + 6).getWinner()) {
                return true;
            }
        }

        if (superBoard.get(0).checkWin() &&
            superBoard.get(0).getWinner() == superBoard.get(4).getWinner() &&
            superBoard.get(4).getWinner() == superBoard.get(8).getWinner()) {
            return true;
        }

        if (superBoard.get(2).checkWin() &&
            superBoard.get(2).getWinner() == superBoard.get(4).getWinner() &&
            superBoard.get(4).getWinner() == superBoard.get(6).getWinner()) {
            return true;
        }

        return false;
    }

    public void fillUnit(char symbol) {
        System.out.println("Enter which baseBoard you would like to play on (0-8): ");
        int boardNum = tool.takeValidInput(0, 8);
        BaseBoard board = superBoard.get(boardNum);
        board.fillUnit(symbol);
    }

    public void modifyUnit(int row, int col, char symbol) {
        System.out.println("Enter which baseBoard you would like to play on (0-8): ");
        int boardNum = tool.takeValidInput(0, 8);
        BaseBoard board = superBoard.get(boardNum);
        board.modifyUnit(row, col, symbol);
    }

    public void setBoard(int size) {
        for (int i = 0; i < 9; i++) {
            BaseBoard baseBoard = new BaseBoard(size);
            superBoard.put(i, baseBoard);
        }
    }
}
