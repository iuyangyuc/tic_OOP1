import java.util.*;

public class Order_Chaos implements Game {

    private Player player1;
    private Player player2;
    Team team1;
    Team team2;
    GameBoard board;
    private int size;
    private int turn;

    private final char X = 'X';
    private final char O = 'O';

    public Order_Chaos(Player player1, Player player2, Team team1, Team team2, GameBoard board, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.team1 = team1;
        this.team2 = team2;
        this.board = board;
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

        // Check rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winLength; j++) {
                char symbol = board.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (board.get(new UnitKey(i, j + k)).getSymbol() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= size - winLength; i++) {
                char symbol = board.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (board.get(new UnitKey(i + k, j)).getSymbol() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        // Check diagonals (top-left to bottom-right)
        for (int i = 0; i <= size - winLength; i++) {
            for (int j = 0; j <= size - winLength; j++) {
                char symbol = board.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (board.get(new UnitKey(i + k, j + k)).getSymbol() != symbol) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }

        // Check anti-diagonals (top-right to bottom-left)
        for (int i = 0; i <= size - winLength; i++) {
            for (int j = winLength - 1; j < size; j++) {
                char symbol = board.get(new UnitKey(i, j)).getSymbol();
                if (symbol != ' ') {
                    boolean win = true;
                    for (int k = 1; k < winLength; k++) {
                        if (board.get(new UnitKey(i + k, j - k)).getSymbol() != symbol) {
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
        board = new GameBoard(size);
        while (continueGame) {
            board.displayBoard();
            turn = 1;
            while (true) {
                if (turn % 2 == 1) {
                    System.out.println(player1.getName() + "'s turn");
                    board.fillUnit(player1.getSymbol());
                }
                else {
                    System.out.println(player2.getName() + "'s turn");
                    board.fillUnit(player2.getSymbol());
                }
                board.displayBoard();
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
                    System.out.println(player2.getName() + " wins!");
                    player2.incrementWins();
                    player1.incrementLosses();
                    break;
                }
                turn++;
            }
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.equalsIgnoreCase("N")) {
                continueGame = false;
                System.out.println(player1.getName() + " winrate: " +
                        player1.getWinRate());
                System.out.println(player2.getName() + " winrate: " +
                        player2.getWinRate());
            }
        }
    }

    private Player switchPlayer(List<Player> team, Player currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the player name to switch to, " +
                "or 'N' for no switch:");
        String input = scanner.next();
        if (input.equalsIgnoreCase("N")) {
            return currentPlayer;
        }
        for (Player player : team) {
            if (player.getName().equals(input)) {
                return player;
            }
        }
        System.out.println("Player not found. Try again.");
        return switchPlayer(team, currentPlayer);
    }


    public void playGame_Team() {
        boolean continueGame = true;
        Player currentPlayer1 = team1.switchPlayer(team1, team1.getPlayer1());
        Player currentPlayer2 = team2.switchPlayer(team2, team2.getPlayer1());
        while (continueGame) {
            board.displayBoard();
            turn = 1;
            System.out.println("Team1's player: " + currentPlayer1.getName());
            System.out.println("Team2's player: " + currentPlayer2.getName());
            while (true) {
                if (turn % 2 == 1) {
                    currentPlayer1 = team1.switchPlayer(team1, currentPlayer1);
                    System.out.println(currentPlayer1.getName() + "'s turn");
                    //TODO
                    board.fillUnit(X);
                }
                else {
                    currentPlayer2 = team2.switchPlayer(team2, currentPlayer2);
                    System.out.println(currentPlayer2.getName() + "'s turn");
                    //TODO
                    board.fillUnit(O);
                }
                board.displayBoard();
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
                    System.out.println("Team 2 wins!");
                    team2.incrementWins();
                    team1.incrementLosses();
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
}
