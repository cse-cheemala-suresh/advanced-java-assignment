package online_food_delivery_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;


import online_food_delivery.Order;
import online_food_delivery.OrderDao;
import online_food_delivery.OrderManager;

@ExtendWith(MockitoExtension.class)
class OrderManagerTest {

    @Mock
    OrderDao orderDao;

    @InjectMocks
    OrderManager orderManager;

    // 1. Fetch all orders
    @Test
    void testFetchAllOrders() {
        List<Order> orders = Arrays.asList(
                new Order(1, "Dominos", "Pizza", 500),
                new Order(2, "KFC", "Burger", 300)
        );

        when(orderDao.getAllOrders()).thenReturn(orders);

        List<Order> result = orderManager.fetchAllOrders();

        assertEquals(2, result.size());
    }

    // 2. Add order
    @Test
    void testAddOrder() {
        Order order = new Order(3, "Subway", "Sandwich", 250);

        when(orderDao.addOrder(order)).thenReturn(true);

        assertTrue(orderManager.addOrder(order));

        verify(orderDao).addOrder(order);
        verify(orderDao).logAction("Order Placed");
    }

    // 3. Cancel order
    @Test
    void testCancelOrder() {
        when(orderDao.cancelOrder(1)).thenReturn(true);

        assertTrue(orderManager.cancelOrder(1));

        verify(orderDao).cancelOrder(1);
        verify(orderDao).logAction("Order Cancelled");
    }

    // 4. Static discount calculation
    @Test
    void testStaticDiscount() {
        assertEquals(900, OrderManager.calculateDiscount(1000));
    }

    // 5. Final method
    @Test
    void testFinalDbInfo() {
        assertEquals("MySQL-DB-Connection", orderDao.getDbInfo());
    }

    // 6. Void method
    @Test
    void testVoidLogMethod() {
        doNothing().when(orderDao).logAction(anyString());

        orderDao.logAction("Order Placed");

        verify(orderDao).logAction("Order Placed");
    }

    // 7. Spy for internal logic
    @Test
    void testProcessOrderWithFestivalOffer() {
        OrderManager spyManager = spy(orderManager);

        doReturn("Festival Offer").when(spyManager).checkOffer();

        double finalPrice = spyManager.processOrder(1000);

        assertEquals(800, finalPrice);
    }
}
