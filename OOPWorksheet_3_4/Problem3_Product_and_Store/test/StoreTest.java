import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    @Test
    public void testCheapest_basic() {
        Store store = new Store();
        store.addProduct(new Product("Apple", 0.99));
        store.addProduct(new Product("Laptop", 999.99));
        store.addProduct(new Product("Pen", 1.49));
        assertEquals("Apple", store.getCheapest());
    }

    @Test
    public void testCheapest_singleItem() {
        Store store = new Store();
        store.addProduct(new Product("Widget", 5.00));
        assertEquals("Widget", store.getCheapest());
    }

    @Test
    public void testCheapest_empty() {
        Store store = new Store();
        assertEquals("No products", store.getCheapest());
    }

    @Test
    public void testCheapest_lowestFirst() {
        Store store = new Store();
        store.addProduct(new Product("Cheap", 0.50));
        store.addProduct(new Product("Pricey", 50.00));
        assertEquals("Cheap", store.getCheapest());
    }
}
