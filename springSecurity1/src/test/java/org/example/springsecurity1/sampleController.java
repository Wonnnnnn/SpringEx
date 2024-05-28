package org.example.springsecurity1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class sampleController {
    @GetMapping
    public String hello() {
        String a = "1";
        return "hello security";
    }
}
