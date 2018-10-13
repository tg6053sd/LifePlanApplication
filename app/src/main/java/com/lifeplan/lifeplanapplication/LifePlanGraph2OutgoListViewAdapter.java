package com.lifeplan.lifeplanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LifePlanGraph2OutgoListViewAdapter extends BaseAdapter {

    /**
     * フィールド
     */
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<LifePlanGraph2OutgoListItem> lifePlanGraph2OutgoListItems;

    /**
     * コンストラクタ
     */
    public LifePlanGraph2OutgoListViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * メソッド
     */
    public void setLifePlanGraph2List(ArrayList<LifePlanGraph2OutgoListItem> lifePlanGraph2OutgoListItems) {
        this.lifePlanGraph2OutgoListItems = lifePlanGraph2OutgoListItems;
    }

    /**
     * イベント
     */
    @Override
    public int getCount() {
        return lifePlanGraph2OutgoListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lifePlanGraph2OutgoListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lifePlanGraph2OutgoListItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.fragment_lifeplan_graph2_outgo_listview, parent, false);

        ((TextView) convertView.findViewById(R.id.tvKoumoku)).setText(lifePlanGraph2OutgoListItems.get(position).getKoumoku().toString());
        ((TextView) convertView.findViewById(R.id.tvWariai)).setText(lifePlanGraph2OutgoListItems.get(position).getWariai().toString() + "%");
        ((TextView) convertView.findViewById(R.id.tvSougaku)).setText(lifePlanGraph2OutgoListItems.get(position).getSougaku().toString() + "万円");

        return convertView;
    }
}
