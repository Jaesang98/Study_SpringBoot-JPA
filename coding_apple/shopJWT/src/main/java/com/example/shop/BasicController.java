package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "redirect:/index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about() {
        return "피싱사이트에요";
    }

    @GetMapping("/date")
    @ResponseBody
    Date date() {
        Date today = new Date();
        return today;
    }
}
