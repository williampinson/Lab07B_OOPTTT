import java.awt.*;

public class Game {

    final int ROW = 3;
    final int COL = 3;
    TTTGUI frame;

    public String player = "X";
    final int MOVES_FOR_WIN = 5;
    final int MOVES_FOR_TIE = 7;
    int moveCnt = 0;
    boolean gameOver = false;
    String gameOverMessage;

    public Game() {
        showGUI();
    }
    public void newMove(Board board, int row, int col) {
        if (isValidMove(board,row,col)) {
            moveCnt++;
            if (isValidMove(board,row,col)) {
                board.getTile(row,col).setText(player);
                if (player.equals("X")) {
                    board.getTile(row, col).setForeground(new Color(23, 69, 102));
                }
                else if (player.equals("O")) {
                    board.getTile(row, col).setForeground(new Color(145, 46, 46));
                }
            }
            if (moveCnt >= MOVES_FOR_WIN) {
                if (isWin(board,player)) {
                    gameOver = true;
                    gameOverMessage = "Player " + player + " wins!";
                }
            }
            if (moveCnt >= MOVES_FOR_TIE) {
                if (isTie(board)) {
                    gameOver = true;
                    gameOverMessage = "It's a tie!";
                }
            }

            if (gameOver) {
                frame.continuePlaying(gameOverMessage);
            }
            else {
                setPlayer();
            }
        }
    }
    private boolean isValidMove(Board board, int row, int col) {
        return board.getTile(row,col).getText().equals(" ");
    }
    private void setPlayer() {
        if (player.equals("X")) {
            player = "O";
        }
        else {
            player = "X";
        }
    }
    private boolean isWin(Board board, String player) {

        boolean rowWin = false;
        boolean colWin = false;
        boolean diagWin = false;

        // Check for row win
        for (int row = 0; row < ROW; row++) {
            if (board.getTile(row,0).getText().equals(player) &&
                board.getTile(row,1).getText().equals(player) &&
                board.getTile(row,2).getText().equals(player)) {
                rowWin = true;
            }
        }

        // Check for col win
        for (int col = 0; col < COL; col++) {
            if (board.getTile(0,col).getText().equals(player) &&
                    board.getTile(1,col).getText().equals(player) &&
                    board.getTile(2,col).getText().equals(player)) {
                colWin = true;
            }
        }

        // Check for diagonal win
        if (board.getTile(0,0).getText().equals(player) &&
                board.getTile(1,1).getText().equals(player) &&
                board.getTile(2,2).getText().equals(player)) {
            diagWin = true;
        }
        else if (board.getTile(0,2).getText().equals(player) &&
                board.getTile(1,1).getText().equals(player) &&
                board.getTile(2,0).getText().equals(player)) {
            diagWin = true;
        }

        return rowWin || colWin || diagWin;
    }
    private boolean isTie(Board board) {
        boolean xFlag = false;
        boolean oFlag = false;

        // Check rows
        for (int row = 0; row < ROW; row++) {
            if (board.getTile(row,0).getText().equals("X") ||
                board.getTile(row,1).getText().equals("X") ||
                board.getTile(row,2).getText().equals("X")) {
                xFlag = true;
            }
            if (board.getTile(row,0).getText().equals("O") ||
                board.getTile(row,1).getText().equals("O") ||
                board.getTile(row,2).getText().equals("O")) {
                oFlag = true;
            }
            if (! (xFlag && oFlag)) {
                return false;
            }
            xFlag = false;
            oFlag = false;
        }

        // Check columns
        for (int col = 0; col < COL; col++) {
            if (board.getTile(0,col).getText().equals("X") ||
                board.getTile(1,col).getText().equals("X") ||
                board.getTile(2,col).getText().equals("X")) {
                xFlag = true;
            }
            if (board.getTile(0,col).getText().equals("O") ||
                board.getTile(1,col).getText().equals("O") ||
                board.getTile(2,col).getText().equals("O")) {
                oFlag = true;
            }
            if (! (xFlag && oFlag)) {
                return false;
            }
            xFlag = false;
            oFlag = false;
        }

        // Check diagonal \
        if (board.getTile(0,0).getText().equals("X") ||
            board.getTile(1,1).getText().equals("X") ||
            board.getTile(2,2).getText().equals("X")) {
            xFlag = true;
        }
        if (board.getTile(0,0).getText().equals("O") ||
            board.getTile(1,1).getText().equals("O") ||
            board.getTile(2,2).getText().equals("O")) {
            oFlag = true;
        }
        if (! (xFlag && oFlag)) {
            return false;
        }
        xFlag = false;
        oFlag = false;

        // Check diagonal /
        if (board.getTile(0,2).getText().equals("X") ||
            board.getTile(1,1).getText().equals("X") ||
            board.getTile(2,0).getText().equals("X")) {
            xFlag = true;
        }
        if (board.getTile(0,2).getText().equals("O") ||
            board.getTile(1,1).getText().equals("O") ||
            board.getTile(2,0).getText().equals("O")){
            oFlag = true;
        }
        if (! (xFlag && oFlag)) {
            return false;
        }

        return true;
    }
    public void playAgain(Board board) {
        gameOver = false;
        board.clearBoard();
        player = "X";
    }
    private void showGUI() {
        frame = new TTTGUI(this);
    }
}
