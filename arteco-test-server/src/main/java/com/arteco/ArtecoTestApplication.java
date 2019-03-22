package com.arteco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.arteco")
@SpringBootApplication
public class ArtecoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtecoTestApplication.class, args);
    }
}