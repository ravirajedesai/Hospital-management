package com.orderproducepayment.gemstonepaymentservice.service;

import com.orderproducepayment.gemstonepaymentservice.entity.TransactionDetails;
import com.orderproducepayment.gemstonepaymentservice.model.PaymentMode;
import com.orderproducepayment.gemstonepaymentservice.model.PaymentRequest;
import com.orderproducepayment.gemstonepaymentservice.model.PaymentResponse;
import com.orderproducepayment.gemstonepaymentservice.repository.TransactionDetailsRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    TransactionDetailsRepo transactionDetailsRepo;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {

        log.info("Recording payments Details: {}",paymentRequest);
        TransactionDetails transactionDetails=
                TransactionDetails.builder()
                        .paymentDate(Instant.now())
                        .paymentMode(paymentRequest.getPaymentMode().name())
                        .paymentStatus("Success.")
                        .orderId(paymentRequest.getOrderId())
                        .referenceNumber(paymentRequest.getReferenceNumber())
                        .amount(paymentRequest.getAmount())
                        .build();
        transactionDetailsRepo.save(transactionDetails);
        log.info("Transaction Completed with Id:{}",transactionDetails.getId());
        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(Long orderId) {

        log.info("Getting Payment Details For OrderId: {}",orderId);

        TransactionDetails transactionDetails=
                transactionDetailsRepo.findByOrderId(orderId);
        if (transactionDetails == null) {
            log.error("No payment record found for Order ID: {}", orderId);
            throw new RuntimeException("Payment Not Found");
        }

        PaymentResponse paymentResponse= PaymentResponse.builder()
                        .paymentId(transactionDetails.getId())
                        .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                        .paymentDate(transactionDetails.getPaymentDate())
                        .orderId(transactionDetails.getOrderId())
                        .paymentStatus(transactionDetails.getPaymentStatus())
                        .amount(transactionDetails.getAmount())
                        .build();

        log.info("Returning payment details: {}", paymentResponse);
        return paymentResponse;
    }
}
