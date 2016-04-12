package ru.kpfu.itis.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dto.AuthorDto;
import ru.kpfu.itis.dto.BookDto;
import ru.kpfu.itis.model.Author;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.service.AuthorService;
import ru.kpfu.itis.util.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanekesv on 23.03.16.
 */
@Controller
@Api(value = "Author controller", description = "Api for action with users")
@RequestMapping(value = "/api/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @ApiOperation(value = "get all authors", httpMethod = "GET")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorService.findAll();
        List<AuthorDto> authorsDto = new ArrayList<>();
        for (Author author : authors) {
            authorsDto.add(Mapper.authorModelToDto(author));
        }
        return authorsDto;
    }

    @ApiOperation(value = "get all books of author", httpMethod = "GET")
    @RequestMapping(value = "get/books", method = RequestMethod.GET)
    @ResponseBody
    public List<BookDto> findAllAuthorsBooks(@RequestParam Long id){
        Author author = authorService.findById(id);
        List<Book> books = author.getBooks();
        List<BookDto> booksDto = new ArrayList<>();
        for(Book book: books){
            booksDto.add(Mapper.bookModelToDto(book));
        }
        return booksDto;
    }

    @ApiOperation(value = "save author", httpMethod = "POST")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public AuthorDto saveAuthor(@ModelAttribute String name){
        Author author = new Author();
        author.setName(name);
        authorService.save(author);
        return Mapper.authorModelToDto(author);
    }
}
