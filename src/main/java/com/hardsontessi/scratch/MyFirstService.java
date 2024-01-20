package com.hardsontessi.scratch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;

    private Environment environment;


    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOS() {
        return environment.getProperty("os.name");
    }

    public String readProp() {
        return environment.getProperty("repo.author");
    }


    @Autowired
    public void setMyFirstClass(@Qualifier("mySecondClass") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
