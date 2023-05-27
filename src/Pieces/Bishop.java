package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(int colorNum){
        super(colorNum, colorNum == 0 ? "♝" : "♗");
    }
    public ArrayList<Coordinate> possibleMoves(Board board){

        int y = coordinate.getY() + increaseForOverSized;
        int x = coordinate.getX() + increaseForOverSized;

        ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
        for (int i = 0; i < 4; i++) {
            for (int distance = 1; distance < 8; distance++) {
                if(i==0) {
                    ret.add(new Coordinate(x+distance,y+distance));
                    if (!board.getPiece(x+distance,y+distance).isEmpty()) {
                        break;
                    }
                }
                if(i==1) {
                    ret.add(new Coordinate(x+distance,y-distance));
                    if (!board.getPiece(x  + distance,y  - distance).isEmpty()) {
                        break;
                    }
                }
                if(i==2) {
                    ret.add(new Coordinate(x-distance,y+distance));
                    if (!board.getPiece(x  - distance,y  + distance).isEmpty()) {
                        break;
                    }
                }
                if(i==3) {
                    ret.add(new Coordinate(x-distance,y-distance));
                    if (!board.getPiece(x - distance,y - distance).isEmpty()) {
                        break;
                    }
                }
            }
        }
        return possibleMoveArray(board, ret);

    }


}
