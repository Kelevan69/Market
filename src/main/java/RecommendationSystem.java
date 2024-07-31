import java.util.List;
import java.util.stream.Collectors;

public class RecommendationSystem {
    private ProductCatalog productCatalog;

    public RecommendationSystem(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public List<Product> recommendProducts(double minRating) {
        return productCatalog.getAllProducts().stream()
                .filter(product -> product.getRating() >= minRating)
                .collect(Collectors.toList());
    }
}
