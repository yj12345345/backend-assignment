package com.example.payment_system.discount.payment;

import com.example.payment_system.discount.DiscountResult;
import org.springframework.stereotype.Component;

@Component
public class PointDiscountPolicy implements PaymentDiscountPolicy {

    @Override
    public DiscountResult discount(int price) {

        int discount = (int)(price * 0.05);

        return new DiscountResult(
                "POINT_DISCOUNT",
                (int)(price * 0.05),
                0.05,
                null
        );
    }
}