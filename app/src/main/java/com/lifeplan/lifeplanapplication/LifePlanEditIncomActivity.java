package com.lifeplan.lifeplanapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class LifePlanEditIncomActivity extends AppCompatActivity {

    // region フィールド

    // 主キーIDを表すフィールド
    int _id = -1;

    // 家族区分を表すフィールド
    int _kazokuKbn = -1;

    // ニックネームを表すフィールド
    String _name = "";

    // アイコンIDを表すフィールド
    int _iconId = -1;

    // 年齢を表すフィールド
    int _old = -99;

    public static final String EXTRA_ICON_ID
            = "com.lifeplan.lifeplanapplication.EXTRA_ICON_ID";

    static final int RESULT_SUBACTIVITY = 1000;

    // endregion

    // region イベント

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifeplan_edit_kazoku);

        // リスナーをセット
        setListener();

        // アクションバーをセット
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Idを取得
        Intent intent = getIntent();
        _id = intent.getIntExtra(LifePlanEditActivity.EXTRA_KAZOKU_ID, -1);

        // 編集の場合データをセット
        if (_id != -1L) {
            setData();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lifeplan_edit_kazoku, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        boolean result = true;

        switch (id) {

            // 戻る
            case android.R.id.home:
                finish();
                break;
            // 家族情報
            case R.id.tb_delete:
                new AlertDialog.Builder(LifePlanEditIncomActivity.this)
                        .setTitle("削除メッセージ")
                        .setMessage("家族情報を削除します。よろしいですか？")
                        .setPositiveButton("はい", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // データ削除
                                dataDelete();
                            }
                        })
                        .setNegativeButton("いいえ", null)
                        .show();
                break;
            default:
                result = super.onOptionsItemSelected(item);
        }

        return result;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY &&
                null != data) {
            // アイコンをセット
            _iconId = data.getIntExtra(LifePlanEditIncomActivity.EXTRA_ICON_ID, -1);
            ImageView imageView = findViewById(R.id.ivLifePlanEditIcon);
            imageView.setImageResource(_iconId);
        }


    }

    // endregion

    // region メソッド

    // データをセット
    private void setData() {

        // データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(LifePlanEditIncomActivity.this);
        // データベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            // 主キーによる検索SQL文字列の用意
            String sql = "SELECT * FROM lifeplankazoku WHERE id = " + String.valueOf(_id);
            // SQLの実行
            Cursor cursor = db.rawQuery(sql, null);

            // データベース内のデータを取得
            while (cursor.moveToNext()) {
                // カラムのインデックス値を取得
                int idxId = cursor.getColumnIndex("id");
                int idxKazokuKbn = cursor.getColumnIndex("kazokuKbn");
                int idxName = cursor.getColumnIndex("name");
                int idxIconId = cursor.getColumnIndex("iconId");
                int idxOld = cursor.getColumnIndex("old");

                // インデックスをもとに実際の値を取得
                _kazokuKbn = cursor.getInt(idxKazokuKbn);
                _name = cursor.getString(idxName);
                _iconId = cursor.getInt(idxIconId);
                _old = cursor.getInt(idxOld);
            }

            // データベースの値を反映
            // 家族の分類をセット
            Spinner spKazokuKbn = findViewById(R.id.spinnerKazokuKbn);
            spKazokuKbn.setSelection(_kazokuKbn);

            // アイコンをセット
            ImageView ivIcon = findViewById(R.id.ivLifePlanEditIcon);
            ivIcon.setImageResource(_iconId);

            // ニックネームをセット
            EditText edKazokuName = findViewById(R.id.edLifePlanEditKihonKazokuName);
            edKazokuName.setText(_name);

            // 年齢をセット
            EditText edOld = findViewById(R.id.edLifePlanEditKihonSetainusiOld);
            edOld.setText(String.valueOf(_old));

        } finally {
            db.close();
        }
    }

    // リスナーをセット
    private void setListener() {

        // アイコンクリックイベント
        ImageView imageView = findViewById(R.id.ivLifePlanEditIcon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // アイコン選択画面に遷移
                Intent intent = new Intent(LifePlanEditIncomActivity.this, LifePlanEditKazokuIconSelectActivity.class);
                startActivityForResult(intent, RESULT_SUBACTIVITY);
            }
        });

        // ボタンクリックイベントのリスナーをセット
        Button button = findViewById(R.id.btnLifePlanEditKazokuSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSave();
            }
        });

    }

    // データ保存
    private void dataSave() {

        // データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(LifePlanEditIncomActivity.this);

        // データベースヘルパーからデータベース接続オブジェクトを作成
        SQLiteDatabase db = helper.getWritableDatabase();

        try {

            // 新規の場合
            if (_id == -1) {

                // 主キーによる検索SQL文字列の用意
                String sqlSelect = "SELECT MAX(id) maxId FROM lifeplankazoku";
                // SQLの実行
                Cursor cursor = db.rawQuery(sqlSelect, null);
                // データベースから取得した値を格納する変数
                int maxId = -1;
                // データベース内のデータを取得
                while (cursor.moveToNext()) {
                    // カラムのインデックス値を取得
                    int idxMaxId = cursor.getColumnIndex("maxId");

                    // インデックスをもとに実際の値を取得
                    maxId = cursor.getInt(idxMaxId);
                }
                // idを設定
                _id = maxId + 1;
            }

            // リストで選択されたデータを削除
            String sqlDelete = "DELETE FROM lifeplankazoku WHERE id = ?";
            // SQL文字列をもとにプリペアドステートメントを取得
            SQLiteStatement stmt = db.compileStatement(sqlDelete);
            // 変数のバインド
            stmt.bindLong(1, _id);
            // 削除SQLの実行
            stmt.executeUpdateDelete();

            // インサート用SQLの用意
            String sqlInsert = "INSERT INTO lifeplankazoku(id , kazokuKbn , name,iconId, old) VALUES(?,?,?,?,?) ";
            // SQL文字列をもとにプリペアドステートメントを取得
            stmt = db.compileStatement(sqlInsert);

            // 家族区分を取得
            Spinner spKazoku = findViewById(R.id.spinnerKazokuKbn);
            _kazokuKbn = spKazoku.getSelectedItemPosition();

            // ニックネームを取得
            EditText edName = findViewById(R.id.edLifePlanEditKihonKazokuName);
            _name = edName.getText().toString();

            // 年齢を取得
            EditText edOld = findViewById(R.id.edLifePlanEditKihonSetainusiOld);
            _old = Tool.parseInt(edOld.getText().toString(), 0);


            // 変数のバインド
            stmt.bindLong(1, _id);
            stmt.bindLong(2, _kazokuKbn);
            stmt.bindString(3, _name);
            stmt.bindLong(4, _iconId);
            stmt.bindLong(5, _old);

            // 挿入SQLの実行
            stmt.executeInsert();

        } finally {
            // データベースオブジェクトを開放
            db.close();
        }

        // 画面を閉じる
        finish();
    }

    // データ削除
    private void dataDelete() {

        // データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(LifePlanEditIncomActivity.this);

        // データベースヘルパーからデータベース接続オブジェクトを作成
        SQLiteDatabase db = helper.getWritableDatabase();

        try {

            // リストで選択されたデータを削除
            String sqlDelete = "DELETE FROM lifeplankazoku WHERE id = ?";
            // SQL文字列をもとにプリペアドステートメントを取得
            SQLiteStatement stmt = db.compileStatement(sqlDelete);
            // 変数のバインド
            stmt.bindLong(1, _id);
            // 削除SQLの実行
            stmt.executeUpdateDelete();

        } finally {
            // データベースオブジェクトを開放
            db.close();
        }

        // 画面を閉じる
        finish();
    }

    // endregion

}
