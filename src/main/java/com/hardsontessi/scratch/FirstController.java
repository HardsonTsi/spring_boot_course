package com.hardsontessi.scratch;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello/{userName}")
    public String pathVar(@PathVariable("userName") String userName) {
        return "My username: " + userName;
    }

    @GetMapping("/hello")
    public String paramVar(@RequestParam("userName") String userName) {
        return "My username: " + userName;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order) {
        System.out.println(order);
        return "Request accepted and order is: " + order.toString();
    }


}
