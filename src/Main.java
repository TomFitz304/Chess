import BoardDetails.Board;
import BoardDetails.Coordinate;
import BoardDetails.PossibleMoveCheck;
import Pieces.Piece;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Board board = new Board();

        board.resetBoard();

        ArrayList<Coordinate> possible;

        boolean isPossible;
        String notColor = "Black";

        int xI;
        int yI;
        int xF;
        int yF;

        while(true){
            board.display();
            do {
                board.pickedFalse();
                while (!board.isPiecePicked()){
                    System.out.print("");
                }
                xI = board.getCoords().getX();
                yI = board.getCoords().getY();
            }while(board.getPiece(xI,yI).isEmpty() || board.getPiece(xI,yI).getColor().equals(notColor));
            possible = board.getPiece(xI, yI).possibleMoves(board);
            for (Coordinate coordinate : possible) {
                System.out.println(coordinate);
            }
            board.display(possible);
            do{
                board.pickedFalse();
                while (!board.isPiecePicked()){
                    System.out.print("");
                }
                xF = board.getCoords().getX();
                yF = board.getCoords().getY();
                isPossible = false;
                for (Coordinate coordinate : possible) {
                    if (coordinate.getX() == xF && coordinate.getY() == yF) {
                        isPossible = true;
                        break;
                    }
                }
            }while (!isPossible);
            board.movePiece(xI, yI, xF, yF);
            notColor = notColor.equals("White") ? "Black" : "White";
        }
    }
}