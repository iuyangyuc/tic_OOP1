import java.util.*;

public class OtherGame implements Game{

    private Player player1;
    private Player player2;
    Team team1;
    Team team2;
    private GameBoard board;
    private int size;
    private int turn;

    private final char X = 'X';
    private final char O = 'O';

    public OtherGame(Player player1, Player player2, Team team1, Team team2, GameBoard board, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.team1 = team1;
        this.team2 = team2;
        this.board = board;
        this.size = size;
    }

    public OtherGame(Player player1, Player player2, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.size = size;
    }

    public OtherGame(Team team1, Team team2, int size) {
        this.team1 = team1;
        this.team2 = team2;
        this.size = size;
    }

    public void playGame_Single() {
        board = new GameBoard(size);
        boolean continueGame = true;
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
                if (board.checkWin()) {
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
            if (response.equals("N") || response.equals("n")) {
                continueGame = false;
                System.out.println(player1.getName() + " winrate: " +
                        player1.getWinRate());
                System.out.println(player2.getName() + " winrate: " +
                        player2.getWinRate());
            }
        }
    }

    public void playGame_Team() {
        boolean continueGame = true;
        board = new GameBoard(size);
        Player currentPlayer1 = team1.randomPlayer();
        Player currentPlayer2 = team2.randomPlayer();
        while (continueGame) {
            board.displayBoard();
            turn = 1;
            System.out.println("Team1's player: " + currentPlayer1.getName());
            System.out.println("Team2's player: " + currentPlayer2.getName());
            while (true) {
                if (turn % 2 == 1) {
                    currentPlayer1 = team1.switchPlayer(team1, currentPlayer1);
                    System.out.println(currentPlayer1.getName() + "'s turn");
                    board.fillUnit(currentPlayer1.getSymbol());
                }
                else {
                    currentPlayer2 = team2.switchPlayer(team2, currentPlayer2);
                    System.out.println(currentPlayer2.getName() + "'s turn");
                    board.fillUnit(currentPlayer2.getSymbol());
                }
                board.displayBoard();
                if (board.checkWin()) {
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
}
