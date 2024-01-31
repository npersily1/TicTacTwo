

import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    public static final int WINDOW_WIDTH = 800,
            WINDOW_HEIGHT = 600,
            Y_PADDING = WINDOW_HEIGHT / 10,
            X_PADDING = WINDOW_WIDTH / 10,
            SIDE_LENGTH = X_PADDING * 2 / 3;
    public static final String TITLE = "BOB";
    private Square[][] board;
    private Image x;
    private Image o;

    public TicTacToeViewer(Square[][] b) {
        setTitle(TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board = b;
        x = new ImageIcon("Resources/X.png").getImage();
        o = new ImageIcon("Resources/O.png").getImage();
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (Square[] sarray: board) {
            for (Square s : sarray) {
                s.draw(g, this);

            }


        }


    }
}

