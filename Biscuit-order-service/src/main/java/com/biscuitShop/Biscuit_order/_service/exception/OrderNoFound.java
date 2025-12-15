package com.biscuitShop.Biscuit_order._service.exception;

public class OrderNoFound extends RuntimeException{
    public OrderNoFound(String message) {
        super(message);
    }
}
