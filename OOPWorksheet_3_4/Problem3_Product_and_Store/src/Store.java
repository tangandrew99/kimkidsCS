import java.util.ArrayList;

public class Store {
    private ArrayList<Product> inventory;

    public Store() {
        inventory = new ArrayList<>();
    }

    public void addProduct(Product p) {
        inventory.__________(p); // TODO
    }

    public String getCheapest() {
        if (inventory.__________() == 0) { // TODO
            return "__________"; // TODO: return "No products"
        }

        Product cheapest = inventory.__________(0); // TODO

        for (__________ p : inventory) { // TODO: fill in type
            if (p.getPrice() __________ cheapest.getPrice()) { // TODO: comparison
                cheapest = __________; // TODO
            }
        }

        return cheapest.__________(); // TODO
    }
}
