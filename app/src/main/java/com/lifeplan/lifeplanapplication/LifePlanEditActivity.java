package com.lifeplan.lifeplanapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class LifePlanEditActivity extends AppCompatActivity {

    // region フィールド

    // 現在のナビゲーション
    int currentNavigationId;

    // インテント用変数名
    public static final String EXTRA_KAZOKU_ID
            = "com.lifeplan.lifeplanapplication.EXTRA_KAZOKU_ID";

    // endregion

    // region イベント

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lifeplan_edit);

        // アクションバーをセット
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // リスナーをセット
        setListener();

        // 初期のフラグメントをセット
        setFragment(R.id.navigation_kazoku);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lifeplan_edit, menu);
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
            // 追加
            case R.id.tb_add:
                switch (currentNavigationId) {
                    // 家族情報
                    case R.id.navigation_kazoku:
                        // 編集画面へ遷移
                        Intent intentAdd = new Intent(this, LifePlanEditKazokuActivity.class);
                        intentAdd.putExtra(EXTRA_KAZOKU_ID, -1);
                        startActivity(intentAdd);
                }
                break;
            default:
                result = super.onOptionsItemSelected(item);
        }

        return result;
    }

    // endregion

    // region メソッド

    // リスナーをセット
    private void setListener() {
        // ボトムナビゲーションを取得してリスナーをセット
        BottomNavigationView navigation = findViewById(R.id.bottomNavigationLifePlanEdit);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // フラグメントの入れ替え
                switch (item.getItemId()) {
                    case R.id.navigation_kazoku:
                        setFragment(R.id.navigation_kazoku);
                        return true;
                    case R.id.navigation_incom:
                        setFragment(R.id.navigation_incom);
                        return true;
                    case R.id.navigation_outgo:
                        setFragment(R.id.navigation_outgo);
                        return true;
                    case R.id.navigation_zandaka:
                        setFragment(R.id.navigation_zandaka);
                        return true;
                }
                return false;
            }
        });
    }

    // フラグメントの入れ替えメソッド
    private void setFragment(int id) {
        // フラグメントトランザクションの開始
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        // メインフレームに乗っているビューをすべて削除
        FrameLayout frameLayout = findViewById(R.id.lifePlanEditFrame);
        frameLayout.removeAllViews();

        // 呼び出しもとに応じてフラグメントを作成する
        switch (id) {
            case R.id.navigation_kazoku:
                // 家族フラグメントを生成
                LifePlanEditKazokuFragment lifePlanEditKazokuFragment = new LifePlanEditKazokuFragment();
                transaction.add(R.id.lifePlanEditFrame, lifePlanEditKazokuFragment);
                currentNavigationId = R.id.navigation_kazoku;
                break;
            case R.id.navigation_incom:
                // 収入フラグメントを生成
                LifePlanEditIncomFragment lifePlanEditIncomFragment = new LifePlanEditIncomFragment();
                transaction.add(R.id.lifePlanEditFrame, lifePlanEditIncomFragment);
                currentNavigationId = R.id.navigation_incom;
                break;
            case R.id.navigation_outgo:
                // 支出フラグメントを生成
                LifePlanEditOutgoFragment lifePlanEditOutgoFragment = new LifePlanEditOutgoFragment();
                transaction.add(R.id.lifePlanEditFrame, lifePlanEditOutgoFragment);
                currentNavigationId = R.id.navigation_outgo;
                break;
            case R.id.navigation_zandaka:
                // 残高フラグメントを生成
                LifePlanEditZandakaFragment lifePlanEditZandakaFragment = new LifePlanEditZandakaFragment();
                transaction.add(R.id.lifePlanEditFrame, lifePlanEditZandakaFragment);
                currentNavigationId = R.id.navigation_zandaka;
                break;
        }
        // フラグメントトランザクションのコミット
        transaction.commit();
    }

    // endregion

}
