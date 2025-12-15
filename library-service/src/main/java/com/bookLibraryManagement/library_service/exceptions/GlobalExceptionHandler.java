package com.bookLibraryManagement.library_service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderNotFound.class)
    ResponseEntity<String> orderNotFound(OrderNotFound ex){
        return ResponseEntity.notFound().build();
    }
}
