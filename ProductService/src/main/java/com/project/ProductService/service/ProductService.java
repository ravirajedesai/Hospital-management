package com.project.ProductService.service;

import com.project.ProductService.model.ProductRequest;
import com.project.ProductService.model.ProductResponse;

public interface ProductService {

    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    void reduceQuantity(long id, long quantity);
}
