package com.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.model.RichardGere;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RESTService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/indexx", method = RequestMethod.GET)
    public RichardGere greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new RichardGere(counter.incrementAndGet(), String.format(template, name));
    }

//    @RequestMapping(value = "indexx", method = RequestMethod.POST)
//    public String saveUser(@RequestParam Map<String,String> requestParams) throws Exception{
//        String userName=requestParams.get("email");
//        String password=requestParams.get("password");
//        return userName + password;
//    }

}
