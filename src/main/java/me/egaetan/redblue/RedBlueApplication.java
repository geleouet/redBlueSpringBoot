package me.egaetan.redblue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RedBlueApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedBlueApplication.class, args);
	}

}
