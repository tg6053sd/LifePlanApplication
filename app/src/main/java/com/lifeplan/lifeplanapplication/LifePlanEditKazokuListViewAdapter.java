package com.lifeplan.lifeplanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LifePlanEditKazokuListViewAdapter extends BaseAdapter {

    /**
     * フィールド
     */
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<LifePlanEditKazokuListItem> lifePlanEditKazokuListItems;

    /**
     * コンストラクタ
     */
    public LifePlanEditKazokuListViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * メソッド
     */
    public void setLifePlanEditKazokuList(ArrayList<LifePlanEditKazokuListItem> lifePlanEditKazokuListItems) {
        this.lifePlanEditKazokuListItems = lifePlanEditKazokuListItems;
    }

    /**
     * イベント
     */
    @Override
    public int getCount() {
        return lifePlanEditKazokuListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return lifePlanEditKazokuListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lifePlanEditKazokuListItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.fragment_lifeplan_edit_kazoku_listview, parent, false);

        ((ImageView) convertView.findViewById(R.id.ivKazokuListIcon)).setImageResource (lifePlanEditKazokuListItems.get(position).getIconId());
        ((TextView) convertView.findViewById(R.id.tvKazokuName)).setText(lifePlanEditKazokuListItems.get(position).getKazokuName());
        ((TextView) convertView.findViewById(R.id.tvKazokuOld)).setText(lifePlanEditKazokuListItems.get(position).getOld().toString());

        return convertView;
    }
}
