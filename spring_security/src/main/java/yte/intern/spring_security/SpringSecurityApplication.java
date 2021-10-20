package yte.intern.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yte.intern.spring_security.configuration.DatabasePopulator;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class SpringSecurityApplication {

	private final DatabasePopulator databasePopulator;

	@Autowired
	public SpringSecurityApplication(DatabasePopulator databasePopulator) {
		this.databasePopulator = databasePopulator;
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@PostConstruct
	public void populateDatabase(){
		databasePopulator.populateDatabase();
	}

}
