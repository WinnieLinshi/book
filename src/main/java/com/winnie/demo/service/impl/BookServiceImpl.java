package com.winnie.demo.service.impl;

import com.winnie.demo.dao.BookDao;
import com.winnie.demo.model.DAOBook;
import com.winnie.demo.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private static Log logger = LogFactory.getLog(BookServiceImpl.class);
    @Autowired
    private  BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional
    public List<DAOBook> createBook(List<DAOBook> bookDaoList) {
       return bookDao.saveAll(bookDaoList);
    }

    public  List<DAOBook> findAllBook(String bookTitle, String author,String publishDate, int pageNo,int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("publishDate").descending());
        return bookDao.findAllByTitleIsContainingOrAuthorIsContainingOrPublishDate( bookTitle,  author, publishDate,  pageable);
    }

    public DAOBook findByBookId(String bookId) {
        return bookDao.findById(bookId).orElse(null);
    }
    @Transactional
    public void deleteByBookId(String bookId) {
        bookDao.deleteById(bookId);
    }
}
