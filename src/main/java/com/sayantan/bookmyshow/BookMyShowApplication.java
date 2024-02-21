package com.sayantan.bookmyshow;

import com.sayantan.bookmyshow.controllers.UserController;
import com.sayantan.bookmyshow.dto.SignInRequestDTO;
import com.sayantan.bookmyshow.dto.SignUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
//		signUpRequestDTO.setEmail("a2@b.com");
//		signUpRequestDTO.setPassword("123");
//		System.out.println(userController.signUp(signUpRequestDTO));

		SignInRequestDTO signInRequestDTO = new SignInRequestDTO();
		signInRequestDTO.setEmail("a2@b.com");
		signInRequestDTO.setPassword("1234");
		System.out.println(userController.signIn(signInRequestDTO).getStatus());
	}
}
