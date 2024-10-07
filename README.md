# CS611-Assignment < 1 >
## < Tic Tac Toe and Other Variants >
---------------------------------------------------------------------------
- Name: Yuchen Yang
- Email: yangyuc@bu.edu
- Student ID: U33456991

## Files
---------------------------------------------------------------------------

<!--This section should be all of the source code files that have a .java extension. You should also include a brief description of what the class does.  -->
BaseBoard.java: The base class for all boards, which contains the basic functions of a board, like checking if a unit is filled, filling a unit, and checking if the board is full.  
Board.java: The interface for all boards, which contains the basic functions of a board.
Order_Chaos.java: The class for the Order and Chaos game, which is a 6*6 game board.  
PlayerKey.java: The method to get the player.  
SuperBoard.java: The board for super tic tac toe, which is a 3 * 3 game board.  
Team.java: The class for a team, which contains two players.  
Unit.java: The class for a unit in the board.  
BaseTicTacToe.java: Game class for Tic Tac Toe.  
Main.java: The main class for the program.  
Play.java: The interface for all games.  
Player.java: The class for a player.  
SuperTicTacToe.java: game class for super tic tac toe.  
TicTacToe.java: The interface for all tic tac toe like games.
UnitKey.java: The method to get the unit.


## Notes
---------------------------------------------------------------------------
<!--Please explain the cool features of your program. Anything that you feel like you did a good job at or were creative about, explain it in bullets here. Additionally, any design decisions should be made here.-->
1. Can build a n*n game subboard, by using

```java
OtherGame game1 = new OtherGame(player1, player2, 3);
```
or a team game subboard, by using
```java
OtherGame game1 = new OtherGame(team1, team2, 3);
```

2. Team number switching is supported during team game. 'N' for not switching, or enter the name of the player to switch.
3. For future functions, like learning and intelligence, Unit data can be easily accessed and expended, since unit is a separate class and indexed by x and y keys. 
4. All other games on a n*n subboard hava the same condition of winning, which is to have n units in a row, column or diagonal, or draw when the subboard is full.


## How to compile and run
---------------------------------------------------------------------------
<!--Your directions on how to run the code. Make sure to be as thorough as possible!-->
To compile the code:
```bash
javac Main.java
```
To run the code:
```bash
java Main
```


## Input/Output Example
---------------------------------------------------------------------------
<!--Please give us a full execution of what we should see on the screen. Label each text with input and output. For example:-->
Which game would you like to play?  
1. Tic Tac Toe  
2. Order and Chaos  
3. Super Tic Tac Toe  
   1  
   Do you want to play with a team? (Y/N)  
   y  
   Enter the name of the first player in team1:  
   aa  
   Enter the name of the second player in team1:  
   bb  
   Enter the name of the first player in team2:  
   cc  
   Enter the name of the second player in team2:  
   dd  
   |   ||   ||   |  
   |   ||   ||   |  
   |   ||   ||   |  
   Team1's player: aa  
   Team2's player: dd  
   Enter the player name to switch to, or 'N' for no switch:  
   n  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 0  
   | X ||   ||   |  
   |   ||   ||   |  
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   n  
   dd's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 0  
   This unit is already filled. Try again.  
   Enter the row and column number (0-2) separated by a space:  
   3 3  
   Invalid row and column number. Try again.  
   Enter the row and column number (0-2) separated by a space:  
   1 0  
   | X ||   ||   |  
   | O ||   ||   |  
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   n  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 1  
   | X || X ||   |  
   | O ||   ||   |  
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   cc  
   cc's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 0  
   | X || X ||   |  
   | O ||   ||   |  
   | O ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   hh  
   Player not found. Try again.  
   Enter the player name to switch to, or 'N' for no switch:  
   n  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 2  
   | X || X || X |  
   | O ||   ||   |  
   | O ||   ||   |  
   Team 1 wins!  
   Do you want to play again? (Y/N)  
   n  
   aa winrate: 1.0  
   bb winrate: 1.0  
   cc winrate: 0.0  
   dd winrate: 0.0  
   Do you want to play again? (Y/N)  
   n  

