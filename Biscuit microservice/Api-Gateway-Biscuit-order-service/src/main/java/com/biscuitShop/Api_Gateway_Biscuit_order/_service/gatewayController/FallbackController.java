package com.biscuitShop.Api_Gateway_Biscuit_order._service.gatewayController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/biscuit-fallback")
    ResponseEntity<String >biscuitFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Biscuit Service is Down..");
    }
    @GetMapping("/order-fallback")
    ResponseEntity<String >orderFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Order Service is Down..");
    }
}
