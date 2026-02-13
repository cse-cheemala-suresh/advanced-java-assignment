package online_food_delivery;


import java.util.List;


public class OrderManager {

    private OrderDao orderDao;

    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    // 1. Get all orders
    public List<Order> fetchAllOrders() {
        return orderDao.getAllOrders();
    }

    // 2. Add order
    public boolean addOrder(Order order) {
        orderDao.logAction("Order Placed");
        return orderDao.addOrder(order);
    }

    // 3. Cancel order
    public boolean cancelOrder(int orderId) {
        orderDao.logAction("Order Cancelled");
        return orderDao.cancelOrder(orderId);
    }

    // 4. Internal logic
    public String checkOffer() {
        return "Regular Offer";
    }

    // 5. Process orders
    public double processOrder(double price) {
        if (checkOffer().equals("Festival Offer")) {
            return price * 0.80; // 20% discount
        }
        return price * 0.90; // 10% discount
    }

    // 6. Static method
    public static double calculateDiscount(double price) {
        return price * 0.90;
    }
}
