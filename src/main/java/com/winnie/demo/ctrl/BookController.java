package com.winnie.demo.ctrl;

import com.winnie.demo.model.DAOBook;
import com.winnie.demo.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    private static Log logger = LogFactory.getLog(BookController.class);
    @Autowired
    private BookService bookService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/create")
    public ResponseEntity<List<DAOBook>> createTransaction(@Valid @RequestBody List<DAOBook> request) {
        return ResponseEntity.ok().body(bookService.createBook(request));
    }

    @GetMapping
    public ResponseEntity<List<DAOBook>> findAllBook(@RequestParam(required = false) String bookTitle,@RequestParam(required = false) String author,@RequestParam(required = false) String publishDate,@RequestParam int pageNo,@RequestParam int pageSize){
        return ResponseEntity.ok().body(bookService.findAllBook(bookTitle,author,publishDate,pageNo,pageSize));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<DAOBook> queryTransaction(@PathVariable("bookId") String bookId) {
        return ResponseEntity.ok().body(bookService.findByBookId(bookId));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity deleteBook(@PathVariable("bookId") String bookId) {
        bookService.deleteByBookId(bookId);
        return ResponseEntity.ok().build();
    }
}