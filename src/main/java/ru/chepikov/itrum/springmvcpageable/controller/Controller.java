package ru.chepikov.itrum.springmvcpageable.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.chepikov.itrum.springmvcpageable.Views;
import ru.chepikov.itrum.springmvcpageable.entity.Author;
import ru.chepikov.itrum.springmvcpageable.entity.Book;
import ru.chepikov.itrum.springmvcpageable.repository.AuthorRepo;
import ru.chepikov.itrum.springmvcpageable.repository.BookRepo;

import java.util.List;

@RestController
@RequestMapping("/api")

public class Controller {

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/authors")
    @JsonView(Views.Base.class)
    public List<Author> getAllAuthors(Pageable pageable) {
        return authorRepo.findAll(pageable).stream().toList();
    }
    @GetMapping("/books")
    @JsonView(Views.Base.class)
    public List<Book> getAllBooks(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size) {
        return bookRepo.findAll(PageRequest.of(page, size)).stream().toList();
    }

    @GetMapping("/books/{bookId}")
    @JsonView(Views.Base.class)
    public Book getAllBooks(@PathVariable Long bookId) {
        return bookRepo.findById(bookId).orElse(null);
    }


}
