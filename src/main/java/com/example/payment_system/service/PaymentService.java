package com.example.payment_system.service;

import com.example.payment_system.discount.DiscountPolicy;
import com.example.payment_system.discount.DiscountPolicyResolver;
import com.example.payment_system.discount.DiscountResult;
import com.example.payment_system.discount.grade.GradeDiscountPolicy;
import com.example.payment_system.discount.payment.CardDiscountPolicy;
import com.example.payment_system.discount.payment.PointDiscountPolicy;
import com.example.payment_system.order.Order;
import com.example.payment_system.payment.Payment;
import com.example.payment_system.payment.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final GradeDiscountPolicy gradeDiscountPolicy;
    private final PointDiscountPolicy pointDiscountPolicy;
    private final CardDiscountPolicy cardDiscountPolicy;

    public Payment pay(Order order, PaymentMethod method) {

        // 1. 등급 할인
        DiscountResult gradeResult = gradeDiscountPolicy.discount(order);
        int priceAfterGrade = order.getCost() - gradeResult.getDiscountAmount();

        // 2. 결제 수단 할인
        DiscountResult paymentResult;

        if (method == PaymentMethod.POINT) {
            paymentResult = pointDiscountPolicy.discount(priceAfterGrade);
        } else {
            paymentResult = cardDiscountPolicy.discount(priceAfterGrade);
        }

        int finalPrice = priceAfterGrade - paymentResult.getDiscountAmount();

        // 3. 이력 저장
        List<DiscountResult> results = List.of(gradeResult, paymentResult);

        return new Payment(order, finalPrice, method, results);
    }
}
