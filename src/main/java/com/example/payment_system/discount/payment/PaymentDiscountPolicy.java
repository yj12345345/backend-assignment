package com.example.payment_system.discount.payment;

import com.example.payment_system.discount.DiscountResult;

public interface PaymentDiscountPolicy {
    DiscountResult discount(int price);
}
