package com.benfreitas.calculator_api.models;

import java.math.BigDecimal;

public class CalculatorResult {
    private BigDecimal result;

    public CalculatorResult(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getResult() {
        return this.result;
    }
}
