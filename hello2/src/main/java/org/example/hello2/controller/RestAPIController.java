package org.example.hello2.controller;

import jakarta.ws.rs.GET;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String msg) {
        return msg;
    }

    @GetMapping("/hello2/{msg}")
    public String hello3(@PathVariable String msg) {
        return msg;
    }

    @GetMapping("/hello3")
    public Map<String, String> hello3() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Hong");
        map.put("age", "18");
        map.put("nation", "ROK");
        return map;
    }

    @GetMapping("/hello4")
    public List<String> hello4() {
        List<String> list = new ArrayList<>();
        list.add("Hong");
        list.add("Kim");
        return list;
    }

    @GetMapping("/hello5")
    public Map<String, Object> hello5(@RequestParam String name,
                                      @RequestParam String age,
                                      @RequestParam String nation) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        map.put("nation", nation);
        return map;
    }

    @GetMapping("/hello6")
    public Map<String, Object> hello6(Person person) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", person.getName());
        map.put("age", person.getAge());
        map.put("nation", person.getNation());
        return map;
    }
}

class Person {
    private String name;
    private int age;
    private String nation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
