package com.lifeplan.lifeplanapplication;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class LifePlanEditKazokuFragment extends Fragment {

    // region フィールド

    View view;

    // endregion

    // region イベント

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // レイアウトをインストールする
        view = inflater.inflate(R.layout.fragment_lifeplan_edit_kazoku, container, false);

        // onResumeに移す
        // リストビューをセットする
        //setListView(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // リストビューをセットする
        setListView(view);

    }

    // endregion

    // region メソッド

    // リストビューをセット
    private void setListView(View view) {

        // リストビューを取得
        ListView listView = view.findViewById(R.id.lvLifePlanEditKazoku);

        // リスナーをセット
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // 選択行のリストを取得
                LifePlanEditKazokuListItem item = (LifePlanEditKazokuListItem) parent.getItemAtPosition(position);
                // IDを取得
                int extra_id = item.getId();

                // 編集画面へ遷移
                Intent intent = new Intent(getActivity(), LifePlanEditKazokuActivity.class);
                intent.putExtra(LifePlanEditActivity.EXTRA_KAZOKU_ID, extra_id);
                startActivity(intent);
            }
        });

        // カスタムAdapterで使用するListオブジェクトを用意
        ArrayList<LifePlanEditKazokuListItem> lifePlanEditKazokuListItems = new ArrayList<>();

        // リストアイテムオブジェクトのインスタンスを取得
        LifePlanEditKazokuListItem lifePlanEditKazokuListItem = new LifePlanEditKazokuListItem();

        // データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(getActivity());

        // データベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            // 主キーによる検索SQL文字列の用意
            String sql = "SELECT * FROM lifeplankazoku";

            // SQLの実行
            Cursor cursor = db.rawQuery(sql, null);

            // データベースから取得した値を格納する変数
            int id = -1;
            int iconId = -1;
            String name = "";
            int old = -99;

            // データベース内のデータを取得
            while (cursor.moveToNext()) {
                // カラムのインデックス値を取得
                int idxId = cursor.getColumnIndex("id");
                int idxName = cursor.getColumnIndex("name");
                int idxIconId = cursor.getColumnIndex("iconId");
                int idxOld = cursor.getColumnIndex("old");

                // インデックスをもとに実際の値を取得
                id = cursor.getInt(idxId);
                iconId = cursor.getInt(idxIconId);
                name = cursor.getString(idxName);
                old = cursor.getInt(idxOld);

                lifePlanEditKazokuListItem = new LifePlanEditKazokuListItem();
                lifePlanEditKazokuListItem.setId(id);
                lifePlanEditKazokuListItem.setIconId(iconId);
                lifePlanEditKazokuListItem.setKazokuName(name);
                lifePlanEditKazokuListItem.setOld(old);
                lifePlanEditKazokuListItems.add(lifePlanEditKazokuListItem);
            }

        } finally {
            db.close();
        }

        // カスタムAdapterのインスタンスを取得
        LifePlanEditKazokuListViewAdapter lifePlanEditKazokuListViewAdapter = new LifePlanEditKazokuListViewAdapter(getActivity());

        // アダプタにリストアイテムオブジェクトをセット
        lifePlanEditKazokuListViewAdapter.setLifePlanEditKazokuList(lifePlanEditKazokuListItems);

        // リストビューにアダプタをセット
        listView.setAdapter(lifePlanEditKazokuListViewAdapter);
    }

    // endregion

}
