package com.bookLibraryManagement.library_service.services;

import com.bookLibraryManagement.library_service.entity.BookShop;

import java.util.List;

public interface BookShopService {
    List<BookShop> getAllOrders();
    BookShop getOrderById(Long id);

    BookShop orderBooks(BookShop bookShop);
}
