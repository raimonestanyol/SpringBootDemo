package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRespository bookRespository;

    public BootstrapData(AuthorRepository authorRepository, BookRespository bookRespository) {
        this.bookRespository = bookRespository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRespository.save(ddd);

        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2ee Development without EJB", "789789");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRespository.save(noEJB);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+bookRespository.count());
    }
}