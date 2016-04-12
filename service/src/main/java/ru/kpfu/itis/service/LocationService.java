package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Location;

/**
 * Created by sanekesv on 23.03.16.
 */
@Service
public interface LocationService {
    Location save(Location location);
}
