package com.lifeplan.lifeplanapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class LifePlanEditKazokuIconSelectActivity extends AppCompatActivity {

    // region イベント
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifeplan_edit_kazoku_icon_select);

        // リスナーをセット
        setListener();

        // アクションバーをセット
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
            default:
                result = super.onOptionsItemSelected(item);
        }

        return result;
    }

    // endregion イベント

    // region メソッド

    // 編集画面に戻る
    private void BackEdit(int resouceId) {
        Intent intent = getIntent();
        intent.putExtra(LifePlanEditKazokuActivity.EXTRA_ICON_ID, resouceId);
        setResult(RESULT_OK, intent);
        finish();
    }

    // リスナーをセット
    private void setListener() {

        // アイコンクリックイベント

        ImageView imageViewMan = findViewById(R.id.ivLifePlanEditIconMan);
        imageViewMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.man);
            }
        });

        ImageView imageViewWoman = findViewById(R.id.ivLifePlanEditIconWoman);
        imageViewWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.woman);
            }
        });

        ImageView imageViewBoy = findViewById(R.id.ivLifePlanEditIconBoy);
        imageViewBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.boy);
            }
        });

        ImageView imageViewGirl = findViewById(R.id.ivLifePlanEditIconGirl);
        imageViewGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.girl);
            }
        });

        ImageView imageViewBoy2 = findViewById(R.id.ivLifePlanEditIconBoy2);
        imageViewBoy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.boy2);
            }
        });

        ImageView imageViewGirl2 = findViewById(R.id.ivLifePlanEditIconGirl2);
        imageViewGirl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.girl2);
            }
        });

        ImageView imageViewBabyBoy = findViewById(R.id.ivLifePlanEditIconBabyBoy);
        imageViewBabyBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.baby_boy);
            }
        });

        ImageView imageViewBabyGirl = findViewById(R.id.ivLifePlanEditIconBabyGirl);
        imageViewBabyGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.baby_girl);
            }
        });

        ImageView imageViewGrandFather = findViewById(R.id.ivLifePlanEditIconGrandFather);
        imageViewGrandFather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.grandfather);
            }
        });

        ImageView imageViewGrandMother = findViewById(R.id.ivLifePlanEditIconGrandMother);
        imageViewGrandMother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 編集画面に戻る;
                BackEdit(R.drawable.grandmother);
            }
        });
    }

    // endregion

}
