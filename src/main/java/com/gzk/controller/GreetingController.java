package com.gzk.controller;

import com.gzk.entity.Greeting;
import com.gzk.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(value = "/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
//    hi
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method =RequestMethod.GET)
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Greeting greeting3(@RequestBody Student student){
        return new Greeting(counter.incrementAndGet(),"Hello, SpringBoot!");
    }
}
