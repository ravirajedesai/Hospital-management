package com.bookLibraryManagement.library_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_order")
public class BookShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Long  bookId;

    @Column(nullable = false)
    private Long bookQuantity;


}
