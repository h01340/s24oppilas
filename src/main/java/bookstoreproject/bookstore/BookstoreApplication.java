package bookstoreproject.bookstore;

import bookstoreproject.bookstore.domain.AppUser;
import bookstoreproject.bookstore.domain.AppUserRepository;
import bookstoreproject.bookstore.domain.Book;
import bookstoreproject.bookstore.domain.BookRepository;
import bookstoreproject.bookstore.domain.Category;
import bookstoreproject.bookstore.domain.CategoryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository,
			AppUserRepository appUserRepository) {
		return (args) -> {

			Category crime = new Category("Crime");
			Category cooking = new Category("Cooking");
			Category selfHelp = new Category("Self help");

			categoryRepository.save(crime);
			categoryRepository.save(cooking);
			categoryRepository.save(selfHelp);

			bookRepository.save(new Book("Akun seikkailut", "Aku Ankka", "A1234B5678", 2008, 8.99, crime));
			bookRepository
					.save(new Book("Iineksen iltapäiväkahvit", "Iines Ankka", "A4321B8765", 2023, 12.99, cooking));
			bookRepository.save(new Book("Roopen säästövinkit", "Roope Ankka", "A3412B7856", 2019, 29.99, selfHelp));
			bookRepository.save(new Book("Ole elämäsi keksijä", "Pelle Peloton", "B7482N2934", 2015, 18.99, selfHelp));

			AppUser user1 = new AppUser("user", "$2a$10$hwusJ02maiST/0ykzsYZzOjf1u5IWFptz6BYvxSOF2747Nxuupnqa", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0IYia3/Te8xchjPsFtm2BuBIDruvAHDYTrxYuJXZJ8oimLI18p0gu",
					"ADMIN");
			appUserRepository.save(user1);
			appUserRepository.save(user2);
		};
	}
}
