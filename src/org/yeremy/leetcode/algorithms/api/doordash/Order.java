package org.yeremy.leetcode.algorithms.api.doordash;

public class Order {
    private double distance; // in miles
    private long orderTime; // in seconds since epoch
    private double orderTotal;

    public Order(double distance, long orderTime, double orderTotal) {
        this.distance = distance;
        this.orderTime = orderTime;
        this.orderTotal = orderTotal;
    }

    public double getDistance() {
        return distance;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
