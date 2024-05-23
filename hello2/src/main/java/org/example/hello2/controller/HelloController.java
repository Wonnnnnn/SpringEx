package org.example.hello2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello2")
    @ResponseBody
    public String hello2(@RequestParam("msg") String msg) {
        return msg;
    }

    @GetMapping("/hello2/{msg}")
    public String hello2(@PathVariable("msg") String msg, Model model) {
        model.addAttribute("msg", msg);
        return "hello";
    }




}
