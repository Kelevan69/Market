import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalog {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> filterProducts(String keyword, double minPrice, double maxPrice, String manufacturer) {
        return products.stream()
                .filter(product -> product.getName().contains(keyword) || product.getManufacturer().contains(keyword))
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .filter(product -> product.getManufacturer().equals(manufacturer))
                .collect(Collectors.toList());
    }
}
