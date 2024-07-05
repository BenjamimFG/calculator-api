package com.benfreitas.calculator_api.services;

import java.math.BigDecimal;

public class CalculatorService {
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) throws ArithmeticException {  
        return a.divide(b);
    }

    public static double pow(Double a, Double b) throws ArithmeticException {  
        return Math.pow(a.doubleValue(), b.doubleValue());
    }


}
