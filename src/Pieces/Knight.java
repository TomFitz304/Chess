package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(int colorNum){
        super(colorNum, colorNum == 0 ? "♞" : "♘");
    }
    public ArrayList<Coordinate> possibleMoves(Board board){

            int y = coordinate.getY();
            int x = coordinate.getX();

            ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
            ret.add(new Coordinate(x+2,y+1));
            ret.add(new Coordinate(x+2,y-1));
            ret.add(new Coordinate(x-2,y+1));
            ret.add(new Coordinate(x-2,y-1));
            ret.add(new Coordinate(x+1,y+2));
            ret.add(new Coordinate(x+1,y-2));
            ret.add(new Coordinate(x-1,y+2));
            ret.add(new Coordinate(x-1,y-2));
            return possibleMoveArray(board,ret);

        }


}
