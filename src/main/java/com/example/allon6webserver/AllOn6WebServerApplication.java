package com.example.allon6webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.allon6webserver.*"})
public class AllOn6WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllOn6WebServerApplication.class, args);
    }

}
