package com.orderproducepayment.gemstonepaymentservice.service;

import com.orderproducepayment.gemstonepaymentservice.model.PaymentRequest;
import com.orderproducepayment.gemstonepaymentservice.model.PaymentResponse;
import org.springframework.http.HttpStatusCode;


public interface PaymentService {

    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(Long orderId);
}
