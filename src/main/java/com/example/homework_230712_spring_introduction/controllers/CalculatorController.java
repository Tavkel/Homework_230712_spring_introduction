package com.example.homework_230712_spring_introduction.controllers;

import com.example.homework_230712_spring_introduction.services.interfaces.CalculatorService;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

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
    public String plus(@RequestParam() Integer num1, @RequestParam() Integer num2) {
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam() Integer num1, @RequestParam() Integer num2) {
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam() Integer num1, @RequestParam() Integer num2) {
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam() Integer num1, @RequestParam() Integer num2) {
        if (num2 == 0) {
            return "Oops! Divided by zero!";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParametersException(MissingServletRequestParameterException e){
        return "Error. Parameters expected: num1=*value*&num2=*value*<br>Value type - Integer<br>" + e.getMessage();
    }
}
