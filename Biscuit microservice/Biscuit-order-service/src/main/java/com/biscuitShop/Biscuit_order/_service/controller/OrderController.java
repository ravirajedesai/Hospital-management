package com.biscuitShop.Biscuit_order._service.controller;

import com.biscuitShop.Biscuit_order._service.dto.OrderRequest;
import com.biscuitShop.Biscuit_order._service.entity.BiscuitOrder;
import com.biscuitShop.Biscuit_order._service.service.BiscuitOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    BiscuitOrderService service;

    @GetMapping
    ResponseEntity<Page<BiscuitOrder>> getAllBiscuits
                    (@RequestParam(defaultValue = "1") int pageNo,
                    @RequestParam(defaultValue = "2") int pageSize,
                    @RequestParam(defaultValue = "orderId") String sortBy,
                    @RequestParam(defaultValue = "DESC") String sortDir){
        Page<BiscuitOrder> order=service.getAllOrders(pageNo,pageSize,sortBy,sortDir);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
    @GetMapping("/{id}")
    ResponseEntity<BiscuitOrder> getOrderById(@PathVariable Long id){
        BiscuitOrder byId=service.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOrderById(@PathVariable Long id){
        service.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<BiscuitOrder> addBiscuitOrder(@RequestBody OrderRequest request){
        BiscuitOrder order1=service.postBiscuitOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(order1);
    }
}
