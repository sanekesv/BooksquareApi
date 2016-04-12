package ru.kpfu.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.Location;

/**
 * Created by sanekesv on 22.03.16.
 */
@Transactional
public interface LocationRepository extends JpaRepository<Location, Long> {
}
