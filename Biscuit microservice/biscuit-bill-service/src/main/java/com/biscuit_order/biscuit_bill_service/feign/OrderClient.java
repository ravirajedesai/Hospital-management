package com.biscuit_order.biscuit_bill_service.feign;

import com.biscuit_order.biscuit_bill_service.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service")
public interface OrderClient {

    @GetMapping("/order/{id}")
    OrderDto getOrderById(@PathVariable Long id);
}
