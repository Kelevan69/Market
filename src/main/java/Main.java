import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        ShoppingCart cart = new ShoppingCart();
        DeliveryTracker tracker = new DeliveryTracker();
        RatingSystem ratingSystem = new RatingSystem(catalog);
        RecommendationSystem recommendationSystem = new RecommendationSystem(catalog);

        // Adding some products to the catalog
        catalog.addProduct(new Product("1", "Laptop", "Dell", 1200, 4.5));
        catalog.addProduct(new Product("2", "Smartphone", "Samsung", 800, 4.2));
        catalog.addProduct(new Product("3", "Headphones", "Sony", 150, 4.8));

        // Console interface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Show all products");
            System.out.println("2. Add product to cart");
            System.out.println("3. View cart");
            System.out.println("4. Create order");
            System.out.println("5. Track order");
            System.out.println("6. Rate product");
            System.out.println("7. Recommend products");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    catalog.getAllProducts().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Enter product ID to add to cart:");
                    String productId = scanner.next();
                    catalog.getAllProducts().stream()
                            .filter(product -> product.getId().equals(productId))
                            .findFirst()
                            .ifPresent(cart::addProduct);
                    break;
                case 3:
                    cart.getCartItems().forEach(System.out::println);
                    break;
                case 4:
                    Order order = new Order(cart);
                    tracker.trackOrder(order.getOrderId(), "Shipped");
                    System.out.println("Order created with ID: " + order.getOrderId());
                    break;
                case 5:
                    System.out.println("Enter order ID to track:");
                    String orderId = scanner.next();
                    System.out.println("Order status: " + tracker.getOrderStatus(orderId));
                    break;
                case 6:
                    System.out.println("Enter product ID to rate:");
                    productId = scanner.next();
                    System.out.println("Enter rating:");
                    double rating = scanner.nextDouble();
                    ratingSystem.rateProduct(productId, rating);
                    break;
                case 7:
                    System.out.println("Recommended products:");
                    recommendationSystem.recommendProducts(4.0).forEach(System.out::println);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}