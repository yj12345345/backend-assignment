package com.example.payment_system.discount;

import com.example.payment_system.order.Order;
import org.springframework.stereotype.Component;

@Component
public class VvipDiscountPolicy implements DiscountPolicy {
    public int discount(Order order) {
        return (int)(order.getCost() * 0.1);
    }
}
