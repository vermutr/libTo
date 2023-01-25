package com.example.libto.controller;

import com.example.libto.dto.BookDto;
import com.example.libto.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void getAllBooksTest() throws Exception {
        List<BookDto> bookDtoList = List.of(new BookDto("title", "author", 2022));
        when(bookService.getAllBooks()).thenReturn(bookDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/book"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"title\":\"title\",\"author\":\"author\", \"bookYear\":2022}]"));
    }

    @Test
    void addNewBookTest() throws Exception {
        doNothing().when(bookService).saveBook(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"title\",\"author\":\"author\", \"bookYear\":2022}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addNewBookBadRequestTest() throws Exception {
        doNothing().when(bookService).saveBook(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}