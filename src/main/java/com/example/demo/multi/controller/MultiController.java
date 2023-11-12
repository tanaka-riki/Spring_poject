package com.example.demo.multi.controller;

import org.springframework.stereotype.Controller; //下の@Controllerで処理を実行するのに必要
import org.springframework.ui.Model; //コントローラからビューにデータを渡すため
import org.springframework.web.bind.annotation.GetMapping; //HTTP GETリクエストを処理するため

import com.example.demo.multi.service.MultiService;; //MultiServiceを取り入れる

@Controller
public class MultiController {

	private final MultiService multiService; //

	public MultiController(MultiService multiService) {
		this.multiService = multiService;

	}

	@GetMapping("multi")
	public String multi(Model model) {

		String result = "";

		result = String.valueOf(multiService.multi(9, 9));

		model.addAttribute("result", result);

		return "multi.html";

	}
}