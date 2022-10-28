package com.winnie.demo.dao;

import com.winnie.demo.model.DAOBook;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<DAOBook, String> {
	List<DAOBook> findAllByTitleIsContainingOrAuthorIsContainingOrPublishDate(String bookTitle, String author,String publishDate, Pageable pageable);
}