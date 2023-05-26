package BoardDetails;

import java.util.ArrayList;

public class Coordinate{

    private int xVal;
    private int yVal;

    public Coordinate(int x, int y) {
        xVal = (x);
        yVal = (y);
    }
    public Coordinate(int x,int y, boolean adjust){
        xVal = (x-8);
        yVal = (y-8);
    }

    public int getX(){
        return xVal;
    }
    public int getY(){
        return yVal;
    }
    public void changeCoordinate(int x,int y){
        xVal = (x);
        yVal = (y);
    }
    public String toString(){
        return xVal + "," + yVal;
    }
}
