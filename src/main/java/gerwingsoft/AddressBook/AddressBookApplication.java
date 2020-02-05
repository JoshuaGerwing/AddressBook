package gerwingsoft.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {
	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AddressBookRepository repository) {
		return (args) -> {
			// save a few book
			AddressBook book = new AddressBook();
			book.addBuddyInfo(new BuddyInfo("josh", "4435353534563"));
			book.addBuddyInfo(new BuddyInfo("an", "436345345"));
			repository.save(book);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (AddressBook customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			log.info("");
		};
	}
}
