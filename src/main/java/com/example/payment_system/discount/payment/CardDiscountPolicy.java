package com.example.payment_system.discount.payment;

import com.example.payment_system.discount.DiscountResult;
import org.springframework.stereotype.Component;

@Component
public class CardDiscountPolicy implements PaymentDiscountPolicy {

    @Override
    public DiscountResult discount(int price) {
        return new DiscountResult(
                "CARD_DISCOUNT",
                0,
                0.0,
                null
        );
    }
}