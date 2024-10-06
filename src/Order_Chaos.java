import java.util.*;

public class Order_Chaos implements TicTacToe {

    private Player player1;
    private Player player2;
    Team team1;
    Team team2;
    BaseBoard baseBoard;
    private int size;
    private int turn;

    private final char X = 'X';
    private final char O = 'O';

    public Order_Chaos(Player player1, Player player2, Team team1, Team team2, BaseBoard board, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.team1 = team1;
        this.team2 = team2;
        this.baseBoard = board;
        this.size = size;
    }

    public Order_Chaos(Player player1, Player player2, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.size = size;
    }

    public Order_Chaos(Team team1, Team team2, int size) {
        this.team1 = team1;
        this.team2 = team2;
        this.size = size;
    }

    public boolean checkWin() {
        int winLength = 5;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winLength; j++) {
                char symbol = baseBoard.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (baseBoard.get(new UnitKey(i, j + k)).getSymbol() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= size - winLength; i++) {
                char symbol = baseBoard.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (baseBoard.get(new UnitKey(i + k, j)).getSymbol() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        for (int i = 0; i <= size - winLength; i++) {
            for (int j = 0; j <= size - winLength; j++) {
                char symbol = baseBoard.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (baseBoard.get(new UnitKey(i + k, j + k)).getSymbol() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        for (int i = 0; i <= size - winLength; i++) {
            for (int j = winLength - 1; j < size; j++) {
                char symbol = baseBoard.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (baseBoard.get(new UnitKey(i + k, j - k)).getSymbol() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        return false;
    }

    public void playGame_Single() {
        boolean continueGame = true;
        baseBoard = new BaseBoard(size);
        while (continueGame) {
            baseBoard.displayBoard();
            turn = 1;
            while (true) {
                if (turn % 2 == 1) {
                    System.out.println(player1.getName() + "'s turn");
                    placeSymbol(player1, player2);
                }
                else {
                    System.out.println(player2.getName() + "'s turn");
                    placeSymbol(player2, player1);
                }
                baseBoard.displayBoard();
                if (checkWin()) {
                    if (turn % 2 == 1) {
                        System.out.println(player1.getName() + " wins!");
                        player1.incrementWins();
                        player2.incrementLosses();
                    }
                    else {
                        System.out.println(player2.getName() + " wins!");
                        player2.incrementWins();
                        player1.incrementLosses();
                    }
                    break;
                }
                if (turn == size * size) {
                    System.out.println("It's a draw!");
                    break;
                }
                turn++;
            }
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.equalsIgnoreCase("N")) {
                continueGame = false;
                System.out.println(player1.getName() + " winrate: " + player1.getWinRate());
                System.out.println(player2.getName() + " winrate: " + player2.getWinRate());
            }
        }
    }


    public void playGame_Team() {
        boolean continueGame = true;
        baseBoard = new BaseBoard(size);
        Player currentPlayer1 = team1.randomPlayer();
        Player currentPlayer2 = team2.randomPlayer();
        while (continueGame) {
            baseBoard.displayBoard();
            turn = 1;
            System.out.println("Team1's player: " + currentPlayer1.getName());
            System.out.println("Team2's player: " + currentPlayer2.getName());
            while (true) {
                if (turn % 2 == 1) {
                    currentPlayer1 = team1.switchPlayer(team1, currentPlayer1);
                    System.out.println(currentPlayer1.getName() + "'s turn");
                    placeSymbol(player1, player2);
                }
                else {
                    currentPlayer2 = team2.switchPlayer(team2, currentPlayer2);
                    System.out.println(currentPlayer2.getName() + "'s turn");
                    placeSymbol(player2, player1);
                }
                baseBoard.displayBoard();
                if (checkWin()) {
                    if (turn % 2 == 1) {
                        System.out.println("Team 1 wins!");
                        team1.incrementWins();
                        team2.incrementLosses();
                    }
                    else {
                        System.out.println("Team 2 wins!");
                        team2.incrementWins();
                        team1.incrementLosses();
                    }
                    break;
                }
                if (turn == size * size) {
                    System.out.println("It's a draw!");
                    break;
                }
                turn++;
            }
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.equalsIgnoreCase("N")) {
                continueGame = false;
                team1.printWinRate();
                team2.printWinRate();
            }
        }
    }

    private void placeSymbol(Player currentplayer, Player opponent) {
        System.out.println("Do you want to place opponent's symbol? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        if (response.equalsIgnoreCase("Y")) {
            baseBoard.fillUnit(opponent.getSymbol());
        }
        else {
            baseBoard.fillUnit(currentplayer.getSymbol());
        }
    }
}