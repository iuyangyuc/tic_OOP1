import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean continuePlaying = true;
        boolean team = false;
        int size = 0;
        Scanner scanner = new Scanner(System.in);

        while(continuePlaying) {
            System.out.println("Which game would you like to play?");
            System.out.println("1. Tic Tac Toe");
            System.out.println("2. Order and Chaos");
            System.out.println("3. Other Game");
            int gameChoice = scanner.nextInt();

            if(gameChoice < 1 || gameChoice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            if (gameChoice == 3) {
                System.out.println("Enter the size of the board: ");
                size = scanner.nextInt();
            }

            System.out.println("Do you want to play with a team? (Y/N)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("Y")) {
                team = true;
            }

            if (!team) {
                System.out.println("Enter the player1 name: ");
                String player1Name = scanner.next();
                Player player1 = new Player(player1Name, 'X');
                System.out.println("Enter the player2 name: ");
                String player2Name = scanner.next();
                Player player2 = new Player(player2Name, 'O');
                switch (gameChoice) {
                    case 1:
                        TicTacToe ticTacToe = new TicTacToe(player1, player2, 3);
                        ticTacToe.playGame_Single();
                        break;
                    case 2:
                        Order_Chaos orderChaos = new Order_Chaos(player1, player2, 6);
                        orderChaos.playGame_Single();
                        break;
                    case 3:
                        OtherGame otherGame = new OtherGame(player1, player2, size);
                        otherGame.playGame_Single();
                        break;
                }
            }
            else {
                System.out.println("Enter the name of the first player in team1: ");
                String player1Name = scanner.next();
                Player player1 = new Player(player1Name, 'X');
                System.out.println("Enter the name of the second player in team1: ");
                String player2Name = scanner.next();
                Player player2 = new Player(player2Name, 'X');
                System.out.println("Enter the name of the first player in team2: ");
                String player3Name = scanner.next();
                Player player3 = new Player(player3Name, 'O');
                System.out.println("Enter the name of the second player in team2: ");
                String player4Name = scanner.next();
                Player player4 = new Player(player4Name, 'O');
                List<Player> team1 = new ArrayList<>();
                team1.add(player1);
                team1.add(player2);
                List<Player> team2 = new ArrayList<>();
                team2.add(player3);
                team2.add(player4);
                switch (gameChoice) {
                    case 1:
                        TicTacToe ticTacToe = new TicTacToe(team1, team2, 3);
                        ticTacToe.playGame_Team();
                        break;
                    case 2:
                        Order_Chaos orderChaos = new Order_Chaos(team1, team2, 6);
                        orderChaos.playGame_Team();
                        break;
                    case 3:
                        OtherGame otherGame = new OtherGame(team1, team2, size);
                        otherGame.playGame_Team();
                        break;
                }
            }

            System.out.println("Do you want to play again? (Y/N)");
            response = scanner.next();
            if (response.equalsIgnoreCase("N")) {
                continuePlaying = false;
            }
        }
    }
}