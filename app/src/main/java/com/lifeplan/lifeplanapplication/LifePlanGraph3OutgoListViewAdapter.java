package com.lifeplan.lifeplanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LifePlanGraph3OutgoListViewAdapter extends BaseAdapter {

    /**
     * フィールド
     */
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<LifePlanGraph3OutgoListItem> lifePlanGraph3OutgoListItems;

    /**
     * コンストラクタ
     */
    public LifePlanGraph3OutgoListViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * メソッド
     */
    public void setLifePlanGraph3List(ArrayList<LifePlanGraph3OutgoListItem> lifePlanGraph3OutgoListItems) {
        this.lifePlanGraph3OutgoListItems = lifePlanGraph3OutgoListItems;
    }

    /**
     * イベント
     */
    @Override
    public int getCount() {
        return lifePlanGraph3OutgoListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lifePlanGraph3OutgoListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lifePlanGraph3OutgoListItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.fragment_lifeplan_graph3_outgo_listview, parent, false);

        ((TextView) convertView.findViewById(R.id.tvKoumoku)).setText(lifePlanGraph3OutgoListItems.get(position).getKoumoku().toString());
        ((TextView) convertView.findViewById(R.id.tvYouSougaku)).setText(lifePlanGraph3OutgoListItems.get(position).getYouSougaku().toString() + "%");
        ((TextView) convertView.findViewById(R.id.tvAverageSougaku)).setText(lifePlanGraph3OutgoListItems.get(position).getAverageSougaku().toString() + "%");

        return convertView;
    }
}
