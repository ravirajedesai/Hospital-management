package com.security.demoSpringSecurity.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProduceController {
    private record Product(int id,String name,double price){}

    List<Product>products=new ArrayList<>(List.of(
            new Product(1,"Apple",1000),
            new Product(2,"Samsung",800),
            new Product(3,"OnePlus",900)
    ));
    @GetMapping
    public List<Product>getProducts(){
        return products;
    }
    @PostMapping
    public Product saveProducts(@RequestBody Product product){
        products.add(product);
        return product;
    }
}
