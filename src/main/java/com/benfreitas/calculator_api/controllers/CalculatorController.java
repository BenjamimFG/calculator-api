package com.benfreitas.calculator_api.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.benfreitas.calculator_api.models.CalculatorResult;
import com.benfreitas.calculator_api.services.CalculatorService;

@RestController
public class CalculatorController {
    
    @GetMapping("/add/{a}/{b}")
    public CalculatorResult add(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
        return new CalculatorResult(CalculatorService.add(a, b));
    }
}
