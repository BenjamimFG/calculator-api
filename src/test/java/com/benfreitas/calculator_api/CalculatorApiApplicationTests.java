package com.benfreitas.calculator_api;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
