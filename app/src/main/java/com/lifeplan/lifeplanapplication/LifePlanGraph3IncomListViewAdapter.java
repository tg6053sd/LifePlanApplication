package com.lifeplan.lifeplanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LifePlanGraph3IncomListViewAdapter extends BaseAdapter {

    /**
     * フィールド
     */
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<LifePlanGraph3IncomListItem> lifePlanGraph3IncomListItems;

    /**
     * コンストラクタ
     */
    public LifePlanGraph3IncomListViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * メソッド
     */
    public void setLifePlanGraph3List(ArrayList<LifePlanGraph3IncomListItem> lifePlanGraph3IncomListItems) {
        this.lifePlanGraph3IncomListItems = lifePlanGraph3IncomListItems;
    }

    /**
     * イベント
     */
    @Override
    public int getCount() {
        return lifePlanGraph3IncomListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lifePlanGraph3IncomListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lifePlanGraph3IncomListItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.fragment_lifeplan_graph3_incom_listview, parent, false);

        ((TextView) convertView.findViewById(R.id.tvKoumoku)).setText(lifePlanGraph3IncomListItems.get(position).getKoumoku().toString());
        ((TextView) convertView.findViewById(R.id.tvYouSougaku)).setText(lifePlanGraph3IncomListItems.get(position).getYouSougaku().toString() + "%");
        ((TextView) convertView.findViewById(R.id.tvAverageSougaku)).setText(lifePlanGraph3IncomListItems.get(position).getAverageSougaku().toString() + "%");

        return convertView;
    }
}
