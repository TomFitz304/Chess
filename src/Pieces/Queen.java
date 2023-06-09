package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(int colorNum){
        super(colorNum, colorNum == 0 ? "♛" : "♕");
    }
    public ArrayList<Coordinate> possibleMoves(Board board){

        int y = coordinate.getY() + increaseForOverSized;
        int x = coordinate.getX() + increaseForOverSized;

        ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x+j,y-j));

            if (!board.getPiece(x+j,y-j).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x+j,y));

            if (!board.getPiece(x+j,y).isEmpty()) {
                break;
            }

        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x+j,y+j));

            if (!board.getPiece(x+j,y+j).isEmpty()) {
                break;
            }

        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x-j,y-j));

            if (!board.getPiece(x-j,y-j).isEmpty()) {
                break;
            }

        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x-j,y));

            if (!board.getPiece(x-j,y).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x-j,y+j));

            if (!board.getPiece(x-j,y+j).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x,y-j));
            if (!board.getPiece(x,y-j).isEmpty()) {
                break;
            }
        }
        for (int j = 1; j < 8; j++) {
            ret.add(new Coordinate(x,y+j));

            if (!board.getPiece(x+j,y-j).isEmpty()) {
                break;
            }
        }
        return possibleMoveArray(board, ret);
    }
}
