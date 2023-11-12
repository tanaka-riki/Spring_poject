package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int execute(int number1, String operator, int number2) {
		int result = 0;

		switch (operator) {

		case "+":
			result = number1 + number2;
			break;

		case "-":
			result = number1 - number2;
			break;

		case "*":
			result = number1 * number2;
			break;

		case "/":
			if (number2 != 0) {
				result = number1 / number2;
			}
			break;

		}

		return result;

	}
}