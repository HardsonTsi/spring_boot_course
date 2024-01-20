package com.hardsontessi.scratch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    MyFirstClass myFirstClass() {
        return new MyFirstClass("First bean");
    }

}
