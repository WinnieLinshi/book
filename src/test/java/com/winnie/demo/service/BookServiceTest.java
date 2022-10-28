package com.winnie.demo.service;

import com.winnie.demo.dao.BookDao;
import com.winnie.demo.model.DAOBook;
import com.winnie.demo.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


class BookServiceTest {

    @Mock
    private BookDao bookRepository;

    @InjectMocks
    private BookService bookService;

    private DAOBook book;

    @BeforeEach
    public void setup(){
        bookRepository = Mockito.mock(BookDao.class);
        bookService = new BookServiceImpl(bookRepository
        );
        book = book.builder().id("2") .title("Ramesh").author("Fadatare").description("whatever").build();
    }

    // JUnit test for create method
    @DisplayName("JUnit test for create method")
    @Test
    public void givensBookObject_whenCreateBook_thenReturnBookObject(){
        // given - precondition or setup
        given(bookRepository.findById(book.getId())).willReturn(Optional.empty());
        given(bookRepository.save(book)).willReturn(book);

        System.out.println(bookRepository);
        System.out.println(bookService);

        // when -  action or the behaviour that we are going test
        List<DAOBook> createdBook = bookService.createBook(new ArrayList<DAOBook>(Arrays.asList(book)));

        System.out.println(createdBook);

        // then - verify the output
        assertThat(createdBook).isNotNull();
    }
}