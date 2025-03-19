import javax.swing.*;

public class TTTTile extends JButton {
    int row, col;
    public TTTTile(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
