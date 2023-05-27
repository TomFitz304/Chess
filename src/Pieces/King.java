package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class King extends Piece{

    public King(int colorNum){
        super(colorNum, colorNum == 0 ? "♚" : "♔");
    }
    public ArrayList<Coordinate> possibleMoves(Board board){
        int y = coordinate.getY();
        int x = coordinate.getX();

        ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
        ret.add(new Coordinate(x,y+1));
        ret.add(new Coordinate(x,y-1));
        ret.add(new Coordinate(x+1,y+1));
        ret.add(new Coordinate(x+1,y-1));
        ret.add(new Coordinate(x-1,y+1));
        ret.add(new Coordinate(x-1,y-1));
        ret.add(new Coordinate(x+1,y));
        ret.add(new Coordinate(x-1,y));
        return possibleMoveArray(board,ret);

    }

}
