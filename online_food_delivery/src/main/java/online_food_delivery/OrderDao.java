package online_food_delivery;


import java.util.List;

public class OrderDao {

    public List<Order> getAllOrders() {
        return null; // simulated DB
    }

    public boolean addOrder(Order order) {
        return true;
    }

    public boolean cancelOrder(int orderId) {
        return true;
    }

    // FINAL method
    public final String getDbInfo() {
        return "MySQL-DB-Connection";
    }

    // VOID method
    public void logAction(String message) {
        System.out.println(message);
    }
}
