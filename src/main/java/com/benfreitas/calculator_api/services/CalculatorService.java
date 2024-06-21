package com.benfreitas.calculator_api.services;

import java.math.BigDecimal;

public class CalculatorService {
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}
