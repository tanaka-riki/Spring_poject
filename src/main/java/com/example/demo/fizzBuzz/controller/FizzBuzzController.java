package com.example.demo.fizzBuzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {
	// FizzBuzzServiceはクラス fizzBuzzServiceは変数
	private final FizzBuzzService fizzBuzzService; // インスタンスをプライベートで保持し、そのインスタンスが一度設定されたら再設定されないことを確保するため

	public FizzBuzzController(FizzBuzzService fizzBuzzService) { // コンストラクタ
		this.fizzBuzzService = fizzBuzzService; // FizzBuzzServiceクラスのインスタンスを受け取り、それをfizzBuzzService
												// メンバー変数に代入。これでコントローラーがFizzBuzzサービスを利用できる
	}

	@GetMapping("fizzBuzz") // HTTP GETリクエストを処理するためのメソッド
	public String fizzBuzz(Model model) { // Modelはインターフェース modelは引数、メソッドを呼び出すときに、後ろの()内に入れる値
		model.addAttribute("result", fizzBuzzService.generateFizzBuzz(0, 100));
		return "fizzBuzz.html";
	}
}