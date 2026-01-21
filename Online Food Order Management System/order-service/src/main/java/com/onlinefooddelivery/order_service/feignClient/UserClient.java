package com.onlinefooddelivery.order_service.feinClient;

import com.onlinefooddelivery.order_service.dto.UserRequest;
import com.onlinefooddelivery.order_service.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/user/{id}")
    UserResponse getUserById(Long id);
}
