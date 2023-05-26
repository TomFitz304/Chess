package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class Pawn extends Piece{

    public Pawn(int colorNum){
        super(colorNum, "Pieces.Pawn", colorNum == 0 ? "♟" : "♙");
    }
    public ArrayList<Coordinate> possibleMoves(Board board){

        int y = coordinate.getY() + increaseForOverSized;
        int x = coordinate.getX() + increaseForOverSized;

        ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
        if(color.equals("White")) {
            if(!board.getOverSizedBoardPiece(x,y-1).isEmpty()) {
                ret.add(new Coordinate(x,y-1,true));
            }
            if(!board.getOverSizedBoardPiece(x+1,y-1).isEmpty()) {
                ret.add(new Coordinate(x+1,y-1,true));
            }
            if(!board.getOverSizedBoardPiece(x-1,y-1).isEmpty()) {
               ret.add(new Coordinate(x-1,y-1,true));
            }
            if (moveNum == 0 && board.getOverSizedBoardPiece(x,y-2).isEmpty()) {
               ret.add(new Coordinate(x,y-2,true));
            }
        }
        else {
            if(!board.getOverSizedBoardPiece(x,y+1).isEmpty()) {
                ret.add(new Coordinate(x,y+1,true));
            }
            if(!board.getOverSizedBoardPiece(x+1,y+1).isEmpty()) {
                ret.add(new Coordinate(x+1,y+1,true));
            }
            if(!board.getOverSizedBoardPiece(x-1,y+1).isEmpty()) {
                ret.add(new Coordinate(x-1,y+1,true));
            }
            if (moveNum == 0 && board.getOverSizedBoardPiece(x,y+2).isEmpty()) {
                ret.add(new Coordinate(x,y+2,true));
            }
        }
        return possibleMoveArray(board,ret);

    }


}
