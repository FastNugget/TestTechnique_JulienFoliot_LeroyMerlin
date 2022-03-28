package com.example.julienfoliot_leroymerlinplandevol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JfLmPdvApplication {

    public static void main(String[] args) {
        SpringApplication.run(JfLmPdvApplication.class, args);
    }

}
