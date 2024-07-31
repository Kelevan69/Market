import java.util.HashMap;
import java.util.Map;

public class DeliveryTracker {
    private Map<String, String> orderStatuses = new HashMap<>();

    public void trackOrder(String orderId, String status) {
        orderStatuses.put(orderId, status);
    }

    public String getOrderStatus(String orderId) {
        return orderStatuses.getOrDefault(orderId, "Order not found");
    }
}
