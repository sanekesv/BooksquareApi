package ru.kpfu.itis.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.model.Author;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.AuthorService;
import ru.kpfu.itis.service.BookService;
import ru.kpfu.itis.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sanekesv on 22.03.16.
 */
@Controller
@Api(value = "User controller", description = "Api for action with users")
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @ApiOperation(httpMethod = "GET", value = "user")
    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    public void createBeach() {
        User user = new User();
        user.setName("");
        user.setBirthday(new Date());
//        userService.saveUser(user);
        System.out.println(user.getId());
    }

    @ApiOperation(httpMethod = "GET", value = "create 15 book")
    @RequestMapping(value = "book", method = RequestMethod.GET)
//    @ResponseBody
    public void createBooks() {
        List<Book> books = new ArrayList<>();
        Author pushkin = new Author();
        pushkin.setName("Александр Пукшин");
        authorService.save(pushkin);
        Book onegin = new Book();
        onegin.setName("Евгений Онегин");
        onegin.setAuthor(pushkin);
        onegin.setDescription("«Евге́ний Оне́гин» — роман в стихах Александра Сергеевича Пушкина, написанный в 1823—1831 годах, одно из самых значтельных произведений русской словесности.");
        bookService.save(onegin);
        books.add(onegin);
        Book do4a = new Book();
        do4a.setName("Капитанская дочка");
        do4a.setDescription("«Капита́нская до́чка» — исторический роман А. С. Пушкина, действие которого происходит во время восстания Емельяна Пугачёва.");
        do4a.setAuthor(pushkin);
        bookService.save(do4a);
        books.add(do4a);
        Book ruslan = new Book();
        ruslan.setAuthor(pushkin);
        ruslan.setName("Руслан и Людмила");
        ruslan.setDescription("«Руслан и Людмила» — первая законченная поэма Александра Сергеевича Пушкина; волшебная сказка, вдохновлённая древнерусскими былинами.");
        bookService.save(ruslan);
        books.add(ruslan);
        Author bulgakov = new Author();
        bulgakov.setName("Михаил Булгаков");
        authorService.save(bulgakov);
        Book gvardiya = new Book();
        gvardiya.setDescription("«Бе́лая гва́рдия» — первый роман Михаила Булгакова. Описываются события Гражданской войны на Украине в конце 1918 года. Роман повествует о семье русских интеллигентов и их друзьях, которые переживают социальный катаклизм гражданской войны.");
        gvardiya.setName("Белая гвардия");
        gvardiya.setAuthor(bulgakov);
        bookService.save(gvardiya);
        books.add(gvardiya);
        Book master = new Book();
        master.setAuthor(bulgakov);
        master.setName("Мастер и Маргарита");
        master.setDescription("«Ма́стер и Маргари́та» — роман Михаила Афанасьевича Булгакова, работа над которым началась в конце 1920-х годов и продолжалась вплоть до смерти писателя.");
        bookService.save(master);
        books.add(master);
        Book sobaka = new Book();
        sobaka.setDescription("«Соба́чье се́рдце» — повесть Михаила Афанасьевича Булгакова. ");
        sobaka.setName("Собачье сердце");
        sobaka.setAuthor(bulgakov);
        bookService.save(sobaka);
        books.add(sobaka);

    }

}
