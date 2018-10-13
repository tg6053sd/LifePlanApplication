package com.lifeplan.lifeplanapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // データベースファイル名の定数フィールド
    private static final String DATABASE_NAME = "lifeplan.db";

    // バージョン情報の定数フィールド
    private static final int DATABASE_VERSION = 1;

    // コンストラクタ
    public DatabaseHelper(Context context) {
        // 親クラスのコンストラクタの呼び出し
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブル作成用のSQL文字列の作成
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE lifeplankazoku(");
        sb.append("id INTEGER PRIMARY KEY,");
        sb.append("kazokuKbn INTEGER,");
        sb.append("name TEXT,");
        sb.append("iconId INTEGER,");
        sb.append("old INTEGER");
        sb.append(");");
        String sql = sb.toString();

        // SQLの実行
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
