package packer;

/**
 *
 * @author Rosanna Walsh 
 */
public class Depot {
    private String name;
    private Address address;

    /**
     *
     * @param name 
     * @param address
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     *
     * @returns name and address 
     */
    public String getName() {
        return address.toString();
    }
    
    /**
     *
     * @returns the coordinates of the addresses 
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    public String toString() {
        return this.getName();
    }
    
}
