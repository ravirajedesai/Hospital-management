package com.bookLibraryManagement.library_service.services;

import com.bookLibraryManagement.library_service.dto.BookDto;
import com.bookLibraryManagement.library_service.entity.BookShop;
import com.bookLibraryManagement.library_service.exceptions.OrderNotFound;
import com.bookLibraryManagement.library_service.repository.BookShoprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookShopServiceImpl implements BookShopService{
    @Autowired
    BookShoprepo repo;

    @Autowired
    private RestTemplate restTemplate;

    private String url="http://localhost:8080/book/";

    @Override
    public BookShop orderBooks(BookShop bookShop) {

        String bookurl= url+bookShop.getBookId();

        BookDto bookDto=restTemplate.getForObject(bookurl,BookDto.class);

        if(bookDto==null){
            throw new RuntimeException("Book Not Found..");
        }

        bookShop.setCustomerName(bookDto.getCustomerName());
        bookShop.setBookQuantity(bookDto.getBookQuantity());
        bookShop.setBookId(bookDto.getBookId());

        BookShop savedOrder=repo.save(bookShop);

        String updatedOrder=bookurl+"order";

        restTemplate.postForObject(updatedOrder,savedOrder, String.class);

        return savedOrder;
    }
    @Override
    public List<BookShop> getAllOrders() {
        return repo.findAll();
    }
    @Override
    public BookShop getOrderById(Long id) {
        return repo.findById(id)
                .orElseThrow(()->
                        new OrderNotFound("Book Not Found with Id: "+id));
    }
}
