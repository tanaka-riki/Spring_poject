package com.example.demo;

public class PracticeDoWhile {

	public static void main(String[] args) {
		int num = 100; // 初期値設定

		do {
			System.out.println(num); // 変数numを表示
			num--; //１の減算
		} while (num >= 0); // numが0以上の場合、ブロック内の処理が繰り返される
	}
} //100 から 1 ずつ減算して、0 まで表示するプログラム