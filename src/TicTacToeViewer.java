

import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    public static final int WINDOW_WIDTH = 800,
            WINDOW_HEIGHT = 600,
            Y_PADDING = 100,
            X_PADDING = 100,
            SIDE_LENGTH = 150,
            FONT_SIZE = 70;
                    //(WINDOW_HEIGHT - Y_PADDING * 2 )/ 3;
    public static final String TITLE = "BOB";

    private Image xImage;
    private Image oImage;
    private TicTacToe game;

    public TicTacToeViewer(TicTacToe t) {
        setTitle(TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game = t;
        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();
        setVisible(true);
    }

    public Image getXImage() {
        return xImage;
    }

    public Image getOImage() {
        return oImage;
    }
// hi
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (Square[] sarray: game.getBoard()) {
            for (Square s : sarray) {
                s.draw(g, this);
            }


        }
        drawNumbers(g);
        if(game.getGameOver()) {
            drawMessage(game.getWinner(),g);
        }
    }
    private void drawNumbers(Graphics g) {
        Font f = new Font("Sans Serif", Font.ITALIC, FONT_SIZE);
        g.setFont(f);
//
        int x = X_PADDING + SIDE_LENGTH / 2;
        int y = Y_PADDING + SIDE_LENGTH / 2 ;
        for (int i = 0; i < 3; i++) {
            String s = Integer.toString(i);
            g.drawString(s, X_PADDING / 3 , y);
            g.drawString(s, x, Y_PADDING - 10);
            y += SIDE_LENGTH;
            x+= SIDE_LENGTH;
        }

    }
    public void drawMessage(String s, Graphics g) {
        Font f = new Font("Sans Serif", Font.BOLD, FONT_SIZE / 2 );
        g.setFont(f);
        if(!s.equals("-")) {
            g.drawString(s + "wins", WINDOW_WIDTH / 2, WINDOW_HEIGHT - 20);
            return;
        }
        g.drawString("Tie", WINDOW_WIDTH / 2, WINDOW_HEIGHT - 20);

    }
}

