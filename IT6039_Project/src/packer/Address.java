package packer;

/**
 *
 * @author Rosanna Walsh
 */
public class Address {
    private final String street;
    private final String suburb;
    private final String city;
    private final String postcode;
    private final Coordinates coordinates;

    /**
     *
     * @param street
     * @param suburb
     * @param city
     * @param postcode
     * @param coordinates
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * @return the coordinates of street, suburb, city and postcode 
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}
