package com.hardsontessi.scratch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScratchApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(ScratchApplication.class, args);
         MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
        System.out.println(myFirstClass.sayHello());
    }

}
