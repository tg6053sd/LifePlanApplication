package com.lifeplan.lifeplanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LifePlanGraph2IncomListViewAdapter extends BaseAdapter {

    /**
     * フィールド
     */
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<LifePlanGraph2IncomListItem> lifePlanGraph2IncomListItems;

    /**
     * コンストラクタ
     */
    public LifePlanGraph2IncomListViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * メソッド
     */
    public void setLifePlanGraph2List(ArrayList<LifePlanGraph2IncomListItem> lifePlanGraph2IncomListItems) {
        this.lifePlanGraph2IncomListItems = lifePlanGraph2IncomListItems;
    }

    /**
     * イベント
     */
    @Override
    public int getCount() {
        return lifePlanGraph2IncomListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lifePlanGraph2IncomListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lifePlanGraph2IncomListItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.fragment_lifeplan_graph2_incom_listview, parent, false);

        ((TextView) convertView.findViewById(R.id.tvKoumoku)).setText(lifePlanGraph2IncomListItems.get(position).getKoumoku().toString());
        ((TextView) convertView.findViewById(R.id.tvWariai)).setText(lifePlanGraph2IncomListItems.get(position).getWariai().toString() + "%");
        ((TextView) convertView.findViewById(R.id.tvSougaku)).setText(lifePlanGraph2IncomListItems.get(position).getSougaku().toString() + "万円");

        return convertView;
    }
}
