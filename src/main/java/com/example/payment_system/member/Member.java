package com.example.payment_system.member;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "members")
public class Member {
    @Id
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    protected Member() {
    }

    public Member(long memberId, MemberGrade memberGrade) {
        this.memberId = memberId;
        this.memberGrade = memberGrade;
    }

}