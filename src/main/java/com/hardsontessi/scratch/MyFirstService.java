package com.hardsontessi.scratch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;

    @Autowired
    public void injectInjections(@Qualifier("myThirdClass") MyFirstClass myFirstClass){
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }

}
