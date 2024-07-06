package com.benfreitas.calculator_api.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.benfreitas.calculator_api.exceptions.DivisionByZeroException;
import com.benfreitas.calculator_api.models.CalculatorResult;
import com.benfreitas.calculator_api.services.CalculatorService;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class CalculatorController {
  
    private Counter addCounter;
    private Counter subtractCounter;
    private Counter multiplyCounter;
    private Counter divideCounter;

    public CalculatorController(MeterRegistry registry) {
        this.addCounter = Counter.builder("add_requests_total").
                tag("version", "v1").
                description("Contador de requisições 'add'.").
                register(registry);

        this.subtractCounter = Counter.builder("sub_requests_total").
                tag("version", "v1").
                description("Contador de requisições 'subtract'.").
                register(registry);

        this.multiplyCounter = Counter.builder("mul_requests_total").
                tag("version", "v1").
                description("Contador de requisições 'multiply'.").
                register(registry);

        this.divideCounter = Counter.builder("div_requests_total").
                tag("version", "v1").
                description("Contador de requisições 'divide'.").
                register(registry);

    }
    
    @GetMapping("/add/{a}/{b}")
    public CalculatorResult add(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
        this.addCounter.increment();
        return new CalculatorResult(CalculatorService.add(a, b));
    }

    @GetMapping("/divide/{a}/{b}")
    public CalculatorResult divide(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
        this.divideCounter.increment();
        try {
            BigDecimal result = CalculatorService.divide(a, b);

            return new CalculatorResult(result);  
        } catch (ArithmeticException e) {
            throw new DivisionByZeroException();
        }
    }
    
    @GetMapping("/subtract/{a}/{b}")
    public CalculatorResult subtract(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
    	this.subtractCounter.increment();
    	return new CalculatorResult(CalculatorService.subtract(a, b));
    }
    
    @GetMapping("/multiply/{a}/{b}")
    public CalculatorResult multiply(@PathVariable BigDecimal a, @PathVariable BigDecimal b) {
    	this.multiplyCounter.increment();
    	return new CalculatorResult(CalculatorService.multiply(a, b));
    }
    
}
