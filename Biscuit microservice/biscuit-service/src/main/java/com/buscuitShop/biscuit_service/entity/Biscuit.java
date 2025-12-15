package com.buscuitShop.biscuit_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "biscuits")
public class Biscuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long biscuitId;

    @Column(nullable = false)
    private String biscuitName;

    @Column(nullable = false)
    private String biscuitType;

    @Column(nullable = false)
    private Long rate;

    @Column(nullable = false)
    private Long stock;
}
