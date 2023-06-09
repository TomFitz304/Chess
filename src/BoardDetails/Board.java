package BoardDetails;

import Pieces.*;

public class Board {

    public static final int BOARD_ROWS = 8;
    public static final int BOARD_COLS = 8;

    private final Piece[][] board = new Piece[BOARD_ROWS][BOARD_COLS];

    public Board() {
        resetBoard();
    }

    private void resetBoard() {
        for (int y = 0; y < Board.BOARD_ROWS; y++) {
            int colorNum = y < 2 ? 0 : 1;

            if (y == 1 || y == 6) {
                for (int x = 0; x < BOARD_COLS; x++) {
                    assignStartPos(new Pawn(colorNum), x, y);
                }
            } else if (y == 0 || y == 7) {
                assignStartPos(new Rook(colorNum), 0, y);
                assignStartPos(new Rook(colorNum), 7, y);
                assignStartPos(new Knight(colorNum), 1, y);
                assignStartPos(new Knight(colorNum), 6, y);
                assignStartPos(new Bishop(colorNum), 2, y);
                assignStartPos(new Bishop(colorNum), 5, y);
                assignStartPos(new Queen(colorNum), 3, y);
                assignStartPos(new King(colorNum), 4, y);
            } else {
                for (int x = 0; x < BOARD_COLS; x++) {
                    assignStartPos(new EmptySquare(), x, y);
                }
            }

        }
    }

    private void assignStartPos(Piece piece, int x, int y) {
        board[x][y] = piece;
        piece.updatePos(x, y);
    }

    public void movePiece(int xInitial, int yInitial, int xFinal, int yFinal) {
        // The piece at the starting position on the input board will go to the place of the next available square
        // setting it to emptySquare.
        board[xFinal][yFinal] = board[xInitial][yInitial];
        board[xInitial][yInitial] = new EmptySquare();
        board[xInitial][yInitial].updatePos(xInitial,yInitial);
        board[xFinal][yFinal].updatePos(xFinal, yFinal);
        board[xFinal][yFinal].incrementMoveNum();
    }

    public Piece getPiece(int x, int y) {
        if (x >= BOARD_COLS || y >= BOARD_ROWS || x < 0 || y < 0) {
            return new InvalidSquare();
        }
        return board[x][y];
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

