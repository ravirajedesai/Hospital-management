package com.bookLibraryManagement.book_service.dto;

import lombok.Data;

@Data
public class BookShopDto {
    private Long customerId;
    private String customerName;
    private Long bookQuantity;
    private Long bookId;

}
