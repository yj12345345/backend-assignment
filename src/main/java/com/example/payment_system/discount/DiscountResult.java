package com.example.payment_system.discount;

import com.example.payment_system.member.MemberGrade;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable   // 🔥 이거 추가
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResult {

    private String policyName;
    private int discountAmount;
    private double discountRate;

    @Enumerated(EnumType.STRING) // enum이면 이것도 필요
    private MemberGrade grade;
}