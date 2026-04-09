package com.example.payment_system.discount.grade;

import com.example.payment_system.discount.DiscountResult;
import com.example.payment_system.member.MemberGrade;
import com.example.payment_system.order.Order;
import org.springframework.stereotype.Component;

@Component
public class GradeDiscountPolicyImpl implements GradeDiscountPolicy {

    @Override
    public DiscountResult discount(Order order) {

        MemberGrade grade = order.getMember().getMemberGrade();
        int price = order.getCost();

        if (grade == MemberGrade.VIP) {
            return new DiscountResult("VIP_DISCOUNT", 1000, 0.0, grade);
        }

        if (grade == MemberGrade.VVIP) {
            int discount = (int)(price * 0.1);

            return new DiscountResult("VVIP_DISCOUNT", discount, 0.1, grade);
        }

        return new DiscountResult(
                "NO_DISCOUNT", 0, 0.0, grade);
    }
}