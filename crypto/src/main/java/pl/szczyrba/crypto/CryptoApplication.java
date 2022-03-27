package pl.szczyrba.crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * This is my very first Spring/Spring Boot app.
 * As it's an interview project I assume commenting the code ain't necessary.
*/
@SpringBootApplication
@EnableCaching
public class CryptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
	}

}
