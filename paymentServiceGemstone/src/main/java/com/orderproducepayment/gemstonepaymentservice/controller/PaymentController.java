package com.orderproducepayment.gemstonepaymentservice.controller;

import com.orderproducepayment.gemstonepaymentservice.model.PaymentRequest;
import com.orderproducepayment.gemstonepaymentservice.model.PaymentResponse;
import com.orderproducepayment.gemstonepaymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long>
    doPayment(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.doPayment(paymentRequest)
                , HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentResponse>
    getPaymentDetailsByOrderId(@PathVariable Long orderId){

        return new ResponseEntity<>(paymentService
                .getPaymentDetailsByOrderId(orderId),HttpStatus.OK);
    }

}
