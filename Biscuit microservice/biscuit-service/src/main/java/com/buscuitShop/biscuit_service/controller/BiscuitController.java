package com.buscuitShop.biscuit_service.controller;

import com.buscuitShop.biscuit_service.entity.Biscuit;
import com.buscuitShop.biscuit_service.service.BiscuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biscuit")
public class BiscuitController {
    @Autowired
    BiscuitService service;

    @GetMapping
    ResponseEntity<Page<Biscuit>> getAllBiscuits(
            @RequestParam(defaultValue = "1")int pageNo,
            @RequestParam(defaultValue = "2")int pageSize,
            @RequestParam(defaultValue = "biscuitName")String sortBy,
            @RequestParam(defaultValue = "DESC")String sortDir
    ){
        Page<Biscuit> all=service.getAllBiscuit(pageNo,pageSize,sortBy,sortDir);
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }
    @GetMapping("/{id}")
    ResponseEntity<Biscuit> getById(@PathVariable Long id){
        Biscuit get=service.getBiscuitById(id);
        return ResponseEntity.status(HttpStatus.OK).body(get);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteBiscuitById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<Biscuit> addBiscuit(@RequestBody Biscuit biscuit){
        Biscuit add=service.addBiscuits(biscuit);
        return ResponseEntity.status(HttpStatus.OK).body(add);
    }
    @PutMapping("/{id}")
    ResponseEntity<Biscuit> updateBiscuit(@PathVariable Long id,
                                          @RequestBody Biscuit biscuit){
        Biscuit updated=service.updateBiscuit(id,biscuit);
        return ResponseEntity.status(HttpStatus.CREATED).body(updated);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Biscuit> getBiscuitByName(@PathVariable String name){
        Biscuit biscuit=service.getBiscuitByName(name);
        return ResponseEntity.ok(biscuit);
    }
    @PutMapping("/{id}/{quantity}")
    public ResponseEntity<Biscuit> reduceStock(
                    @PathVariable Long id,
                    @PathVariable Long quantity){
        return ResponseEntity.ok(service.reduceBiscuitStock(id, quantity));
    }
}
