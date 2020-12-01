package com.todolist.springvue;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import java.util.Collections;
import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;


import com.todolist.springvue.model.Todo;

@SpringBootApplication
public class SpringVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringVueApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(TodoRepository repository) {  
        return args -> {  
            Stream.of("Estudar", "Comer", "Dormir", "Brincar").forEach(nome -> {  
                    Todo todo = new Todo();  
                    todo.setNome(nome);  
                    repository.save(todo);  
            });  
            repository.findAll().forEach(System.out::println);  
        };  
    }  
	
	
	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:8080")); 
        config.setAllowedMethods(Collections.singletonList("*"));  
        config.setAllowedHeaders(Collections.singletonList("*")); 
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
