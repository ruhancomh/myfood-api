package com.ruhancomh.myfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ruhancomh.myfood.infrastructure.repository.CustomRepositoryBaseImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryBaseImpl.class)
public class MyfoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfoodApiApplication.class, args);
	}

}
