package BoardDetails;

public class Coordinate{

    private int xVal;
    private int yVal;

    public Coordinate(int x,int y){
        xVal = x;
        yVal = y;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (xVal != that.xVal) return false;
        return yVal == that.yVal;
    }

    @Override
    public int hashCode() {
        int result = xVal;
        result = 31 * result + yVal;
        return result;
    }
}
