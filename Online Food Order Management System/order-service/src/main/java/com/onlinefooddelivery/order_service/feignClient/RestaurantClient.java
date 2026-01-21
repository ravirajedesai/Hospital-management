package com.onlinefooddelivery.order_service.feinClient;

import com.onlinefooddelivery.order_service.dto.RestaurantRequest;
import com.onlinefooddelivery.order_service.dto.RestaurantResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Restaurant-service")
public interface RestaurantClient {
    
    @GetMapping("/restaurant/{id}")
    RestaurantResponse getRestaurantById(Long id);
}
