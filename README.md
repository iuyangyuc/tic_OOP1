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
/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54336:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/charsets.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/cldrdata.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/dnsns.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/jaccess.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/localedata.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/nashorn.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunec.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/zipfs.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jce.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jfr.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jsse.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/management-agent.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/resources.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/rt.jar:/Users/yyc/Desktop/CS611 - OOP/assignment1/tic/out/production/tic Main
Which game would you like to play?  
1. Tic Tac Toe  
2. Order and Chaos  
3. Other Game  
   1  
   Do you want to play with a team? (Y/N)  
   n  
   Enter the player1 name:  
   a  
   Enter the player2 name:  
   b  
   |   ||   ||   |  
   |   ||   ||   |  
   |   ||   ||   |  
   a's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 0  
   | X ||   ||   |  
   |   ||   ||   |  
   |   ||   ||   |  
   b's turn  
   Enter the row and column number (0-2) separated by a space:  
   1 0  
   | X ||   ||   |  
   | O ||   ||   |  
   |   ||   ||   |  
   a's turn  
   Enter the row and column number (0-2) separated by a space:  
   1 1  
   | X ||   ||   |  
   | O || X ||   |  
   |   ||   ||   |  
   b's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 0  
   | X ||   ||   |  
   | O || X ||   |  
   | O ||   ||   |  
   a's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 2  
   | X ||   ||   |  
   | O || X ||   |  
   | O ||   || X |  
   a wins!  
   Do you want to play again? (Y/N)  
   n  
   a winrate: 1.0  
   b winrate: 0.0  
   Do you want to play again? (Y/N)  
   y  
   Which game would you like to play?  
1. Tic Tac Toe  
2. Order and Chaos  
3. Other Game  
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
   N  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 0  
   | X ||   ||   |  
   |   ||   ||   |  
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   dd's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 0  
   This unit is already filled. Try again.  
   Enter the row and column number (0-2) separated by a space:  
   20 20  
   Invalid row and column number. Try again.  
   Enter the row and column number (0-2) separated by a space:  
   1 0  
   | X ||   ||   |  
   | O ||   ||   |  
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   1 1  
   | X ||   ||   |  
   | O || X ||   |   
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   dd's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 0  
   | X ||   ||   |  
   | O || X ||   |  
   | O ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 1  
   | X || X ||   |  
   | O || X ||   |  
   | O ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   dd's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 2  
   | X || X ||   |  
   | O || X ||   |  
   | O ||   || O |  
   Enter the player name to switch to, or 'N' for no switch:  
   2 1  
   Player not found. Try again.  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:   
   2 1  
   | X || X ||   |  
   | O || X ||   |  
   | O || X || O |  
   Team 1 wins!  
   Do you want to play again? (Y/N)  
   n  
   aa winrate: 1.0  
   bb winrate: 1.0  
   cc winrate: 0.0  
   dd winrate: 0.0  
   Do you want to play again? (Y/N)  
   y  
   Which game would you like to play?   
1. Tic Tac Toe  
2. Order and Chaos  
3. Other Game  
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
   N  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 0  
   | X ||   ||   |  
   |   ||   ||   |  
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   cc  
   cc's turn  
   Enter the row and column number (0-2) separated by a space:  
   1 0  
   | X ||   ||   |  
   | O ||   ||   |  
   |   ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 0  
   | X ||   ||   |   
   | O ||   ||   |   
   | X ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   dd  
   dd's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 1  
   | X || O ||   |  
   | O ||   ||   |  
   | X ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   N  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   1 1  
   | X || O ||   |  
   | O || X ||   |  
   | X ||   ||   |  
   Enter the player name to switch to, or 'N' for no switch   
   n  
   dd's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 1  
   | X || O ||   |  
   | O || X ||   |    
   | X || O ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   n  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   1 2  
   | X || O ||   |  
   | O || X || X |  
   | X || O ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   n  
   dd's turn  
   Enter the row and column number (0-2) separated by a space:  
   0 2  
   | X || O || O |  
   | O || X || X |  
   | X || O ||   |  
   Enter the player name to switch to, or 'N' for no switch:  
   n  
   aa's turn  
   Enter the row and column number (0-2) separated by a space:  
   2 2  
   | X || O || O |  
   | O || X || X |  
   | X || O || X |  
   Team 1 wins!  
   Do you want to play again? (Y/N)  
   n  
   aa winrate: 1.0  
   bb winrate: 1.0  
   cc winrate: 0.0  
   dd winrate: 0.0  
   Do you want to play again? (Y/N)  
   n  
