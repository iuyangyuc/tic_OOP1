import java.util.HashMap;
import java.util.Scanner;


/*
Game logic for Super Tic Tac Toe. It can be played with a single player or with teams.
 */
public class SuperTicTacToe implements TicTacToe {

    private Player player1;
    private Player player2;
    private Team team1;
    private Team team2;
    private SuperBoard superBoard;
    private int turn;

    private final char X = 'X';
    private final char O = 'O';

    public SuperTicTacToe(Player player1, Player player2, Team team1, Team team2, SuperBoard superBoard) {
        this.player1 = player1;
        this.player2 = player2;
        this.team1 = team1;
        this.team2 = team2;
        this.superBoard = superBoard;
    }

    public SuperTicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public SuperTicTacToe(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }


    public void playGame_Single() {
        boolean continueGame = true;
        SuperBoard superBoard = new SuperBoard();
        while (continueGame) {
            superBoard.displayBoard();
            turn = 1;
            while (true) {
                if (turn % 2 == 1) {
                    System.out.println(player1.getName() + "'s turn");
                    superBoard.fillUnit(player1.getSymbol());
                }
                else {
                    System.out.println(player2.getName() + "'s turn");
                    superBoard.fillUnit(player2.getSymbol());
                }
                superBoard.displayBoard();
                if (superBoard.checkWin()) {
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
                if (turn == 81) {
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
        SuperBoard board = new SuperBoard();
        while (continueGame) {
            board.displayBoard();
            turn = 1;
            while (true) {
                if (turn % 2 == 1) {
                    System.out.println(team1.getPlayer1().getName() + "'s turn");
                    superBoard.fillUnit(team1.getPlayer1().getSymbol());
                }
                else {
                    System.out.println(team1.getPlayer2().getName() + "'s turn");
                    superBoard.fillUnit(team1.getPlayer2().getSymbol());
                }
                board.displayBoard();
                if (board.checkWin()) {
                    if (turn % 2 == 1) {
                        System.out.println(team1.getPlayer1().getName() + " wins!");
                        team1.getPlayer1().incrementWins();
                        team1.getPlayer2().incrementWins();
                        team2.getPlayer1().incrementLosses();
                        team2.getPlayer2().incrementLosses();
                    }
                    else {
                        System.out.println(team1.getPlayer2().getName() + " wins!");
                        team1.getPlayer2().incrementWins();
                        team1.getPlayer1().incrementWins();
                        team2.getPlayer1().incrementLosses();
                        team2.getPlayer2().incrementLosses();
                    }
                    break;
                }
                if (turn == 81) {
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
                System.out.println(team1.getPlayer1().getName() + " winrate: " + team1.getPlayer1().getWinRate());
                System.out.println(team1.getPlayer2().getName() + " winrate: " + team1.getPlayer2().getWinRate());
                System.out.println(team2.getPlayer1().getName() + " winrate: " + team2.getPlayer1().getWinRate());
                System.out.println(team2.getPlayer2().getName() + " winrate: " + team2.getPlayer2().getWinRate());
            }
        }
    }
}
