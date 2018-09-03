package com.sumato.rpn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@Slf4j
@SpringBootApplication
public class SpringBootConsoleApplication{

    public static void main(String[] args) throws Exception {
        log.info("Starting the application...");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        log.info("Application finished...");
    }
}
