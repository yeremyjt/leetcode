package org.yeremy.leetcode.algorithms.api.doordash;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Try to solve this problem in 45 minutes to simulate the interview.
 * 
 * Prompt:
 * "We need an API to calculate the delivery fee for an order."
 * 
 * Part 1:
 * 
 * Base fee is $2.00.
 * Add $0.50 per mile for the first 5 miles.
 * Add $1.00 per mile for any distance beyond 5 miles.
 * 
 * Part 2 (The Twist):
 * 
 * If the order time is during 'Rush Hour' (5:00 PM - 8:00 PM), multiply the
 * total fee by 1.2x.
 * If the customer is a 'DashPass' member, they get free delivery (fee = $0)
 * only if the order total is above $25.00."
 * 
 */
public class DeliveryFeeCalculator {
    public double calculateFee(Order order, CustomerProfile customerProfile) {
        double baseFee = 2.0;
        double distanceFee = 0.0;

        if (order.getDistance() <= 5) {
            distanceFee = order.getDistance() * 0.5;
        } else {
            distanceFee = 5 * 0.5 + (order.getDistance() - 5) * 1.0;
        }

        double totalFee = baseFee + distanceFee;

        // Rush Hour Check (5 PM - 8 PM)
        if (isRushHour(order.getOrderTime())) {
            totalFee *= 1.2;
        }

        // DashPass Check
        if (customerProfile.isDashPassMember() && order.getOrderTotal() > 25.0) {
            totalFee = 0.0;
        }

        return totalFee;
    }

    private boolean isRushHour(long orderTimeEpochSeconds) {
        Instant instant = Instant.ofEpochSecond(orderTimeEpochSeconds);
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        int hour = zdt.getHour();
        // 5 PM is 17, 8 PM is 20. Range is [17, 20) typically, or [17, 20]?
        // "5:00 PM - 8:00 PM". Let's assume inclusive of 5:00 PM and exclusive of 8:00
        // PM for standard intervals,
        // or effectively anything where hour is 17, 18, 19.
        // If it means strictly between, we might need minute checks, but usually "Rush
        // Hour 5-8" means 17:00 to 19:59.
        return hour >= 17 && hour < 20;
    }
}
