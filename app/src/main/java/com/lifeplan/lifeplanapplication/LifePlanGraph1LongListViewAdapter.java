package com.lifeplan.lifeplanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LifePlanGraph1LongListViewAdapter extends BaseAdapter {

    /**
     * フィールド
     */
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<LifePlanGraph1LongListItem> lifePlanGraph1LongListItems;

    /**
     * コンストラクタ
     */
    public LifePlanGraph1LongListViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * メソッド
     */
    public void setLifePlanGraph1List(ArrayList<LifePlanGraph1LongListItem> lifePlanGraph1LongListItems) {
        this.lifePlanGraph1LongListItems = lifePlanGraph1LongListItems;
    }

    /**
     * イベント
     */
    @Override
    public int getCount() {
        return lifePlanGraph1LongListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lifePlanGraph1LongListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lifePlanGraph1LongListItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.fragment_lifeplan_graph1_long_listview, parent, false);

        ((TextView) convertView.findViewById(R.id.tvNengo)).setText(lifePlanGraph1LongListItems.get(position).getNengo().toString() + "年後");
        ((TextView) convertView.findViewById(R.id.tvYear)).setText(lifePlanGraph1LongListItems.get(position).getYear().toString() + "年");
        ((TextView) convertView.findViewById(R.id.tvOld)).setText(lifePlanGraph1LongListItems.get(position).getOld().toString() + "歳");
        ((TextView) convertView.findViewById(R.id.tvZandaka)).setText("残高：" + lifePlanGraph1LongListItems.get(position).getZandaka().toString() + "万円");
        ((TextView) convertView.findViewById(R.id.tvShuusi)).setText("収支：" + lifePlanGraph1LongListItems.get(position).getShuusi().toString() + "万円");

        return convertView;
    }
}
