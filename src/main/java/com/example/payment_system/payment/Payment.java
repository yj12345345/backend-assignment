package com.example.payment_system.payment;

import com.example.payment_system.order.Order;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Payment {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private int finalPrice;

    private LocalDateTime paymentDate = LocalDateTime.now();

    protected Payment() {}

    public Payment(Order order, PaymentMethod paymentMethod, int finalPrice) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.finalPrice = finalPrice;
    }
}
