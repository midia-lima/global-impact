package br.com.global.donatefoodv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.oas.annotations.EnableOpenApi;


@SpringBootApplication
@EnableCaching
@EnableOpenApi
public class DonateFoodV2Application {

	public static void main(String[] args) {
		SpringApplication.run(DonateFoodV2Application.class, args);
	}

}