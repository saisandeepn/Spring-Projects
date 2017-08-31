package com.sai.sandeep.repository;

import org.springframework.data.repository.CrudRepository;

import com.sai.sandeep.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
