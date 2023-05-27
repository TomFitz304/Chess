package BoardDetails;

import Pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayBoard extends JPanel {
    // board size in pixels
    public static int BOARDWIDTH = 500;
    public static int BOARDHEIGHT = 500;

    private Coordinate coordinate;

    private boolean piecePicked;

    private Board board;

    public DisplayBoard(Board board) {

        setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
        setLayout(new GridLayout(Board.BOARD_ROWS, Board.BOARD_COLS));

        JFrame lifeFrame = new JFrame();
        lifeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lifeFrame.setContentPane(this);
        lifeFrame.pack();
        lifeFrame.setVisible(true);
        coordinate = new Coordinate(0,0);
        piecePicked = false;
        this.board = board;
    }

    public void display() {
        display(null);
    }

    public void display(ArrayList<Coordinate> inputPossibleMoves) {

        String currentColor = "White";

        this.removeAll();

        boolean threatened = false;

        for (int y = 0; y < Board.BOARD_COLS; y++) {
            for (int x = 0; x < Board.BOARD_ROWS; x++) {
                if (inputPossibleMoves != null) {
                    for (Coordinate inputPossibleMove : inputPossibleMoves) {
                        if (inputPossibleMove.getX() == x && inputPossibleMove.getY() == y) {
                            threatened = true;
                            break;
                        } else {
                            threatened = false;
                        }
                    }
                }

                Piece piece = board.getPiece(x, y);
                piece.setThreatened(threatened);
                piece.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Piece p = (Piece) e.getSource();
                        coordinate = p.getCoordinate();
                        piecePicked = true;
                    }
                });
                currentColor = currentColor.equals("White") ? "Black" : "White";
                add(piece);
            }
        }
        this.revalidate();
        this.repaint();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setPickedPiece(boolean b){
        piecePicked = b;
    }

    public boolean isPiecePicked() {
        return piecePicked;
    }
}

