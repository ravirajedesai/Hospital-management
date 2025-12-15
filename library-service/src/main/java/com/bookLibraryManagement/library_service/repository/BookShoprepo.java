package com.bookLibraryManagement.library_service.repository;

import com.bookLibraryManagement.library_service.entity.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShoprepo extends JpaRepository<BookShop,Long>{}