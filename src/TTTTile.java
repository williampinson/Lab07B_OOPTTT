import javax.swing.*;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "TTTTile{" +
                "row=" + row +
                ", col=" + col +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TTTTile tttTile = (TTTTile) o;
        return row == tttTile.row && col == tttTile.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
