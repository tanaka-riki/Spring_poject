//Data  
//JSON形式のデータをJavaオブジェクトに割り当てるためのデータモデル
//JSONデータの構造とJavaプログラムのデータ構造との間の対応を定義し、データを扱いやすくするために使用
//外部APIから取得したデータをJavaオブジェクトに変換し、アプリケーション内で処理しやすくする

package com.example.demo.AnimalsAPI.data;

import com.fasterxml.jackson.annotation.JsonProperty;

//JacksonというJSON処理ライブラリの一部で、@JsonProperty アノテーションを使用するために必要
//JSONデータ内のフィールド名がJavaクラスのフィールド名と異なる場合、このアノテーションを使用して対応関係を明示的に指定
import lombok.Data;
//Lombokのプロジェクトの一部で、@Data アノテーションを使用するために必要
//ゲッターメソッド、セッターメソッド、equals メソッド、hashCode メソッド、toString メソッドが自動生成される
//ゲッターメソッドは、クラス内のプライベートなフィールドの値を取得
//セッターメソッドは、クラス内のプライベートなフィールドの値を設定または変更するため

@Data
public class AnimalsAPIData {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("japanese_name")
	private String japaneseName;

	@JsonProperty("cry")
	private String cry;

}
//@JsonProperty("id")はjasonで定義されてるのを、private int id;でjavaでのデータとして定義