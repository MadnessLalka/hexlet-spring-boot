package ru.ml.hexlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Добро пожаловать в Hexlet Spring Blog!";
    }

    @GetMapping("/about")
    public String about() {
        return """
                <h1>Привет читатель!</h1>
                <p>Это тестовый проект для изучения Spring Boot на Hexlet!</p>
                """;
    }
}
