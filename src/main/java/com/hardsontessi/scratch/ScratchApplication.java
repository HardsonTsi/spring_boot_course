package com.hardsontessi.scratch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScratchApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(ScratchApplication.class, args);
        MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
        System.out.println(myFirstService.getAuthor());
        System.out.println(myFirstService.getCustomProperty());
    }

}
