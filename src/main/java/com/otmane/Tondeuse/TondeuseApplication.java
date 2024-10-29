package com.otmane.Tondeuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication()
public class TondeuseApplication {

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(TondeuseApplication.class, args)));

    }

}
