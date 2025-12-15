package com.bookLibraryManagement.book_service.repository;

import com.bookLibraryManagement.book_service.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Page<Book> findByBookName(String bookName, Pageable pageable);

    Book findByBookId(Long bookId);

    //Book updateBookQuantity(Long bookId,Long bookQuantity);
}
