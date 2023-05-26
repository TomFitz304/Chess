package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;

public class EmptySquare extends Piece {

        public EmptySquare(){
            super(0, "Empty", " ");
            color = "NoColor";
        }
        public ArrayList<Coordinate> possibleMoves(Board board){
            return new ArrayList<Coordinate>();

        }


    }
