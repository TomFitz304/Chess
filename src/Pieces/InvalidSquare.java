package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class InvalidSquare extends Piece {

    public InvalidSquare() {
        super(0, " ");
        color = "NoColor";
    }

    @Override
    public ArrayList<Coordinate> possibleMoves(Board board) {
        return null;
    }

    public boolean isValid() {
        return false;
    }
}
