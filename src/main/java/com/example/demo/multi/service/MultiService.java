package com.example.demo.multi.service;

import org.springframework.stereotype.Service;

@Service
public class MultiService {

	public int multi(int number1, int number2) {

		int result = number1 * number2;

		return result;
	}
}