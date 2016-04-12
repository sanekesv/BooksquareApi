package ru.kpfu.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Book;

import javax.transaction.Transactional;

/**
 * Created by sanekesv on 22.03.16.
 */
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
}
