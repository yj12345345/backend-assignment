package com.example.payment_system.order;

import com.example.payment_system.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "orders")
public class Order {

    @Id
    private Long orderId;

    @ManyToOne
    private Member member;

    private String productName;
    private int cost;

    protected Order() {
    }

    public Order(Long orderId, Member member, String productName, int cost) {
        this.orderId = orderId;
        this.member = member;
        this.productName = productName;
        this.cost = cost;
    }
}
