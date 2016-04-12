package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.User;

/**
 * Created by sanekesv on 22.03.16.
 */
@Service
public interface UserService {
    User saveUser(User user);

    User getUser(Long userId);
}
