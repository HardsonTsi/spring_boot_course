package com.hardsontessi.scratch;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${repo.author}")
    private String author;

    @Value("${custom.property}")
    private String customProperty;

    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }

    public String getAuthor() {
        return author;
    }

    public String getCustomProperty() {
        return customProperty;
    }

}
