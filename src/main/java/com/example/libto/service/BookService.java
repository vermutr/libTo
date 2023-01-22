package com.example.libto.service;


import com.example.libto.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    void saveBook(BookDto bookDto);

}
