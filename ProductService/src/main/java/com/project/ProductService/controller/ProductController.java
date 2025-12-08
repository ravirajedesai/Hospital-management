package com.project.ProductService.controller;

import com.project.ProductService.model.ProductRequest;
import com.project.ProductService.model.ProductResponse;
import com.project.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody
                                               ProductRequest productRequest){
    Long productId=productService.addProduct(productRequest);
    return new ResponseEntity<>(productId,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id){

        ProductResponse productResponse=productService.getProductById(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
    @PutMapping("/reduce-quantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
            @PathVariable long id,
            @RequestParam long quantity
    ){
        productService.reduceQuantity(id,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
