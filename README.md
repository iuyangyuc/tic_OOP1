# CS611-Assignment < 1 >
## < Tic Tac Toe and Other Variants >
---------------------------------------------------------------------------
- Name: Yuchen Yang
- Email: yangyuc@bu.edu
- Student ID: U33456991

## Files
---------------------------------------------------------------------------

<!--This section should be all of the source code files that have a .java extension. You should also include a brief description of what the class does.  
Main.java: Main method, run the game.-->
Order_Chaos.java: The class for the game Order and Chaos.  
OtherGame.java: Universal methods for n*n game.  
Player.java: The class contains the information of a player.  
Playerkey.java: Class for the key of player.  
TicTacToe.java: The class for the game TicTacToe.  
Unit.java: The class for the Board unit.  
Unitkey.java: Class for the key of unit.


## Notes
---------------------------------------------------------------------------
<!--Please explain the cool features of your program. Anything that you feel like you did a good job at or were creative about, explain it in bullets here. Additionally, any design decisions should be made here.-->
1. Can build a n*n game board, by using

```java
OtherGame game1 = new OtherGame(player1, player2, 3);
```
or a team game board, by using
```java
OtherGame game1 = new OtherGame(team1, team2, 3);
```

2. Team number switching is supported during team game. 'N' for not switching, or enter the name of the player to switch.
3. For future functions, like learning and intelligence, Unit data can be easily accessed and expended, since unit is a separate class and indexed by x and y keys. 
4. All other games on a n*n board hava the same condition of winning, which is to have n units in a row, column or diagonal, or draw when the board is full.


## How to compile and run
---------------------------------------------------------------------------
<!--Your directions on how to run the code. Make sure to be as thorough as possible!-->



## Input/Output Example
---------------------------------------------------------------------------
<!--Please give us a full execution of what we should see on the screen. Label each text with input and output. For example:-->

