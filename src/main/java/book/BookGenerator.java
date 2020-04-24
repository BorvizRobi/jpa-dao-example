package book;

import book.model.Book;
import com.github.javafaker.Faker;


import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class BookGenerator {

    private static Faker faker = new Faker();

        public static Book createRandomBook() {


            java.util.Date date = faker.date().birthday(0,100);
            java.time.LocalDate publicationdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Book book = Book.builder()
                    .isbn13(faker.code().isbn13())
                    .author(faker.book().author())
                    .title(faker.book().title())
                    .format(faker.options().option(Book.Format.class))
                    .publisher(faker.book().publisher())
                    .publicationDate(publicationdate)
                    .pages(faker.number().numberBetween(25,3000))
                    .available(faker.bool().bool())
                    .build();

            return book;
        }
}
