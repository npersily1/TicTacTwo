import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 * <p>
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     *
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Checks if the square has the BLANK marker
     *
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, TicTacToeViewer window) {
        int y = window.X_PADDING + row * window.SIDE_LENGTH;
        int x = window.Y_PADDING + col * window.SIDE_LENGTH;

        if (this.isWinningSquare) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, window.SIDE_LENGTH, window.SIDE_LENGTH);
        } else {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, window.SIDE_LENGTH, window.SIDE_LENGTH);
        }
        if (!marker.equals("-")) {
            if (marker.equals("X")) {
                g.drawImage(window.getXImage(), x, y, window.SIDE_LENGTH, window.SIDE_LENGTH, window);
            } else {
                g.drawImage(window.getOImage(), x, y, window.SIDE_LENGTH, window.SIDE_LENGTH, window);
            }
        }
    }
}
