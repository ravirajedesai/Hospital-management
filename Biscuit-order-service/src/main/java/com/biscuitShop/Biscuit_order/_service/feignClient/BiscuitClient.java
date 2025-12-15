package com.biscuitShop.Biscuit_order._service.feignClient;

import com.biscuitShop.Biscuit_order._service.dto.BiscuitResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "biscuit-service")
public interface BiscuitClient {

    @GetMapping("/biscuit/name/{name}")
    BiscuitResponse getBiscuitByName(@PathVariable("name") String name);

    @PutMapping("/biscuit/{id}/{quantity}")
    BiscuitResponse reduceBiscuitStock(@PathVariable("id") Long id,
                                       @PathVariable("quantity") Long quantity);
}
