package com.adnan.springboot.rest.example;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductCatalog2RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalog2RestServiceApplication.class, args);
		/*int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
			        // return the error code
			        return 0;
			    }
			});
			 
			System.exit(exitCode);*/
	}
}
