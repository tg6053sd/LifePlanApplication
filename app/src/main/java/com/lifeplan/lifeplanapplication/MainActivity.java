package com.lifeplan.lifeplanapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    // region イベント

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // コンテントビューをセット
        setContentView(R.layout.activity_main);

        // リスナーをセット
        setListener();

        // 初期のフラグメントをセット
        setFragment(R.id.navigation_lifeplan);

    }

    // endregion

    // region メソッド

    // リスナーをセット
    private void setListener() {

        // ボトムナビゲーションのリスナーをセット
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // フラグメントの入れ替え
                switch (item.getItemId()) {
                    case R.id.navigation_lifeplan:
                        setFragment(R.id.navigation_lifeplan);
                        return true;
                    case R.id.navigation_simulation:
                        setFragment(R.id.navigation_simulation);
                        return true;
                    case R.id.navigation_news:
                        setFragment(R.id.navigation_news);
                        return true;
                    case R.id.navigation_other:
                        setFragment(R.id.navigation_other);
                        return true;
                }
                return false;
            }
        });

    }

    // フラグメントの入れ替え
    private void setFragment(int id) {

        // フラグメントトランザクションの開始
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        // メインフレームに乗っているビューをすべて削除
        FrameLayout frameLayout = findViewById(R.id.mainFrame);
        frameLayout.removeAllViews();

        // 呼び出しもとに応じてフラグメントを作成する
        switch (id) {
            case R.id.navigation_lifeplan:
                // ライフプランフラグメントを生成
                LifePlanFragment lifePlanFragment = new LifePlanFragment();
                transaction.add(R.id.mainFrame, lifePlanFragment);
                break;
            case R.id.navigation_simulation:
                // シミュレーションフラグメントを生成
                SimulationFragment simulationFragment = new SimulationFragment();
                transaction.add(R.id.mainFrame, simulationFragment);
                break;
            case R.id.navigation_news:
                // ニュースフラグメントを生成
                NewsFragment newsFragment = new NewsFragment();
                transaction.add(R.id.mainFrame, newsFragment);
                break;
            case R.id.navigation_other:
                // その他フラグメントを生成
                OtherFragment otherFragment = new OtherFragment();
                transaction.add(R.id.mainFrame, otherFragment);
                break;
        }
        // フラグメントトランザクションのコミット
        transaction.commit();
    }

    // endregion
}
