package com.example.homework_230712_spring_introduction.Controllers;

import com.example.homework_230712_spring_introduction.Services.Interfaces.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String index() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (nullCheck(num1, num2)) {
            return "Error. Parameters expected: /plus?num1=*value*&num2=*value*<br>Value type - Integer";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (nullCheck(num1, num2)) {
            return "Error. Parameters expected: /minus?num1=*value*&num2=*value*<br>Value type - Integer";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (nullCheck(num1, num2)) {
            return "Error. Parameters expected: /multiply?num1=*value*&num2=*value*<br>>Value type - Integer";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (nullCheck(num1, num2)) {
            return "Error. Parameters expected: /divide?num1=*value*&num2=*value*<br>Value type - Integer";
        }
        if (num2 == 0) {
            return "Oops! Divided by zero!";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }

    private boolean nullCheck(Object o1, Object o2) {
        return o1 == null || o2 == null;
    }
}
