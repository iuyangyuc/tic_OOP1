import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'X');
        Player player3 = new Player("Player3", 'O');
        Player player4 = new Player("Player4", 'O');
        List<Player> team1 = new ArrayList<>();
        List<Player> team2 = new ArrayList<>();
        team1.add(player1);
        team1.add(player2);
        team2.add(player3);
        team2.add(player4);
        System.out.println("Team 1: " + team1.get(0).getName() + " and " +
                team1.get(1).getName());
        System.out.println("Team 2: " + team2.get(0).getName() + " and " +
                team2.get(1).getName());
        TicTacToe game1 = new TicTacToe(team1, team2, 3);
        game1.playGame_Team();
    }
}