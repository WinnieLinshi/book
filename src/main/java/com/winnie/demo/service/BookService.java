package com.winnie.demo.service;

import com.winnie.demo.dao.BookDao;
import com.winnie.demo.model.DAOBook;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface BookService {
    List<DAOBook> createBook(List<DAOBook> bookDaoList);

   List<DAOBook> findAllBook(String bookTitle, String author,String publishDate, int pageNo,int pageSize);

     DAOBook findByBookId(String bookId);
    void  deleteByBookId(String bookId);
}
