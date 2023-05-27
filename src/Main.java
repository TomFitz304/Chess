import BoardDetails.Board;
import BoardDetails.Coordinate;
import BoardDetails.DisplayBoard;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Board board = new Board();
        DisplayBoard displayBoard = new DisplayBoard(board);

        ArrayList<Coordinate> possible;

        String notColor = "Black";

        while(true) {

            int xI;
            int yI;
            int xF;
            int yF;

            displayBoard.display();

            do {
                displayBoard.setPickedPiece(false);
                while (!displayBoard.isPiecePicked()){
                    System.out.print("");
                }
                xI = displayBoard.getCoordinate().getX();
                yI = displayBoard.getCoordinate().getY();
            } while(board.getPiece(xI,yI).isEmpty() || board.getPiece(xI,yI).getColor().equals(notColor));

            possible = board.getPiece(xI, yI).possibleMoves(board);

            for (Coordinate coordinate : possible) {
                System.out.println(coordinate);
            }

            displayBoard.display(possible);

            do {
                displayBoard.setPickedPiece(false);
                while (!displayBoard.isPiecePicked()) {
                    System.out.print("");
                }
                xF = displayBoard.getCoordinate().getX();
                yF = displayBoard.getCoordinate().getY();

            } while (!possible.contains(new Coordinate(xF, yF)));

            board.movePiece(xI, yI, xF, yF);
            notColor = notColor.equals("White") ? "Black" : "White";
        }
    }
}