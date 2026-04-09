package com.example.payment_system.payment;

import com.example.payment_system.discount.DiscountResult;
import com.example.payment_system.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Payment {

    @Id @GeneratedValue
    private Long id;

    private int finalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDateTime paymentDate;

    @ManyToOne
    private Order order;

    @ElementCollection
    private List<DiscountResult> discountResults;

    public Payment(Order order, int finalPrice, PaymentMethod method, List<DiscountResult> discountResults) {
        this.order = order;
        this.finalPrice = finalPrice;
        this.paymentMethod = method;
        this.discountResults = discountResults;
        this.paymentDate = LocalDateTime.now();
    }
}
