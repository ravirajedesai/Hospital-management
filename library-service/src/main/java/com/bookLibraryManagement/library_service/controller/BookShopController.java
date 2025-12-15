package com.bookLibraryManagement.library_service.controller;

import com.bookLibraryManagement.library_service.entity.BookShop;
import com.bookLibraryManagement.library_service.services.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class BookShopController {
    @Autowired
    BookShopService service;

    @GetMapping
    ResponseEntity<List<BookShop>> getAllOrders(){
        List<BookShop> getOrders=service.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(getOrders);
    }
    @GetMapping("/{id}")
    ResponseEntity<BookShop> getOrderById(@PathVariable Long id){
        BookShop orderById=service.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderById);
    }
    @PostMapping
    ResponseEntity<BookShop> orderBook(@RequestBody BookShop bookShop){
        BookShop bookAdded=service.orderBooks(bookShop);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookAdded);
    }
}
