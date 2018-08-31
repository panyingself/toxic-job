package com.toxic.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by panying on 2018/2/26 0026.
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class JobProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobProviderApplication.class, args);
    }
}
