package com.bookLibraryManagement.book_service.services;

import com.bookLibraryManagement.book_service.entity.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<Book> getAllBooks(int pageNo,int pageSize,String bookName);
    Book getBookById(Long id);
    void deleteBookById(Long id);
    Book addBook(Book book);
    Book updateByBookById(Long id,Book book);

    Book reduceBookQuantity(Long bookId,Long bookQuantity);
}
