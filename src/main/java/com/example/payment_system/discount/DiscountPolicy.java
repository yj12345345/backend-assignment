package com.example.payment_system.discount;

import com.example.payment_system.order.Order;

public interface DiscountPolicy {
    int discount(Order order);
}
