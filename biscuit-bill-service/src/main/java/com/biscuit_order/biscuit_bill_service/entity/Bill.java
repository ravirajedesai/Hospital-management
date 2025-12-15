package com.biscuit_order.biscuit_bill_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @Column(nullable = false)
    private Long biscuitId;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long rate;

    @Column(nullable = false)
    private Long totalAmount;
}
