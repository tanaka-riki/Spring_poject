package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	private final MinusService minusService; // finalは変数が一度値を代入されたら再代入出来ない。minusServiceはインスタンス

	public MinusController(MinusService minusService) { // MinusController クラスのインスタンスを作成
		this.minusService = minusService; // MinusController クラス内で minusService を利用可能に出来る
	}

	@GetMapping("minus") // 数値を入力し、引き算の計算をリクエストする為
	public String requestAnswer() {
		return "minus.html";
	}

	@PostMapping("calculate") // 答えをレスポンスする為 htmlのformのaction
	public String subtract(@RequestParam("number1") int number1, @RequestParam("number2") int number2, Model model) {

		int result = minusService.subtract(number1, number2);

		model.addAttribute("result", result);

		return "minus.html";
	}
}

//Modelはクラスビューにデータを渡す為に使用。
//@RequestParamhaはクエストパラメータを定義して取得出来る様にするアノテーション ※使う属性は必ず同じものを！
//modelはプログラム内の一般的なデータを表す。