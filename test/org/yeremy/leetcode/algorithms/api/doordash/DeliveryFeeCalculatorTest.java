package org.yeremy.leetcode.algorithms.api.doordash;

import org.junit.Test;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static org.junit.Assert.assertEquals;

public class DeliveryFeeCalculatorTest {

    private final DeliveryFeeCalculator calculator = new DeliveryFeeCalculator();

    @Test
    public void testCalculateFee_Under5Miles_NoRushHour_NoDashPass() {
        // Distance: 2 miles ($2.00 base + 2 * $0.50 = $3.00)
        // Time: 10:00 AM (Not rush hour)
        // Order Total: $20.00
        long orderTime = getEpochSecond(10);
        Order order = new Order(2.0, orderTime, 20.0);
        CustomerProfile customer = new CustomerProfile(false);

        double fee = calculator.calculateFee(order, customer);
        assertEquals(3.0, fee, 0.001);
    }

    @Test
    public void testCalculateFee_Over5Miles_NoRushHour_NoDashPass() {
        // Distance: 6 miles ($2.00 base + 5 * $0.50 + 1 * $1.00 = $5.50)
        // Time: 10:00 AM
        // Order Total: $20.00
        long orderTime = getEpochSecond(10);
        Order order = new Order(6.0, orderTime, 20.0);
        CustomerProfile customer = new CustomerProfile(false);

        double fee = calculator.calculateFee(order, customer);
        assertEquals(5.50, fee, 0.001);
    }

    @Test
    public void testCalculateFee_RushHour() {
        // Distance: 2 miles ($3.00 base calculated)
        // Time: 5:00 PM (17:00) -> Rush Hour (1.2x)
        // Total Fee: $3.00 * 1.2 = $3.60
        long orderTime = getEpochSecond(17);
        Order order = new Order(2.0, orderTime, 20.0);
        CustomerProfile customer = new CustomerProfile(false);

        double fee = calculator.calculateFee(order, customer);
        assertEquals(3.60, fee, 0.001);
    }

    @Test
    public void testCalculateFee_RushHour_BoundaryEnd() {
        // Time: 7:59 PM (19:59) -> Rush Hour
        long orderTime = getEpochSecond(19);
        // Note: Code uses hour < 20, so 19 is the last integer hour that counts.

        Order order = new Order(2.0, orderTime, 20.0);
        CustomerProfile customer = new CustomerProfile(false);

        // Base $3.00 * 1.2 = $3.60
        double fee = calculator.calculateFee(order, customer);
        assertEquals(3.60, fee, 0.001);
    }

    @Test
    public void testCalculateFee_DashPass_Free() {
        // DashPass member, Order > $25
        long orderTime = getEpochSecond(10);
        Order order = new Order(10.0, orderTime, 30.0);
        CustomerProfile customer = new CustomerProfile(true);

        double fee = calculator.calculateFee(order, customer);
        assertEquals(0.0, fee, 0.001);
    }

    @Test
    public void testCalculateFee_DashPass_NotFree_LowTotal() {
        // DashPass member, but Order <= $25
        // Distance: 2 miles ($3.00)
        long orderTime = getEpochSecond(10);
        Order order = new Order(2.0, orderTime, 20.0);
        CustomerProfile customer = new CustomerProfile(true);

        double fee = calculator.calculateFee(order, customer);
        assertEquals(3.0, fee, 0.001);
    }

    @Test
    public void testCalculateFee_DashPass_NotFree_RushHour() {
        // DashPass member, Order <= $25, Rush Hour
        // Base $3.00
        // Rush Hour * 1.2 = $3.60
        long orderTime = getEpochSecond(17);
        Order order = new Order(2.0, orderTime, 20.0);
        CustomerProfile customer = new CustomerProfile(true);

        double fee = calculator.calculateFee(order, customer);
        assertEquals(3.60, fee, 0.001);
    }

    private long getEpochSecond(int hour) {
        return ZonedDateTime.now(ZoneId.systemDefault())
                .withHour(hour)
                .withMinute(0)
                .withSecond(0)
                .toEpochSecond();
    }
}
