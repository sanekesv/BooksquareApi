package ru.kpfu.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Author;

import javax.transaction.Transactional;

/**
 * Created by sanekesv on 22.03.16.
 */
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
