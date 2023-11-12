package com.example.demo.fizzBuzz.service;

//Javaの基準ライブラリからインポート
import java.util.ArrayList; //可変長の配列を表現しリストのデータ構造を提供 ArrayListクラスを使用して文字列のリストを作成
import java.util.List; //List文字列のリスト インターフェースは、リストの基本的な操作を定義 (クラスがどのようなメソッドを持っているのかをあらかじめ定義)

import org.springframework.stereotype.Service; //@Serviceを書く為

@Service
public class FizzBuzzService {

	public List<String> generateFizzBuzz(int start, int end) { // generateFizzBuzzはメソッド(FizzBuzzを生成)start,endを受け取り、結果を生成をする。データをList<String>は呼び戻す
		List<String> result = new ArrayList<>(); // ArrayList<データ型> 変数名 = new ArrayList<>(); resultは新しい文字列リストを作成し、それを初期化

		for (int i = start; i <= end; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i)); // String.valueOf(i));は、resultは文字列(List<String>)を格納。String.valueOfは文字列表現に変換する記述方法
			}
		}
		return result;
	}
}//今回初めて世界のナベアツ三の倍数でFizzでBazzで３と５倍数時はFizzBuzz！