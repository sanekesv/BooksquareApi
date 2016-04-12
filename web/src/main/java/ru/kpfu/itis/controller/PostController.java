package ru.kpfu.itis.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.controller.request.PostRequest;
import ru.kpfu.itis.dto.PostDto;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.Post;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.*;
import ru.kpfu.itis.util.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanekesv on 23.03.16.
 */
@Controller
@Api(value = "Post controller", description = "Api for action sith posts")
@RequestMapping(value = "/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private LocationService locationService;

    @ApiOperation(value = "get all post from user", httpMethod = "GET")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<PostDto> getAll(@RequestParam Long id){
        List<Post> posts = postService.findAll();
        List<PostDto> postsDto = new ArrayList<>();
        for(Post post: posts){
            postsDto.add(Mapper.postModelToDto(post));
        }
        return postsDto;
    }

    @ApiOperation(value = "save post", httpMethod = "POST")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public PostDto savePost(@ModelAttribute PostRequest postRequest){
        Post post = Mapper.postRequestToModel(postRequest);
        User user = userService.getUser((long) 50);
        post.setUser(user);
        Book book = bookService.findById(postRequest.getBookId());
        post.setBook(book);
        post.setLocation(locationService.save(post.getLocation()));
        postService.save(post);
        return Mapper.postModelToDto(post);
    }
}
