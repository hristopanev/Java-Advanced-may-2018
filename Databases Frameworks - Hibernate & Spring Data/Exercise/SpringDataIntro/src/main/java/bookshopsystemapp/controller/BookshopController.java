package bookshopsystemapp.controller;


import bookshopsystemapp.service.AuthorSevice;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorSevice authorSevice;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorSevice authorSevice, CategoryService categoryService, BookService bookService) {
        this.authorSevice = authorSevice;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.authorSevice.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBook();


        this.bookTitels();
    }

    private void bookTitels() {
        List<String> bookTitles =  this.bookService.getAllBooksTitlesAfter();

        System.out.println(String.join("\r\n", bookTitles));
    }

    private void authorNames(){

        this.bookService.getAllAuthorsWithBookBefore().forEach(a-> System.out.println());
    }
}
