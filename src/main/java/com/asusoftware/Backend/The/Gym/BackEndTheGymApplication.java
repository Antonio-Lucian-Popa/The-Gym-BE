package com.asusoftware.Backend.The.Gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackEndTheGymApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BackEndTheGymApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(
						"http://localhost:4200",
						"http://localhost:8100",
						"https://the-gym-adjud.netlify.app",
						"https://the-gym-d3876.web.app"
				)
				.allowedMethods(
						"GET",
						"PUT",
						"POST",
						"DELETE",
						"PATCH",
						"OPTIONS"
				);
	}

}
