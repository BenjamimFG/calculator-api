package com.benfreitas.calculator_api.controllers;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.benfreitas.calculator_api.exceptions.DivisionByZeroException;
import com.benfreitas.calculator_api.models.CalculatorResult;
import com.benfreitas.calculator_api.services.CalculatorService;

@RestController
public class CalculatorController {
    
    @GetMapping("/add/{a}/{b}")
    public CalculatorResult add(@PathVariable String a, @PathVariable String b) {
        try {
            BigDecimal numA = new BigDecimal(a);
            BigDecimal numB = new BigDecimal(b);
            
            
            return new CalculatorResult(CalculatorService.add(numA, numB));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Os valores devem ser numéricos.");
        }
        
    }

    @GetMapping("/divide/{a}/{b}")
    public CalculatorResult divide(@PathVariable String a, @PathVariable String b) {
        try {
            BigDecimal numA = new BigDecimal(a);
            BigDecimal numB = new BigDecimal(b);
            BigDecimal result = CalculatorService.divide(numA, numB);

            return new CalculatorResult(result);  
        } catch (ArithmeticException e) {
            throw new DivisionByZeroException();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Os valores devem ser numéricos.");
        }
    }
    
    @GetMapping("/subtract/{a}/{b}")
    public CalculatorResult subtract(@PathVariable String a, @PathVariable String b) {
    	try {
            BigDecimal numA = new BigDecimal(a);
            BigDecimal numB = new BigDecimal(b);
            
            
            return new CalculatorResult(CalculatorService.subtract(numA, numB));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Os valores devem ser numéricos.");
        }
    	
    }
    
    @GetMapping("/multiply/{a}/{b}")
    public CalculatorResult multiply(@PathVariable String a, @PathVariable String b) {
    	try {
            BigDecimal numA = new BigDecimal(a);
            BigDecimal numB = new BigDecimal(b);
            
            
            return new CalculatorResult(CalculatorService.multiply(numA, numB));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Os valores devem ser numéricos.");
        }
    }

    @GetMapping("/pow/{a}/{b}")
public CalculatorResult pow(@PathVariable String a, @PathVariable String b) {
    try {
        BigDecimal numA = new BigDecimal(a);
        BigDecimal numB = new BigDecimal(b);
        

        BigDecimal result = new BigDecimal(CalculatorService.pow(numA.doubleValue(), numB.doubleValue()));
        
        return new CalculatorResult(result);
    } catch (NumberFormatException e) {
        throw new NumberFormatException("Os valores devem ser numéricos.");
    }
}

    
}
