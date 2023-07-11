package com.example.homework_230712_spring_introduction.Services.Interfaces;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    int plus(int num1, int num2);

    int minus(int num1, int num2);

    int multiply(int num1, int num2);

    double divide(int num1, int num2);
}
