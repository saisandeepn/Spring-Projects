package com.sai.sandeep.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sai.sandeep.model.Author;
import com.sai.sandeep.model.Book;
import com.sai.sandeep.model.Publisher;
import com.sai.sandeep.repository.AuthorRepository;
import com.sai.sandeep.repository.BookRepository;
import com.sai.sandeep.repository.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData(){
		
		Publisher saiPublishers = new Publisher();
		saiPublishers.setName("Sai Publishers");
		publisherRepository.save(saiPublishers);
		
		Author sai =new Author("Sai", "Nandyala");
		Book abc = new Book("Domain Driven Design", "123123",saiPublishers );
		sai.getBooks().add(abc);
		abc.getAuthors().add(sai);
		
		authorRepository.save(sai);
		bookRepository.save(abc);
		
		Publisher wrox = new Publisher();
		wrox.setName("Wrox");
		publisherRepository.save(wrox);
		
		Author vasantha =new Author("Vasantha", "Nandyala");
		Book def = new Book("Java EE Development", "4567898", wrox);
		sai.getBooks().add(def);
		
		authorRepository.save(vasantha);
		bookRepository.save(def);
	}
}
