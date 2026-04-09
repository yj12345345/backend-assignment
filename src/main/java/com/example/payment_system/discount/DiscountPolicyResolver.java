package com.example.payment_system.discount;

import com.example.payment_system.member.MemberGrade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscountPolicyResolver {

    private final VipDiscountPolicy vipDiscountPolicy;
    private final VvipDiscountPolicy vvipDiscountPolicy;
    private final NoDiscountPolicy noDiscountPolicy;

    public DiscountPolicy resolve(MemberGrade grade) {
        return switch (grade) {
            case VIP -> vipDiscountPolicy;
            case VVIP -> vvipDiscountPolicy;
            case NORMAL -> noDiscountPolicy;
//            default -> noDiscountPolicy;
        };
    }
}