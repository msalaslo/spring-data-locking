package com.verisure.vcp.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.verisure.vcp.mongodb.domain.entity.Customer;
import com.verisure.vcp.mongodb.domain.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Application bootstrap class.
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Slf4j
@SpringBootApplication
@EnableFeignClients
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	static final String topicExchangeName = "spring-boot-exchange";

	static final String queueName = "spring-boot";

	protected Application() {
		LOGGER.info("Starting REST microservice");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
		Customer alice = repository.findByFirstName("Alice");
		alice.setLastName("Moro");
		
		Customer alice2 = repository.findByFirstName("Alice");
		alice2.setLastName("Cris");

	
		repository.save(alice);
		repository.save(alice2);
	}

	/**
	 * TODO: If your application uses: - Spring Rest Template: this method is
	 * intented to propagate tracing fields with Spring Sleuth, you have to Autowire
	 * this RestTemplate bean in your clients. - Spring Feign (recommended): delete
	 * this method.
	 * 
	 * @param builder
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(final RestTemplateBuilder builder) {
		return builder.build();
	}
}
