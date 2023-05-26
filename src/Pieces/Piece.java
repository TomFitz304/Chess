package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece extends JButton {
    protected String icon;

    protected String name;

    protected String color;

    protected int moveNum;

    protected int yVal;

    protected int xVal;

    protected boolean threatened;

    final int increaseForOverSized = 8;

    protected Coordinate coordinate;

    Piece(int colorNum, String name, String icon) {
        super(icon);
        color = colorNum == 0 ? "Black" : "White";
        this.icon = icon;
        name = color + " " + Object.class.getSimpleName();
        moveNum = 0;
        threatened = false;
    }

    public String toString() {
        return icon;
    }

    public abstract ArrayList<Coordinate> possibleMoves(Board board);


    public String getColor() {
        return color;
    }

    public void incrementMoveNum() {
        moveNum++;
    }

    public int getMoveNum() {
        return moveNum;
    }

    public void updatePos(int x, int y) {
        coordinate = new Coordinate(x, y);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setThreatened(boolean input) {
        threatened = input;
    }

    public boolean isThreatened() {
        return threatened;
    }

    public boolean isEmpty() {
        return icon.equals(" ");
    }

    public ArrayList<Coordinate> possibleMoveArray(Board inputBoard, ArrayList<Coordinate> coordinates) {

        ArrayList<Coordinate> ret = new ArrayList<Coordinate>();
        String color = inputBoard.getPiece(coordinate.getX(), coordinate.getY()).getColor();

        for (Coordinate coordinate : coordinates) {
            if (coordinate.getX() >= 0 && coordinate.getX() <= 7 && coordinate.getY() >= 0 && coordinate.getY() <= 7) {
                Piece temp = inputBoard.getPiece(coordinate.getX(), coordinate.getY());
                if (!(temp.getColor().equals(color))) {
                    ret.add(coordinate);
                }
            }
        }
        return ret;
    }
}
