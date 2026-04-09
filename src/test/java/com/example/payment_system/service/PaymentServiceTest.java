package com.example.payment_system.service;

import com.example.payment_system.member.Member;
import com.example.payment_system.member.MemberGrade;
import com.example.payment_system.order.Order;
import com.example.payment_system.payment.Payment;
import com.example.payment_system.payment.PaymentMethod;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    PaymentService paymentService;

    @Test
    void vipDiscountTest() {
        Member member = new Member(1L, MemberGrade.VIP);
        Order order = new Order(1L, member, "상품A", 10000);

        Payment payment = paymentService.pay(order, PaymentMethod.CARD);

        assertThat(payment.getFinalPrice()).isEqualTo(9000);
    }

    @Test
    void vvipDiscountTest() {
        Member member = new Member(1L, MemberGrade.VVIP);
        Order order = new Order(1L, member, "상품A", 10000);

        Payment payment = paymentService.pay(order, PaymentMethod.CARD);

        assertThat(payment.getFinalPrice()).isEqualTo(9000); // 10% 할인
    }

    @Test
    void normalDiscountTest() {
        Member member = new Member(1L, MemberGrade.NORMAL);
        Order order = new Order(1L, member, "상품A", 10000);

        Payment payment = paymentService.pay(order, PaymentMethod.CARD);

        assertThat(payment.getFinalPrice()).isEqualTo(10000); // 할인 없음
    }

    @Test
    void vvip_point_discount_test() {

        Member member = new Member(1L, MemberGrade.VVIP);
        Order order = new Order(1L, member, "상품A", 10000);

        Payment payment = paymentService.pay(order, PaymentMethod.POINT);

        // VVIP 10% → 9000
        // POINT 5% → 8550
        assertThat(payment.getFinalPrice()).isEqualTo(8550);
    }

    @Test
    void discount_history_test() {

        Member member = new Member(1L, MemberGrade.VIP);
        Order order = new Order(1L, member, "상품A", 10000);

        Payment payment = paymentService.pay(order, PaymentMethod.POINT);

        assertThat(payment.getDiscountResults().size()).isEqualTo(2);
    }
}