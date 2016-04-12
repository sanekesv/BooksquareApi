package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Book;

import java.util.List;

/**
 * Created by sanekesv on 22.03.16.
 */
@Service
public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    Book findById(Long id);
}
