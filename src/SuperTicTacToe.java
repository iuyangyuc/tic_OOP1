import java.util.HashMap;

public class SuperTicTacToe implements TicTacToe {

    private Player player1;
    private Player player2;
    private Team team1;
    private Team team2;
    private HashMap<Integer, BaseBoard> superBoard;
    private int turn;

    private final char X = 'X';
    private final char O = 'O';

    public SuperTicTacToe(Player player1, Player player2, Team team1, Team team2, HashMap<Integer, BaseBoard> superBoard) {
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

    }

    public void playGame_Team() {

    }
}
