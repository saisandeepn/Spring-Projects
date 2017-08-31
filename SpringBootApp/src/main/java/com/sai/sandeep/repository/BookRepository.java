package com.sai.sandeep.repository;

import org.springframework.data.repository.CrudRepository;

import com.sai.sandeep.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {

}
