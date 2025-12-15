package com.bookLibraryManagement.library_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private Long bookId;
    private String customerName;
    private String bookName;
    private String bookAuthor;
    private Long bookQuantity;
}
