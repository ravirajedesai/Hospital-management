package com.biscuit_order.biscuit_bill_service.feign;

import com.biscuit_order.biscuit_bill_service.dto.BiscuitDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "biscuit-service")
public interface BiscuitClient {

    @GetMapping("/biscuit/{id}")
    BiscuitDto getBiscuitById(@PathVariable Long id);
}
