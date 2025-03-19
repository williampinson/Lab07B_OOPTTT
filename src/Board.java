import javax.swing.*;
import java.awt.*;

public class Board {

    final int ROW = 3;
    final int COL = 3;
    TTTTile[][] gameBoard = new TTTTile[ROW][COL];
    JPanel parentPanel;

    public Board(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    public void generateBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                gameBoard[row][col] = new TTTTile(row,col);
                gameBoard[row][col].setText(" ");
                gameBoard[row][col].setPreferredSize(new Dimension(150, 150));
                gameBoard[row][col].setText(" ");
                gameBoard[row][col].setFont(new Font("Arial", Font.BOLD, 120));
            }
        }
    }
    public TTTTile getTile(int row, int col) {
        return gameBoard[row][col];
    }
    public void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                gameBoard[row][col].setText(" ");
            }
        }
    }
}
