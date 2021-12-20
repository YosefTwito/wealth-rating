package com.example.wealthrating;

import com.example.wealthrating.rich.Rich;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class WealthRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WealthRatingApplication.class, args);
	}

}
