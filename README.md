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
/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54336:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/charsets.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/cldrdata.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/dnsns.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/jaccess.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/localedata.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/nashorn.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunec.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/ext/zipfs.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jce.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jfr.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/jsse.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/management-agent.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/resources.jar:/Users/yyc/Library/Java/JavaVirtualMachines/corretto-1.8.0_422/Contents/Home/jre/lib/rt.jar:/Users/yyc/Desktop/CS611 - OOP/assignment1/tic/out/production/tic Main

