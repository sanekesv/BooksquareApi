package ru.kpfu.itis.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Author;
import ru.kpfu.itis.repository.AuthorRepository;
import ru.kpfu.itis.service.AuthorService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sanekesv on 22.03.16.
 */
@Service("AuthorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
