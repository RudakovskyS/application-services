package by.srudakovsky.auth_reg_service;

import by.srudakovsky.auth_reg_service.repository.GeneralUserDataRepository;
import by.srudakovsky.auth_reg_service.service.GeneralUserDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AuthRegServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(AuthRegServiceApplication.class, args);
	}


}
