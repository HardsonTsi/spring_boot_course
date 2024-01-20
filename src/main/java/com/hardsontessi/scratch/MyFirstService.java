package com.hardsontessi.scratch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    @Qualifier("mySecondClass")
    private MyFirstClass myFirstClass;

    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }

}
