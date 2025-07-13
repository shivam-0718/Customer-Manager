package com.customermanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Customer Manager Application",
				version = "1.0",
				description = "This application will ." +
						"manage customer information, including registration, updating, and deletion of customer records."
		),
		servers = @Server(
				url = "http://localhost:8084/customer-manager",
				description = "This application is available in the following URL location."
		)
)
public class CustomerManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagerApplication.class, args);
	}

}
