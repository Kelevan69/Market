import java.util.UUID;

public class Order {
    private String orderId;
    private ShoppingCart shoppingCart;
    private String status;

    public Order(ShoppingCart shoppingCart) {
        this.orderId = UUID.randomUUID().toString();
        this.shoppingCart = shoppingCart;
        this.status = "Pending";
    }

    public String getOrderId() {
        return orderId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
