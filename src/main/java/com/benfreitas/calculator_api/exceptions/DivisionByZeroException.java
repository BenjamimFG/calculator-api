package com.benfreitas.calculator_api.exceptions;

public class DivisionByZeroException extends ArithmeticException {

	private static final long serialVersionUID = 1L;

	public DivisionByZeroException() {
        super("Não é possível dividir por 0");
    }
}
