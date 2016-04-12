package ru.kpfu.itis.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Post;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.service.PostService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sanekesv on 22.03.16.
 */
@Service("PostService")
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
