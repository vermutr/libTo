package com.example.libto.service.impl;

import com.example.libto.config.DetailsConverter;
import com.example.libto.dto.BookDto;
import com.example.libto.entity.Book;
import com.example.libto.repository.BookRepository;
import com.example.libto.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final DetailsConverter detailsConverter;

    @Override
    public List<BookDto> getAllBooks() {
        return detailsConverter.convertList(bookRepository.findAll(), BookDto.class);
    }

    @Override
    public void saveBook(BookDto bookDto) {
        bookRepository.save(detailsConverter.convert(bookDto, Book.class));
    }

}
