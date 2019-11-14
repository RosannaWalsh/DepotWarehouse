package packer;

/**
 *
 * @author Rosanna Walsh
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
     *
     * @param x shows Coordinates for both x and y for the boxes 
     * @param y
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return x coordinates 
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return y coordinates 
     */
    public double getY() {
        return y;
    }
    
    /**
     *
     * @param other
     * @return euclidean distance of y times  x 
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    
    /**
     *
     * @param other
     * @return manhattan distance x + y 
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    
    /**
     *
     * @param other
     * @return distance from each company ( euclidean + manhattan) 
     * divided by 2 + 1 
     */
    public double companyDistanceTo(Coordinates other) {
        double euclidean = euclideanDistanceTo(other);
        double manhattan = manhattanDistanceTo(other);
        return (euclidean + manhattan) /2 +1;
    }

}
