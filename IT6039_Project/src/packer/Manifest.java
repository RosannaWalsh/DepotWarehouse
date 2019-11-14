package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author Rosanna Walsh 
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private final Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private final Set<Product> byWeight;

    /**
     *
     */
    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    /**
     *
     * @param p
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     *
     * @param p
     * @param quantity
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)*quantity);
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    
    /**
     *
     * @param p
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        }
        if (quantities.get(p) == 0) {
            quantities.remove(p);
        }
        if (quantities.containsKey(p)) {
            byWeight.remove(p);
        }
    }
    
    /**
     *
     * @return total weight of item 
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight = quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     *
     * @param weight
     * @return
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     *
     * @param p
     * @return
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        quantities.keySet().stream().map((p) -> {
            result.append(p.getName());
            return p;
        }).map(new Function<Object, Object>() {
            @Override
            public Object apply(Object p) {
                result.append(" x ");
                result.append(quantities.get(p));
                return p;
            }
        }).forEachOrdered(new ConsumerImpl(result));
        return result.substring(0, result.length()-1);
    }
    
    /**
     *
     * @return if items are fragile 
     */
    public boolean hasFragileItems() {
        return quantities.keySet().stream().anyMatch((p) -> (p.isFragile()));
    }

    double getWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class ConsumerImpl implements Consumer<Product> {

        private final StringBuilder result;

        public ConsumerImpl(StringBuilder result) {
            this.result = result;
        }

        private ConsumerImpl(StringBuilder result) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private ConsumerImpl(StringBuilder result) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void accept(Product _item) {
            result.append("\n");
        }
    }
}
    

