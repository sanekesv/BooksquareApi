package ru.kpfu.itis.util;

import ru.kpfu.itis.controller.request.BookRequest;
import ru.kpfu.itis.controller.request.PostRequest;
import ru.kpfu.itis.dto.*;
import ru.kpfu.itis.model.*;

/**
 * Created by sanekesv on 23.03.16.
 */
public class Mapper {

    public static Book bookRequestToModel(BookRequest bookRequest){
        Book book = new Book();
        Author author = new Author();
        author.setId(bookRequest.getAuthorId());
        book.setAuthor(author);
        book.setName(bookRequest.getName());
        book.setDescription(bookRequest.getDescription());
        return book;
    }

    public static BookDto bookModelToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setDescription(book.getDescription());
        bookDto.setName(book.getName());
        bookDto.setId(book.getId());
        bookDto.setAuthor(authorModelToDto(book.getAuthor()));
        return bookDto;
    }

    public static AuthorDto authorModelToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        return authorDto;
    }


    public static PostDto postModelToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        postDto.setBook(bookModelToDto(post.getBook()));
        postDto.setLocation(locationModelToDto(post.getLocation()));
        postDto.setUser(userModelToDto(post.getUser()));
        return postDto;
    }

    private static UserDto userModelToDto(User user) {
        UserDto userDto = new UserDto();
        user.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setBirthday(user.getBirthday());
        return userDto;
    }

    private static LocationDto locationModelToDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setLat(location.getLat());
        locationDto.setLng(location.getLng());
        return locationDto;
    }

    public static Post postRequestToModel(PostRequest postRequest) {
        Post post = new Post();
        post.setDescription(postRequest.getDescription());
        if((postRequest.getLocName() != null && postRequest.getLocName().length()>0) ||
                (postRequest.getLat() != null && Math.abs(postRequest.getLat())>0) ||
                (postRequest.getLng() != null && Math.abs(postRequest.getLng())>0)) {
            Location location = new Location();
            location.setLng(postRequest.getLng());
            location.setLat(postRequest.getLat());
            location.setName(postRequest.getLocName());
            post.setLocation(location);
        }
        return post;
    }
}
