package ru.kpfu.itis.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.controller.request.BookRequest;
import ru.kpfu.itis.dto.BookDto;
import ru.kpfu.itis.model.Author;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.service.AuthorService;
import ru.kpfu.itis.service.BookService;
import ru.kpfu.itis.util.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanekesv on 23.03.16.
 */
@Controller
@Api(value = "Book controller", description = "Api for action with book")
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @ApiOperation(httpMethod = "GET", value = "get all books")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<BookDto> getAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookDto> booksDto = new ArrayList<>();
        for (Book book: books){
            BookDto bookDto = Mapper.bookModelToDto(book);
            booksDto.add(bookDto);
        }
        return booksDto;
    }

    @ApiOperation(httpMethod = "GET", value = "find book by id")
    @RequestMapping(value = "by/id", method = RequestMethod.GET)
    @ResponseBody
    public BookDto findBookById(@RequestParam Long id){
        return Mapper.bookModelToDto(bookService.findById(id));
    }

    @ApiOperation(httpMethod = "POST", value = "save book")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public BookDto saveBook(@ModelAttribute BookRequest bookRequest){
        Book book = Mapper.bookRequestToModel(bookRequest);
        Author author = authorService.findById(book.getAuthor().getId());
        book.setAuthor(author);
        bookService.save(book);
        return Mapper.bookModelToDto(book);
    }

}
