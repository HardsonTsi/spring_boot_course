package com.hardsontessi.scratch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order) {
        System.out.println(order);
        return "Request accepted and order is: " + order.toString();
    }


}
