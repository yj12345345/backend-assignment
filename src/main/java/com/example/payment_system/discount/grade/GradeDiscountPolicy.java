package com.example.payment_system.discount.grade;

import com.example.payment_system.discount.DiscountResult;
import com.example.payment_system.order.Order;

public interface GradeDiscountPolicy {
    DiscountResult discount(Order order);
}