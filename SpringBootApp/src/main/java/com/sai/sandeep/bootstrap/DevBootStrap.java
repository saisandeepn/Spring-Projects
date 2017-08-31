package com.sai.sandeep.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sai.sandeep.model.Author;
import com.sai.sandeep.model.Book;
import com.sai.sandeep.repository.AuthorRepository;
import com.sai.sandeep.repository.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData(){
		Author sai =new Author("Sai", "Nandyala");
		Book abc = new Book("Domain Driven Design", "123123", "Oreily");
		sai.getBooks().add(abc);
		abc.getAuthors().add(sai);
		
		authorRepository.save(sai);
		bookRepository.save(abc);
		
		Author vasantha =new Author("Vasantha", "Nandyala");
		Book def = new Book("Java EE Development", "4567898", "Wrox");
		sai.getBooks().add(def);
		
		authorRepository.save(vasantha);
		bookRepository.save(def);
	}
}
