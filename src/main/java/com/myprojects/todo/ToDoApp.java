package com.myprojects.todo;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring Boot Application class
 *
 */

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "com.myprojects.todo.entity" })
@Configuration
@EnableWebMvc
@ComponentScan
public class ToDoApp {
    private static final Logger LOGGER = Logger.getLogger(ToDoApp.class.getCanonicalName());

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ToDoApp.class);

        app.setShowBanner(false);
        ConfigurableApplicationContext applicationContext = app.run(args);
        LOGGER.log(Level.INFO, "Total number of beans loaded by Spring Boot = " + applicationContext.getBeanDefinitionCount());
        LOGGER.log(Level.INFO, "Successfully started the TODO application");
    }
}
