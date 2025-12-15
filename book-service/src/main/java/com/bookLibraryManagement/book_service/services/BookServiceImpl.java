package com.bookLibraryManagement.book_service.services;

import com.bookLibraryManagement.book_service.entity.Book;
import com.bookLibraryManagement.book_service.exceptions.BookNotFound;
import com.bookLibraryManagement.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository repository;

    @Override
    public Page<Book> getAllBooks(int pageNo, int pageSize,String bookName) {

        Pageable pageable= PageRequest.of(pageNo,pageSize);

        if(bookName==null){
            return repository.findAll(pageable);
        }else {
            return repository.findByBookName(bookName,pageable);
        }
    }
    @Override
    public Book getBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->
                        new BookNotFound("Book Not Found By Id: "+id));
    }
    @Override
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }
    @Override
    public Book addBook(Book book) {

        Book bookExist=repository.findByBookId(book.getBookId());

        if(bookExist!=null){
            Double newQuantity=bookExist
                    .getBookQuantity()+ book.getBookQuantity();

            bookExist.setBookQuantity(newQuantity);

            return repository.save(bookExist);
        }
        return repository.save(book);
    }
    @Override
    public Book reduceBookQuantity(Long bookId,Long bookQuantity) {

        Book book=repository.findByBookId(bookId);

        if(book==null){
            throw new BookNotFound("Book Not Found With Name: "+bookId);
        }else if(book.getBookQuantity()<bookQuantity){
            throw new BookNotFound("Insufficient Book Quantity..");
        }
        book.setBookQuantity(book.getBookQuantity()-bookQuantity);

        return repository.save(book);
    }
    @Override
    public Book updateByBookById(Long id, Book book) {

        Book findBook=repository.findById(id).orElseThrow(()->
                new BookNotFound("Book Not Found By Id: "+id));

        findBook.setBookName(book.getBookName());
        findBook.setBookAuthor(book.getBookAuthor());
        return repository.save(findBook);
    }

}
