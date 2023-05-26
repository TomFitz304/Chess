package BoardDetails;

import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel {

    Piece[][] board = new Piece[8][8];
    Piece[][] overSizedBoard = new Piece[24][24];

    public static int BOARDWIDTH = 500;
    public static int BOARDHEIGHT = 500;

    private final int myRows = 8;
    private final int myCols = 8;

    private GridLayout gridLayout;

    private Coordinate coordinate;

    private boolean piecePicked;

    public Board() {
        setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
        setLayout(new GridLayout(myRows, myCols));

        for (int r = 1; r <= myRows; r++)
            for (int c = 1; c <= myCols; c++)
                add(new JButton());

        gridLayout = new GridLayout(myRows, myCols);
        JFrame lifeFrame = new JFrame();
        lifeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lifeFrame.setContentPane(this);
        lifeFrame.pack();
        lifeFrame.setVisible(true);
        piecePicked = false;
    }


    public void resetBoard() {
        for (int y = 0; y < 8; y += 7) {
            int colorNum = y == 0 ? 0 : 1;
            assignStartPos(new Rook(colorNum), 0, y);
            assignStartPos(new Rook(colorNum), 7, y);
            assignStartPos(new Knight(colorNum), 1, y);
            assignStartPos(new Knight(colorNum), 6, y);
            assignStartPos(new Bishop(colorNum), 2, y);
            assignStartPos(new Bishop(colorNum), 5, y);
            assignStartPos(new Queen(colorNum), 3, y);
            assignStartPos(new King(colorNum), 4, y);
            for (int j = 0; j < 8; j++) {
                assignStartPos(new Pawn(colorNum), j , y == 0 ? 1 : 6);
            }
        }
        for (int y = 2; y < 6; y++) {
            for (int x = 0; x < 8; x++) {
                assignStartPos(new EmptySquare(), x, y);
            }
        }
        resetOverSizedBoard();
    }
    private void resetOverSizedBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                overSizedBoard[i + 8][j + 8] = board[i][j];
            }
        }
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                if (overSizedBoard[i][j] == null) {
                    overSizedBoard[i][j] = new EmptySquare();
                }
            }
        }
    }

    private void assignStartPos(Piece piece, int x, int y) {
        board[x][y] = piece;
        piece.updatePos(x, y);
    }

    public void movePiece(int xInitial, int yInitial, int xFinal, int yFinal) {
//        The piece at the starting position on the input board will go to the place of the next available square
//        setting it to null.
        board[yFinal][xFinal] = board[yInitial][xInitial];
        board[yInitial][xInitial] = new EmptySquare();
        board[yFinal][xFinal].updatePos(xFinal, yFinal);
        board[yFinal][xFinal].incrementMoveNum();
    }
    public void display() {
        display(null);
    }

    public void display(ArrayList<Coordinate> inputPossibleMoves) {

        setLayout(gridLayout);

        this.removeAll();

        boolean threatened = false;

        JButton jButton;

        for (int y = myCols-1; y >= 0; y--) {
            for (int x = 0; x < myRows; x++) {
                if (inputPossibleMoves != null) {
                    for (int k = 0; k < inputPossibleMoves.size(); k++) {
                        if (inputPossibleMoves.get(k).getX() == x && inputPossibleMoves.get(k).getY() == y) {
                            threatened = true;
                            break;
                        } else {
                            threatened = false;
                        }
                    }
                }
                Font font = new Font(Font.DIALOG_INPUT, Font.PLAIN, 80);
                if(board != null) {
                    jButton = board[x][y];
                    board[x][y].setThreatened(threatened);
                }
                else jButton = new JButton();



                jButton.setFont(font);
                jButton.setBackground(threatened ? Color.yellow : Color.white);
                JButton finalJButton = jButton;
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Piece p = (Piece) e.getSource();
                        coordinate = p.getCoordinate();
                        piecePicked = true;
                    }

                });
                add(jButton);
            }
        }
        this.revalidate();
        this.repaint();

    }

    public Piece getPiece(int x, int y){
        return board[x][y];
    }

    public Coordinate getCoords() {
        return coordinate;
    }

    public void pickedFalse(){
        piecePicked = false;
    }

    public boolean isPiecePicked() {
        return piecePicked;
    }
    public Piece[][] getOverSizedBoard(){
        resetOverSizedBoard();
        return overSizedBoard;
    }
    public Piece getOverSizedBoardPiece(int x, int y){
        return overSizedBoard[x][y];
    }

//    private void castle(Piece [][] inputBoard, int kingPosX, int kingPosY, int rookPosX, int rookPosY){
//        if(kingPosX == 3 && kingPosY == 0){
//            if(rookPosX == 0 && rookPosY == 0){
//                if(BoardDetails.PossibleMoveCheck.canCastleKingSide(inputBoard) == true) {
//
//                    inputBoard[1][0] = inputBoard[3][0];
//                    inputBoard[2][0] = inputBoard[0][0];
//                    inputBoard[3][0] = null;
//                    inputBoard[0][0] = null;
//                }
//                if(BoardDetails.PossibleMoveCheck.canCastleQueenSide(inputBoard) == true) {
//
//                    inputBoard[4][0] = inputBoard[3][0];
//                    inputBoard[5][0] = inputBoard[7][0];
//                    inputBoard[3][0] = null;
//                    inputBoard[7][0] = null;
//                }
//            }
//        }
//
//        if(kingPosX == 3 && kingPosY == 7){
//        if(rookPosX == 0 && rookPosY == 7){
//            if(BoardDetails.PossibleMoveCheck.canCastleKingSide(inputBoard) == true) {
//
//                inputBoard[1][7] = inputBoard[3][7];
//                inputBoard[2][7] = inputBoard[0][7];
//                inputBoard[3][7] = null;
//                inputBoard[0][7] = null;
//            }
//            if(BoardDetails.PossibleMoveCheck.canCastleQueenSide(inputBoard) == true) {
//
//                inputBoard[4][7] = inputBoard[3][7];
//                inputBoard[5][7] = inputBoard[7][7];
//                inputBoard[3][7] = null;
//                inputBoard[7][7] = null;
//            }
//        }
//    }
//}
}

