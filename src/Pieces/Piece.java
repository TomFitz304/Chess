package Pieces;

import BoardDetails.Board;
import BoardDetails.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece extends JButton {
    protected String icon;

    protected String color;

    protected int moveNum;

    protected boolean threatened;

    final int increaseForOverSized = 8;

    protected Coordinate coordinate;

    Piece(int colorNum, String icon) {
        super(icon);
        setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 80));
        color = colorNum == 0 ? "Black" : "White";
        this.icon = icon;
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
        setBackground(threatened ? Color.yellow : Color.white);
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isValid() {
        return true;
    }

    public ArrayList<Coordinate> possibleMoveArray(Board inputBoard, ArrayList<Coordinate> coordinates) {

        ArrayList<Coordinate> ret = new ArrayList<>();
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
