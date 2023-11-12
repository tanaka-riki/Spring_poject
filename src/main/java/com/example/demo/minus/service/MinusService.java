package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {

	public int subtract(int number1, int number2) {
		return number1 - number2;
	}
}