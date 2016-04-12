package ru.kpfu.itis.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.repository.BookRepository;
import ru.kpfu.itis.service.BookService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sanekesv on 22.03.16.
 */
@Service("BookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }
}
