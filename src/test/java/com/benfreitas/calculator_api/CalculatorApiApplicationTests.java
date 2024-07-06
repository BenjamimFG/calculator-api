package com.benfreitas.calculator_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.benfreitas.calculator_api.services.CalculatorService;

@SpringBootTest
class CalculatorApiApplicationTests {

	@Test
	void addition() {
		assertEquals(new BigDecimal(10), CalculatorService.add(new BigDecimal(7), new BigDecimal(3)));
	}

	@Test
	void additionWithNegative() {
		assertEquals(new BigDecimal(5), CalculatorService.add(new BigDecimal(7), new BigDecimal(-2)));
	}
	
	@Test
	void subtractTest() {
		assertEquals(new BigDecimal(0), CalculatorService.subtract(new BigDecimal(2), new BigDecimal(2)));
	}
	
	@Test
	void multiplyTest() {
		assertEquals(new BigDecimal(4), CalculatorService.multiply(new BigDecimal(2), new BigDecimal(2)));
	}
	
	@Test
	void divideTest() {
		assertEquals(new BigDecimal("4.000"), CalculatorService.divide(new BigDecimal(8), new BigDecimal(2)));
	}

	@Test
	void divideByZero() {
		assertThrowsExactly(ArithmeticException.class, () -> CalculatorService.divide(new BigDecimal(5), new BigDecimal(0)));
	}

	@Test
	void powTest(){
		assertEquals(4, CalculatorService.pow(2.0,2.0));
	}
	
}
