package com.biscuitShop.Biscuit_order._service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "biscuit_order")
public class BiscuitOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Long quantity;

    private Long biscuitId;
//    private Long stock;
}
