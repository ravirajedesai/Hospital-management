package com.bookLibraryManagement.book_service.controller;

import com.bookLibraryManagement.book_service.dto.BookShopDto;
import com.bookLibraryManagement.book_service.entity.Book;
import com.bookLibraryManagement.book_service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping
    Page<Book> getAllBooks(@RequestParam(defaultValue ="1") int pageNo,
                           @RequestParam(defaultValue = "5") int pageSize,
                           @RequestParam(required = false) String name){
        return service.getAllBooks(pageNo-1,pageSize,name);
    }
    @GetMapping("/{id}")
    ResponseEntity<Book> getBookById(@PathVariable Long id){
       Book bookById= service.getBookById(id);
       return ResponseEntity.status(HttpStatus.OK).body(bookById);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<Book> addBook(@RequestBody Book book){
        Book addNewBook=service.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addNewBook);
    }
    @PutMapping("/{id}")
    ResponseEntity<Book> updateBook(@PathVariable Long id,
                                    @RequestBody Book book){
        Book updatedBook=service.updateByBookById(id,book);
        return ResponseEntity.ok().body(updatedBook);
    }
    @PostMapping("/order/{bookId}")
    ResponseEntity<Book> reduceBookQuantity(@PathVariable Long id,
                                            @RequestBody BookShopDto dto){
        Book bookUpdate= service
                .reduceBookQuantity(dto.getBookId(),dto.getBookQuantity());
        return ResponseEntity.ok(bookUpdate);
    }
}
