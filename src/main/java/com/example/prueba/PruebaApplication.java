package com.example.prueba;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.support.*;

@SpringBootApplication
public class PruebaApplication extends SpringBootServletInitializer  {
    
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

}
