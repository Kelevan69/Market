public class RatingSystem {
    private ProductCatalog productCatalog;

    public RatingSystem(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void rateProduct(String productId, double rating) {
        for (Product product : productCatalog.getAllProducts()) {
            if (product.getId().equals(productId)) {
                product.setRating(rating);
                break;
            }
        }
    }
}
