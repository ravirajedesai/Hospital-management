package com.biscuit_order.biscuit_bill_service.controller;

import com.biscuit_order.biscuit_bill_service.dto.BillRequest;
import com.biscuit_order.biscuit_bill_service.entity.Bill;
import com.biscuit_order.biscuit_bill_service.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService service;

    @GetMapping
    ResponseEntity<List<Bill>> getAllBills(){
        List<Bill>all=service.getAllBills();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }
    @GetMapping("/{id}")
    ResponseEntity<Bill> getBillById(@PathVariable Long id){
        Bill byId=service.getBillById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteBillById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<Bill> addBill(@RequestBody Bill bill){
        Bill add=service.addBill(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(add);
    }
    @PostMapping("/create")
    public ResponseEntity<Bill> createBill(@RequestBody BillRequest request) {
        Bill bill = service.createBill(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(bill);
    }
}
