package com.example;

import com.example.dashboard.ReactorPerson;
import com.example.dashboard.ReactorPersonRepository;
import reactor.core.publisher.Flux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({DashboardProperties.class, MongoProperties.class})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class SpringReactiveDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveDashboardApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(ReactorPersonRepository repository) {

		Flux<ReactorPerson> people = Flux.just(
						new ReactorPerson("smaldini", "Stephane Maldini"),
						new ReactorPerson("simonbasle", "Simon Basle"),
						new ReactorPerson("akarnokd", "David Karnok"),
						new ReactorPerson("rstoya05", "Rossen Stoyanchev"),
						new ReactorPerson("sdeleuze", "Sebastien Deleuze"),
						new ReactorPerson("poutsma", "Arjen Poutsma"),
						new ReactorPerson("bclozel", "Brian Clozel")
				);

		return args -> {
			repository.deleteAll().thenMany(repository.save(people)).blockLast();
		};
	}

}


