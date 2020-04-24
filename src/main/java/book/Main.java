package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

import java.util.Optional;

import static book.BookGenerator.createRandomBook;

public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);

        for (int i = 0; i < 1000; i++) {
            Book book = createRandomBook();
            bookDao.persist(book);
        }

        bookDao.findAll()
                .stream()
                .forEach(System.out::println);


        Optional<Book> searchresult =bookDao.findByIsbn13("9780877860785");
        searchresult.ifPresent(System.out::println);


    }
}
