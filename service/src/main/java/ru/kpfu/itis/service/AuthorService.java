package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Author;

import java.util.List;

/**
 * Created by sanekesv on 22.03.16.
 */
@Service
public interface AuthorService {
    Author save(Author author);

    Author findById(Long id);

    List<Author> findAll();
}
