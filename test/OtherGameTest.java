import static org.junit.jupiter.api.Assertions.*;

class OtherGameTest {

    @org.junit.jupiter.api.Test
    void checkWin_col() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        OtherGame game = new OtherGame(player1, player2, 4);
        game.setupGame();
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(1, 0, 'O');
        game.modifyUnit(2, 0, 'X');
        game.modifyUnit(3, 0, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(0, 1, 'X');
        game.modifyUnit(1, 1, 'X');
        game.modifyUnit(2, 1, 'X');
        game.modifyUnit(3, 1, 'X');
        assertTrue(game.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkWin_row() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        OtherGame game = new OtherGame(player1, player2, 4);
        game.setupGame();
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(0, 1, 'O');
        game.modifyUnit(0, 2, 'X');
        game.modifyUnit(0, 3, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(1, 0, 'X');
        game.modifyUnit(1, 1, 'X');
        game.modifyUnit(1, 2, 'X');
        game.modifyUnit(1, 3, 'X');
        assertTrue(game.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkWin_diag1() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        OtherGame game = new OtherGame(player1, player2, 4);
        game.setupGame();
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(1, 1, 'O');
        game.modifyUnit(2, 2, 'X');
        game.modifyUnit(3, 3, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(0, 0, 'X');
        game.modifyUnit(1, 1, 'X');
        game.modifyUnit(2, 2, 'X');
        game.modifyUnit(3, 3, 'X');
        assertTrue(game.checkWin());
        game.displayBoard();
    }

    @org.junit.jupiter.api.Test
    void checkWin_diag2() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        OtherGame game = new OtherGame(player1, player2, 4);
        game.setupGame();
        game.modifyUnit(0, 3, 'X');
        game.modifyUnit(1, 2, 'O');
        game.modifyUnit(2, 1, 'X');
        game.modifyUnit(3, 0, 'X');
        assertFalse(game.checkWin());
        game.modifyUnit(0, 3, 'X');
        game.modifyUnit(1, 2, 'X');
        game.modifyUnit(2, 1, 'X');
        game.modifyUnit(3, 0, 'X');
        assertTrue(game.checkWin());
        game.displayBoard();
    }

    @org.junit.jupiter.api.Test
    void checkWin_draw() {
        Player player1 = new Player("A", 'X');
        Player player2 = new Player("B", 'O');
        OtherGame game = new OtherGame(player1, player2, 4);
        game.setupGame();
        game.modifyUnit(0, 0, 'O');
        game.modifyUnit(0, 1, 'O');
        game.modifyUnit(0, 2, 'X');
        game.modifyUnit(0, 3, 'X');
        game.modifyUnit(1, 0, 'O');
        game.modifyUnit(1, 1, 'X');
        game.modifyUnit(1, 2, 'O');
        game.modifyUnit(1, 3, 'X');
        game.modifyUnit(2, 0, 'X');
        game.modifyUnit(2, 1, 'O');
        game.modifyUnit(2, 2, 'X');
        game.modifyUnit(2, 3, 'O');
        game.modifyUnit(3, 0, 'O');
        game.modifyUnit(3, 1, 'X');
        game.modifyUnit(3, 2, 'O');
        game.modifyUnit(3, 3, 'X');
        game.displayBoard();
        assertFalse(game.checkWin());
    }
}