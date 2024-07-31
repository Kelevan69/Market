import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void removeProduct(Product product) {
        cartItems.remove(product);
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(Product::getPrice).sum();
    }
}
