package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.User;

/**
 * Created by sanekesv on 22.03.16.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByName(String name);
}
