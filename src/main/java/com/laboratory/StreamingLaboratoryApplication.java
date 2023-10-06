package com.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class StreamingLaboratoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingLaboratoryApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StreamingLaboratoryApplication.class);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	   return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/**")
	         .allowedOrigins("*","http://localhost:8081/","https://bzq45s19-4200.brs.devtunnels.ms/adminTicket","https://5441-2803-1f60-400-11-f1c7-a811-d39b-2cc0.ngrok-free.app","http://127.0.0.1:5500/index.html","http://127.0.0.1:5500")
	         .allowedMethods("*","GET","POST","PUT","DELETE")
	         .allowedHeaders("*");
	      }    
	   };
	}
}
