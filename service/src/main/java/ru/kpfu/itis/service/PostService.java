package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Post;

import java.util.List;

/**
 * Created by sanekesv on 22.03.16.
 */
@Service
public interface PostService {
    List<Post> findAll();

    Post save(Post post);
}
