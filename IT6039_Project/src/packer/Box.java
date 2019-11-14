package packer;

/**
 *
 * @author Rosanna Walsh
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 

    /**
     *
     * @param customer
     * @param depot
     */
    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }

    Box(Depot d, Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @param product
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    /**
     *
     * @param product
     * @param quantity
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product,quantity)); {
            contents.addProduct(product, quantity);
        }
    }
   
    /**
     *
     * @return
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        return label.toString();
    }
    
    @Override
    public String toString() {
        return getLabel();
    }
    
    /**
     *
     * @return
     */
    public double getWeight() {
        return contents.getWeight();
    }
    
    public void addProduct(Product product) {
        Product product = null;
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }
    
    /**
     *
     * @param p
     * @return can fit product if weight is under 40 
     */
    public boolean canFit(Product p) {
        return p.getWeight() < 40;
    }
    
    /**
     *
     * @param p
     * @param quantity
     * @return quantity of product 
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < 40;
    }
    
    /**
     *
     * @return remaining capacity from max amount of 40 
     */
    public double remainingCapacity() {
        return 40 - this.getWeight();
    }
    
    /**
     *
     * @return whether contents is fragile or not 
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    /**
     *
     * @return whether item is hazardous or not 
     */
    public boolean isHazardous() {
        return false;
    }

    private static class product {

        public product() {
        }
    }
}
