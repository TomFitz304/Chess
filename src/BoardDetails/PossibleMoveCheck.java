package BoardDetails;

import Pieces.Piece;

import java.util.ArrayList;

public class PossibleMoveCheck {

    public PossibleMoveCheck() {
    }

    public ArrayList<Coordinate> possibleMoveArray(int x, int y, Board inputBoard, ArrayList<Coordinate> coordinates) {

        ArrayList<Coordinate> ret2 = new ArrayList<Coordinate>();
        String color = inputBoard.getPiece(x,y).getColor();

        for (Coordinate coordinate : coordinates) {
            if (coordinate.getX() >= 0 && coordinate.getX() <= 7 && coordinate.getY() >= 0 && coordinate.getY() <= 7) {
                Piece temp = inputBoard.getPiece(coordinate.getX(),coordinate.getY());
                if (!(temp != null && (temp.getColor().equals(color)))) {
                    ret2.add(coordinate);
                }
            }
        }



//        ArrayList<Integer>[] inputArray = inputBoard[y][x].possibleMoves(x, y, inputBoard);
//        String color = inputBoard[y][x].getColor();
//        ArrayList<Integer> [] ret = new ArrayList[2];
//        ret[0] = new ArrayList<Integer>();
//        ret[1] = new ArrayList<Integer>();
//        for (int i = 0; i < inputArray[0].size(); i++) {
//            if (inputArray[0].get(i) >= 0 && inputArray[0].get(i) <= 7 && inputArray[1].get(i) >= 0 && inputArray[1].get(i) <= 7) {
//                Piece temp = inputBoard[inputArray[1].get(i)][inputArray[0].get(i)];
//                if (!(temp != null && (temp.getColor().equals(color)))){
//                    ret[0].add(inputArray[0].get(i));
//                    ret[1].add(inputArray[1].get(i));
//                }
//            }
//        }
        return ret2;
    }
    public static boolean canCastleKingSide(Piece[][] inputBoard) {
        if (inputBoard[0][3].toString().equals("♔") && inputBoard[0][3].getMoveNum() == 0) {
            if (inputBoard[0][2] == null && inputBoard[0][1] == null) {
                if (inputBoard[0][0].toString().equals("♖") && inputBoard[0][0].getMoveNum() == 0) {
                    return true;
                }
            }
        }
        if (inputBoard[7][3].toString().equals("♚") && inputBoard[7][3].getMoveNum() == 0) {
            if (inputBoard[7][2] == null && inputBoard[7][1] == null) {
                if (inputBoard[7][0].toString().equals("♜") && inputBoard[7][0].getMoveNum() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canCastleQueenSide(Piece[][] inputBoard){
        if (inputBoard[0][3].toString().equals("♔") && inputBoard[0][3].getMoveNum() == 0) {
            if (inputBoard[0][4] == null && inputBoard[0][5] == null && inputBoard[0][6] == null) {
                if (inputBoard[0][7].toString().equals("♖") && inputBoard[0][7].getMoveNum() == 0) {
                    return true;
                }
            }
        }
        if (inputBoard[7][3].toString().equals("♚") && inputBoard[7][3].getMoveNum() == 0) {
            if (inputBoard[7][4] == null && inputBoard[7][5] == null && inputBoard[7][6]==null) {
                if (inputBoard[7][7].toString().equals("♜") && inputBoard[7][7].getMoveNum() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean isChecked(Piece[][] inputBoard, int kingPosX, int kingPosY){
//        ArrayList<Integer> [] ret = new ArrayList[];
//        for(int i = 0; i< inputBoard.length; i++){
//            for(int x = 0; x< inputBoard[i].length; x++){
//                ret = ret.BoardDetails.PossibleMoveCheck(x,i, inputBoard);
//                for(integer z : ret){
//                    if(Piece)
//                }
//            }
//        }
//    }
}

