package com.project.ProductService.exception;

import lombok.Data;

@Data
public class ProductServiceCustomExcpeption extends RuntimeException{

    private String errorCode;

    public ProductServiceCustomExcpeption(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
