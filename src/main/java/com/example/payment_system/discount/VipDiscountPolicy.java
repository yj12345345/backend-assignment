package com.example.payment_system.discount;

import com.example.payment_system.order.Order;
import org.springframework.stereotype.Component;

@Component
public class VipDiscountPolicy implements DiscountPolicy {
    public int discount(Order order) {
        return 1000;
    }
}