import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Board{" +
                "ROW=" + ROW +
                ", COL=" + COL +
                ", gameBoard=" + Arrays.toString(gameBoard) +
                ", parentPanel=" + parentPanel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return ROW == board.ROW && COL == board.COL && Objects.deepEquals(gameBoard, board.gameBoard) && Objects.equals(parentPanel, board.parentPanel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ROW, COL, Arrays.deepHashCode(gameBoard), parentPanel);
    }
}
