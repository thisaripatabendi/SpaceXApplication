package com.cloud.SpaceXApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cloud.SpaceXApplication.exception.handler.RestTemplateResponseErrorHandler;

import org.springframework.boot.web.client.RestTemplateBuilder;
import javax.annotation.PostConstruct;
import java.util.TimeZone;


@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "com.cloud.SpaceXApplication")
@ComponentScan(basePackages = "com.cloud.SpaceXApplication")
@EnableJpaRepositories(basePackages = "com.cloud.SpaceXApplication")
public class SpaceXApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceXApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getDefault());
    }

}
