import java.util.*;

public class Order_Chaos {

    private Player player1;
    private Player player2;
    private List<Player> team1 = new ArrayList<>();
    private List<Player> team2 = new ArrayList<>();
    private HashMap<UnitKey, Unit> board = new HashMap<>();
    private int size;
    private int turn;

    private final char X = 'X';
    private final char O = 'O';

    public Order_Chaos(Player player1, Player player2, List<Player> team1,
                     List<Player> team2, HashMap<UnitKey, Unit> board,
                     int size) {
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

    public Order_Chaos(List<Player> team1, List<Player> team2, int size) {
        this.team1 = team1;
        this.team2 = team2;
        this.size = size;
    }

    public void modifyUnit(int x, int y, char symbol) {
        UnitKey key = new UnitKey(x, y);
        if (board.containsKey(key)) {
            board.get(key).fill(symbol);
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

    public void setupGame() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Unit unit = new Unit(i, j);
                board.put(new UnitKey(i, j), unit);
            }
        }
    }

    public void playGame_Single() {
        boolean continueGame = true;
        while (continueGame) {
            setupGame();
            displayBoard();
            turn = 1;
            while (true) {
                if (turn % 2 == 1) {
                    System.out.println(player1.getName() + "'s turn");
                    player1.play(board, X);
                }
                else {
                    System.out.println(player2.getName() + "'s turn");
                    player2.play(board, O);
                }
                displayBoard();
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
            if (response.equals("N")) {
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
        Random rand = new Random();
        Player currentPlayer1 = team1.get(rand.nextInt(team1.size()));
        Player currentPlayer2 = team2.get(rand.nextInt(team2.size()));
        while (continueGame) {
            setupGame();
            displayBoard();
            turn = 1;
            System.out.println("Team1's player: " + currentPlayer1.getName());
            System.out.println("Team2's player: " + currentPlayer2.getName());
            while (true) {
                if (turn % 2 == 1) {
                    currentPlayer1 = switchPlayer(team1, currentPlayer1);
                    System.out.println(currentPlayer1.getName() + "'s turn");
                    currentPlayer1.play(board, X);
                }
                else {
                    currentPlayer2 = switchPlayer(team2, currentPlayer2);
                    System.out.println(currentPlayer2.getName() + "'s turn");
                    currentPlayer2.play(board, O);
                }
                displayBoard();
                if (checkWin()) {
                    if (turn % 2 == 1) {
                        System.out.println("Team 1 wins!");
                        for (Player player : team1) {
                            player.incrementWins();
                        }
                        for (Player player : team2) {
                            player.incrementLosses();
                        }
                    }
                    else {
                        System.out.println("Team 2 wins!");
                        for (Player player : team2) {
                            player.incrementWins();
                        }
                        for (Player player : team1) {
                            player.incrementLosses();
                        }
                    }
                    break;
                }
                if (turn == size * size) {
                    System.out.println("Team 2 wins!");
                    for (Player player : team2) {
                        player.incrementWins();
                    }
                    for (Player player : team1) {
                        player.incrementLosses();
                    }
                    break;
                }
                turn++;
            }
            System.out.println("Do you want to play again? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.equals("N")) {
                continueGame = false;
                for (Player player : team1) {
                    System.out.println(player.getName() + " winrate: " +
                            player.getWinRate());
                }
                for (Player player : team2) {
                    System.out.println(player.getName() + " winrate: " +
                            player.getWinRate());
                }
            }
        }
    }
}
