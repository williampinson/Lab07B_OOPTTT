import javax.swing.*;
import java.awt.*;

public class TTTGUI extends JFrame {

    final int ROW = 3;
    final int COL = 3;

    JPanel mainPanel, gamePanel, controlPanel;
    JButton quitBtn;
    Game game;
    Board board;


    public TTTGUI(Game game) {
        this.game = game;

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        createGamePanel();
        createControlPanel();

        setVisible(true);
    }
    private void createGamePanel() {
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        board = new Board(gamePanel);
        board.generateBoard();
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                int finalRow = row;
                int finalCol = col;
                board.getTile(row,col).addActionListener(e -> {
                    game.newMove(board, finalRow, finalCol);
                });
                gamePanel.add(board.getTile(row, col));
            }
        }


        mainPanel.add(gamePanel);
    }
    private void createControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,1));
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(this,"Are you sure you want to quit?","Quit",JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        controlPanel.add(quitBtn);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
    }
    public void continuePlaying(String message) {
        JButton yesButton = new JButton("Play Again");
        JButton noButton = new JButton("Quit");
        yesButton.addActionListener(e -> {
            game.playAgain(board);
            Window window = SwingUtilities.getWindowAncestor(yesButton);
            if (window != null) {
                window.dispose();
            }
        });
        noButton.addActionListener(e -> {
            System.exit(0);
        });
        Object[] options = {yesButton, noButton};
        JOptionPane.showOptionDialog(this, message, "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
