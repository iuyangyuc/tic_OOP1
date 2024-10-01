import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {

    public void start() {

        boolean continuePlaying = true;
        boolean team = false;
        int size = 0;
        Scanner scanner = new Scanner(System.in);

        while(continuePlaying) {
            System.out.println("Which game would you like to play?");
            System.out.println("1. Tic Tac Toe");
            System.out.println("2. Order and Chaos");
            System.out.println("3. Other Game");
            int gameChoice = takeValidInput();

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
                Team team1 = new Team(player1, player2);
                Team team2 = new Team(player3, player4);
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

    public int takeValidInput() {
        Scanner scanner = new Scanner(System.in);
        int gameChoice = 0;
        while (true) {
            String input = scanner.next();
            try {
                gameChoice = Integer.parseInt(input);
                if (gameChoice >= 1 && gameChoice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
        return gameChoice;
    }
}
