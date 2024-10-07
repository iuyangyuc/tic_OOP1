import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Team class to store, get and manipulate team information.
 */

public class Team {

    private Player player1;
    private Player player2;

    public Team(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public double getWinRate() {
        return (double) player1.getWins() / (player1.getWins() + player1.getLosses());
    }

    public void printWinRate() {
        System.out.println(player1.getName() + " winrate: " + getWinRate());
        System.out.println(player2.getName() + " winrate: " + getWinRate());
    }

    public void incrementWins() {
        player1.incrementWins();
        player2.incrementWins();
    }

    public void incrementLosses() {
        player1.incrementLosses();
        player2.incrementLosses();
    }

    public Player randomPlayer() {
        return Math.random() < 0.5 ? player1 : player2;
    }

    public Player switchPlayer(Team team, Player currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the player name to switch to, " + "or 'N' for no switch:");
        String input = scanner.next();
        if (input.equalsIgnoreCase("N")) {
            return currentPlayer;
        }
        for (Player player : Arrays.asList(team.getPlayer1(), team.getPlayer2())) {
            if (player.getName().equals(input)) {
                return player;
            }
        }
        System.out.println("Player not found. Try again.");
        return switchPlayer(team, currentPlayer);
    }
}
