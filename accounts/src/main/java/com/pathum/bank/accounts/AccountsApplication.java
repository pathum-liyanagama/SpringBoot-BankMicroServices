package com.pathum.bank.accounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @ComponentScans({@ComponentScan("com.pathum.bank.accounts")})
// @EnableJpaRepositories("com.pathum.bank.accounts.repository")
// @EntityScan("com.pathum.bank.accounts.model")
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
			title= "Accounts microservice REST API Documentation",
			description = "BankMicroservices REST API Documentation",
			version = "v1",
			contact = @Contact(
					name = "Pathum Liyanagama",
					email = "pathum@gmail.com",
					url = "https://www.pathumpml.com"
			)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		// To fix InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default
		objectMapper.registerModule(new JavaTimeModule());
		// To remove null values in Response coming from DTO objects
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return objectMapper;
	}

}
