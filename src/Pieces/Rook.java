package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;
import Pieces.Piece;



import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(int colorNum){
        super(colorNum, "Pieces.Rook", colorNum == 0 ? "♜" : "♖");

    }
    public ArrayList<Coordinate> possibleMoves(Board board){

        int y = coordinate.getY() + increaseForOverSized;
        int x = coordinate.getX() + increaseForOverSized;

        ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
        for (int i = 0; i < 4; i++) {
            for (int distance = 1; distance < 8; distance++) {
                if(i==0) {
                    ret.add(new Coordinate(x,y+distance,true));
                    if (!board.getOverSizedBoardPiece(x,y+distance).isEmpty()) {
                        break;
                    }
                }
                if(i==1) {
                    ret.add(new Coordinate(x,y-distance,true));
                    if (!board.getOverSizedBoardPiece(x,y-distance).isEmpty()) {
                        break;
                    }
                }
                if(i==2) {
                    ret.add(new Coordinate(x + distance,y,true));
                    if (!board.getOverSizedBoardPiece(x+distance,y).isEmpty()) {
                        break;
                    }
                }
                if(i==3) {
                    ret.add(new Coordinate(x - distance,y,true));
                    if (!board.getOverSizedBoardPiece(x-distance,y).isEmpty()) {
                        break;
                    }
                }
            }
        }
        return possibleMoveArray(board, ret);

    }
}
