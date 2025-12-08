package com.project.ProductService.service;

import com.project.ProductService.entity.Product;
import com.project.ProductService.exception.ProductServiceCustomExcpeption;
import com.project.ProductService.model.ProductRequest;
import com.project.ProductService.model.ProductResponse;
import com.project.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("Object Created..");
        Product product= Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product Created..");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        log.info("Get the Product for ProductId: {}",id);
        Product product=productRepository.findById(id)
                .orElseThrow(()->
                new ProductServiceCustomExcpeption
                        ("Product With Given Id Is Not Found..",
                        "PRODUCT_NOT_FOUND"));
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long id, long quantity) {
        log.info("Reduced Quantity {} for Id: {}",quantity,id);
        Product product
                =productRepository.findById(id)
                .orElseThrow(()->new ProductServiceCustomExcpeption(
                        "Product with given Id Not Found.",
                        "PRODUCT NOT FOUND"
                ));
        if(product.getQuantity()<quantity){
            throw new ProductServiceCustomExcpeption(
                    "Product does not have sufficient Quantity..",
            "Product Out Of Stock..");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product Quantity Updated Successfully");
    }
}
