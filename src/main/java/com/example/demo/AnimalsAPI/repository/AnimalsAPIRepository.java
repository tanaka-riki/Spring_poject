//Repository
//外部APIからデータを取得し、それをJavaオブジェクトに変換するための筋道
//外部APIとの通信、データの取得、変換を担当し、このデータをコントローラーに提供

package com.example.demo.AnimalsAPI.repository;

import java.io.IOException;

//Javaの例外処理を行うために必要
//getAnimalsAPIData メソッドと getSelectedAnimalsAPIData メソッドは、外部のAPIからデータを取得するその際入出力操作を行うため、例外処理が必要
//間違いないようにする
import org.springframework.http.ResponseEntity;
//Spring Frameworkの一部であり、HTTPリクエストの結果を表現するためのクラス ResponseEntityクラスを使用するために必要
//外部APIからHTTPリクエストを送信し、その応答をResponseEntityクラスで受け取る
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
//Spring Frameworkの RestTemplate クラスを使用するために必要
//外部APIに対してGETリクエストを送信するために RestTemplate を使用
//RestTemplate は、RESTfulなHTTPリクエストを送信し、外部APIとの通信を簡素化するためのクラス
//RESTful = RESTful API は、2つのコンピュータシステムがインターネットを介して安全に情報を交換するために使用するインターフェイス

import com.example.demo.AnimalsAPI.data.AnimalsAPIData;
import com.fasterxml.jackson.databind.ObjectMapper;
//Jacksonライブラリの一部で、JSONデータをJavaオブジェクトに変換するためのクラス ObjectMapperクラスを使用するために必要
//外部APIから取得したJSONデータをJavaのデータモデルクラスの AnimalsAPIDataオブジェクトに変換する際に、ObjectMapperを使用

@Repository
public class AnimalsAPIRepository {
	// 外部APIからデータを取得➨それをJSON形式からJavaオブジェクトに変換➨それを配列として表す

	public AnimalsAPIData[] getAnimalsAPIData() throws IOException { // 外部APIから動物のデータを取得するため
		// [] は配列で複数の AnimalsAPIData オブジェクトを格納出来る(idとかnameとか)
		// ()はこのメソッドが呼び出し可能であることを示してる

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";

		RestTemplate rest = new RestTemplate(); // インスタンスのRestTemplateを作成 外部APIにHTTPリクエストを送信出来る

		ResponseEntity<String> response = rest.getForEntity(url, String.class);
		// URLにGETリクエストをrestで送信し、応答を取得し格納されてる
		// getForEntityは、RestTemplateを使用して指定したURLにGETリクエストを送信し、応答をResponseEntityオブジェクトとして取得するメソッド
		// この部分は外部APIからデータを取得する主要な部分
		// String.class は、応答の本文を文字列として扱えるように

		String json = response.getBody(); // 応答からJSONデータを取得, JSONデータをJavaオブジェクトに変換してる
		// 上のResponseEntityオブジェクトからHTTP応答の本文を取得して、変数jsonに格納(取得したJSONデータが文字列として格納)
		// getBody() メソッドは、HTTP応答の本文を取り出すために使用

		ObjectMapper mapper = new ObjectMapper(); // ObjectMapperを作成
		// JSONデータをJavaオブジェクトに変換するためにObjectMapperインスタンスを作成
		// ObjectMapper は、JSONデータの読み取りと書き込みを行える

		AnimalsAPIData[] animalsList = mapper.readValue(json, AnimalsAPIData[].class); // JSONデータをAnimalsAPIDataの配列にマッピング
		// 上のObjectMapperを使用してJSONデータを AnimalsAPIData クラスの配列にマッピングしてる
		// AnimalsAPIData[] は、マッピングされたデータを格納するための変数の型です。
		// [] は配列で複数の AnimalsAPIData オブジェクトを格納出来る(idとかnameとか)

		return animalsList;
	}

	public AnimalsAPIData[] getSpecificAnimalsAPIData(String animalsId) throws IOException { // 特定の動物の情報を取得するため

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi?id=" + animalsId;

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		AnimalsAPIData[] hitAnimalsList = mapper.readValue(json, AnimalsAPIData[].class);

		return hitAnimalsList;
	}

}