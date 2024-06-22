package com.benfreitas.calculator_api.exceptions;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException() {
        super("Não é possível dividir por 0");
    }
}
