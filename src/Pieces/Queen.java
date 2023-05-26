package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(int colorNum){
        super(colorNum, "Pieces.Queen", colorNum == 0 ? "♛" : "♕");
    }
    public ArrayList<Coordinate> possibleMoves(Board board){

        int y = coordinate.getY() + increaseForOverSized;
        int x = coordinate.getX() + increaseForOverSized;

        ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x+j,y-j,true));

            if (!board.getOverSizedBoardPiece(x+j,y-j).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x+j,y,true));

            if (!board.getOverSizedBoardPiece(x+j,y).isEmpty()) {
                break;
            }

        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x+j,y+j,true));

            if (!board.getOverSizedBoardPiece(x+j,y+j).isEmpty()) {
                break;
            }

        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x-j,y-j,true));

            if (!board.getOverSizedBoardPiece(x-j,y-j).isEmpty()) {
                break;
            }

        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x-j,y,true));

            if (!board.getOverSizedBoardPiece(x-j,y).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x-j,y+j,true));

            if (!board.getOverSizedBoardPiece(x-j,y+j).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x,y-j,true));
            if (!board.getOverSizedBoardPiece(x,y-j).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x,y+j,true));

            if (!board.getOverSizedBoardPiece(x+j,y-j).isEmpty()) {
                break;
            }
        }
        return possibleMoveArray(board, ret);
    }
}
