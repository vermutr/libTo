package com.example.libto.controller;

import com.example.libto.dto.BookDto;
import com.example.libto.service.BookService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final BookService bookService;

    @GetMapping
    public String hello(){
        return "Hello!!!";
    }

    @GetMapping("/addUser")
    public void addRandomUser() {
        bookService.saveBook(new BookDto(RandomString.make(), RandomString.make(), 2022));
    }

}
