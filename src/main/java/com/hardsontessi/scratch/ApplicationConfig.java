package com.hardsontessi.scratch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    public MyFirstClass myFirstClass() {
        return new MyFirstClass("First bean");
    }

    @Bean
    public MyFirstClass mySecondClass() {
        return new MyFirstClass("Second bean");
    }

    @Bean
    @Primary
    public MyFirstClass myThirdClass() {
        return new MyFirstClass("Third bean");
    }


}
