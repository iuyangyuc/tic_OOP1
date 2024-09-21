import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class Order_ChaosTest {

    @Test
    void checkWin_col() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        Order_Chaos game = new Order_Chaos(player1, player2, 6);
        game.setupGame();
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(1, 0, 'O');
        game.modifyUnit(2, 0, 'X');
        game.modifyUnit(3, 0, 'X');
        game.modifyUnit(4, 0, 'X');
        game.modifyUnit(5, 0, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(0, 1, 'X');
        game.modifyUnit(1, 1, 'X');
        game.modifyUnit(2, 1, 'X');
        game.modifyUnit(3, 1, 'X');
        game.modifyUnit(4, 1, 'X');
        game.modifyUnit(5, 1, 'X');
        assertTrue(game.checkWin());
        game.displayBoard();
    }

    @Test
    void checkWin_row() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        Order_Chaos game = new Order_Chaos(player1, player2, 6);
        game.setupGame();
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(0, 1, 'O');
        game.modifyUnit(0, 2, 'X');
        game.modifyUnit(0, 3, 'X');
        game.modifyUnit(0, 4, 'X');
        game.modifyUnit(0, 5, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(1, 0, 'X');
        game.modifyUnit(1, 1, 'X');
        game.modifyUnit(1, 2, 'X');
        game.modifyUnit(1, 3, 'X');
        game.modifyUnit(1, 4, 'X');
        game.modifyUnit(1, 5, 'X');
        assertTrue(game.checkWin());
        game.displayBoard();
    }

    @Test
    void checkWin_diag1() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        Order_Chaos game = new Order_Chaos(player1, player2, 6);
        game.setupGame();
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(1, 1, 'O');
        game.modifyUnit(2, 2, 'X');
        game.modifyUnit(3, 3, 'X');
        game.modifyUnit(4, 4, 'X');
        game.modifyUnit(5, 5, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(1, 1, 'X');
        game.modifyUnit(2, 2, 'X');
        game.modifyUnit(3, 3, 'X');
        game.modifyUnit(4, 4, 'X');
        game.modifyUnit(5, 5, 'X');
        assertTrue(game.checkWin());
        game.displayBoard();
    }

    @Test
    void checkWin_diag2() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        Order_Chaos game = new Order_Chaos(player1, player2, 6);
        game.setupGame();
        game.modifyUnit(0, 5, 'X');
        game.modifyUnit(1, 4, 'O');
        game.modifyUnit(2, 3, 'X');
        game.modifyUnit(3, 2, 'X');
        game.modifyUnit(4, 1, 'X');
        game.modifyUnit(5, 0, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(0, 5, 'X');
        game.modifyUnit(1, 4, 'X');
        game.modifyUnit(2, 3, 'X');
        game.modifyUnit(3, 2, 'X');
        game.modifyUnit(4, 1, 'X');
        game.modifyUnit(5, 0, 'X');
        assertTrue(game.checkWin());
        game.displayBoard();
    }

    @Test
    void checkWin_diag3() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        Order_Chaos game = new Order_Chaos(player1, player2, 6);
        game.setupGame();
        game.modifyUnit(0, 1, 'X');
        game.modifyUnit(1, 2, 'O');
        game.modifyUnit(2, 3, 'X');
        game.modifyUnit(3, 4, 'X');
        game.modifyUnit(4, 5, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(1, 2, 'X');
        game.displayBoard();
        assertTrue(game.checkWin());
    }

    @Test
    void checkWin_dig4(){
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        Order_Chaos game = new Order_Chaos(player1, player2, 6);
        game.setupGame();
        game.modifyUnit(0, 4, 'X');
        game.modifyUnit(1, 3, 'O');
        game.modifyUnit(2, 2, 'X');
        game.modifyUnit(3, 1, 'X');
        game.modifyUnit(4, 0, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(0, 4, 'X');
        game.modifyUnit(1, 3, 'X');
        game.modifyUnit(2, 2, 'X');
        game.modifyUnit(3, 1, 'X');
        game.modifyUnit(4, 0, 'X');
        assertTrue(game.checkWin());
        game.displayBoard();
    }

    @Test
    void checkDrawTest() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        Order_Chaos game = new Order_Chaos(player1, player2, 6);
        game.setupGame();

        char[][] boardPattern = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'X', 'X'}
        };

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                game.modifyUnit(i, j, boardPattern[i][j]);
            }
        }

        assertFalse(game.checkWin());

    }
}