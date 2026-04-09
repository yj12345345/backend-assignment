package com.example.payment_system.service;

import com.example.payment_system.discount.DiscountPolicy;
import com.example.payment_system.discount.DiscountPolicyResolver;
import com.example.payment_system.order.Order;
import com.example.payment_system.payment.Payment;
import com.example.payment_system.payment.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final DiscountPolicyResolver resolver;

    public Payment pay(Order order, PaymentMethod method) {

        DiscountPolicy policy = resolver.resolve(order.getMember().getMemberGrade());

        int discountAmount = policy.discount(order);
        int finalPrice = order.getCost() - discountAmount;

        return new Payment(order, method, finalPrice);
    }
}
