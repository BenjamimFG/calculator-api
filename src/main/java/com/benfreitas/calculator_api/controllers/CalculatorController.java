package com.benfreitas.calculator_api.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.benfreitas.calculator_api.exceptions.DivisionByZeroException;
import com.benfreitas.calculator_api.models.CalculatorResult;
import com.benfreitas.calculator_api.services.CalculatorService;

@RestController
public class CalculatorController {
    
    @GetMapping("/add/{a}/{b}")
    public CalculatorResult add(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
        return new CalculatorResult(CalculatorService.add(a, b));
    }

    @GetMapping("/divide/{a}/{b}")
    public CalculatorResult divide(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
        try {
            BigDecimal result = CalculatorService.divide(a, b);

            return new CalculatorResult(result);  
        } catch (ArithmeticException e) {
            throw new DivisionByZeroException();
        }
    }
    
    @GetMapping("/subtract/{a}/{b}")
    public CalculatorResult subtract(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
    	
    	return new CalculatorResult(CalculatorService.subtract(a, b));
    }
    
    @GetMapping("/multiply/{a}/{b}")
    public CalculatorResult multiply(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
    	
    	return new CalculatorResult(CalculatorService.multiply(a, b));
    }
    
}
