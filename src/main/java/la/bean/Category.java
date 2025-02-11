package la.bean;

import java.io.Serializable;

public class Category implements Serializable {
	//フィールド
	private int code; //カテゴリー・コード
	private String name; //カテゴリー名

	//コンストラクタ
	public Category() {

	}

	public Category(int code, String name) {
		this.code = code;
		this.name = name;
	}

	//アクセッサ・メソッド（セッタ＆ゲッタ）
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
