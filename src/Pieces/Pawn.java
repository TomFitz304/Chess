package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(int colorNum){
        super(colorNum, colorNum == 0 ? "♟" : "♙");
    }
    public ArrayList<Coordinate> possibleMoves(Board board){

        int y = coordinate.getY();
        int x = coordinate.getX();

        ArrayList<Coordinate> moves = new ArrayList<>();
        if(color.equals("White")) {

            checkMoveTo(board, moves, x, y-1);
            checkAttackTo(board, moves, x+1, y-1);
            checkAttackTo(board, moves, x-1, y-1);

            if (moveNum == 0) {
                checkMoveTo(board, moves, x, y-2);
            }
        }
        else {

            checkMoveTo(board, moves, x, y+1);
            checkAttackTo(board, moves, x+1, y+1);
            checkAttackTo(board, moves, x-1, y+1);

            if (moveNum == 0) {
                checkMoveTo(board, moves, x, y+2);
            }
        }
        return moves;
    }

    private void checkMoveTo(Board board, List<Coordinate> moves, int x, int y) {
        if (board.getPiece(x, y).isEmpty()) {
            moves.add(new Coordinate(x, y));
        }
    }

    private void checkAttackTo(Board board, List<Coordinate> moves, int x, int y) {

        Piece piece = board.getPiece(x, y);

        if (piece.isEmpty() || !piece.isValid() || piece.getColor().equals(color)) {
            return;
        }

        moves.add(new Coordinate(x, y));
    }
}
