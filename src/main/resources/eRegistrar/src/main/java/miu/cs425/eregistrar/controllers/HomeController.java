package miu.cs425.eregistrar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/eregistra", "/home", "/eregistra/home"})
    public String home() {
        return "home/index";
    }
}
