package com.lifeplan.lifeplanapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifePlanGraph3OutgoFragment extends Fragment {

    /**
     * フィールド
     */
    // チャート
    private RadarChart mChart;

    /**
     * コンストラクタ
     */
    public LifePlanGraph3OutgoFragment() {
    }

    /**
     * イベント
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // レイアウトをインストールする
        View view = inflater.inflate(R.layout.fragment_lifeplan_graph3_outgo, container, false);

        // パイチャートを取得
        mChart = view.findViewById(R.id.chartLifePlanGraph3Outgo);

        // 背景色を設定
        mChart.setBackgroundColor(Color.rgb(60, 65, 82));

        // 説明の有無
        mChart.getDescription().setEnabled(false);

        // 中心からの線の幅
        mChart.setWebLineWidth(1f);

        // 中心からの線の色
        mChart.setWebColor(Color.LTGRAY);

        // 線の間の線の幅
        mChart.setWebLineWidthInner(1f);

        // 線の間の線の色
        mChart.setWebColorInner(Color.LTGRAY);

        // 線の透明度を設定(255 = 100％不透明、0 = 100％透明)
        mChart.setWebAlpha(100);

        // マーカービューを生成
        MarkerView mv = new RadarMarkerView(getActivity(), R.layout.radar_markerview);
        //　マーカービューにチャートをセット
        mv.setChartView(mChart); // For bounds control
        //　マーカービューをセット
        mChart.setMarker(mv); // Set the marker to the chart

        // データをセット
        setData();

        // アニメーションをセット
        mChart.animateXY(1400, 1400, Easing.EasingOption.EaseInOutQuad, Easing.EasingOption.EaseInOutQuad);

        // X軸を取得
        XAxis xAxis = mChart.getXAxis();
//        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(9f); // テキストサイズ
        xAxis.setYOffset(0f); // 偏り？
        xAxis.setXOffset(0f); // 偏り？
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] mActivities = new String[]{"基本生活費", "保険料", "住居費", "教育費", "自動車費", "その他"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mActivities[(int) value % mActivities.length];
            }
        });
        xAxis.setTextColor(Color.WHITE); // テキストの色

        // Y軸を取得
        YAxis yAxis = mChart.getYAxis();
//        yAxis.setTypeface(mTfLight);
        yAxis.setLabelCount(5, false); // ラベル数
        yAxis.setTextSize(9f); // テキストサイズ
        yAxis.setAxisMinimum(0f); // 軸の最小値
        yAxis.setAxisMaximum(mChart.getYChartMax()); // 軸の最大値
        yAxis.setDrawLabels(false); // ラベルの表示

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
//        l.setTypeface(mTfLight);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.WHITE);


        // 画面部品ListViewを取得
        ListView listView = view.findViewById(R.id.lvLifePlanGraph3Outgo);

        // カスタムAdapterで使用するListオブジェクトを用意
        ArrayList<LifePlanGraph3OutgoListItem> lifePlanGraph3OutgoListItems = new ArrayList<>();
        // リストアイテムオブジェクトのインスタンスを取得
        // サンプルデータ
        LifePlanGraph3OutgoListItem lifePlanGraph3OutgoListItem = new LifePlanGraph3OutgoListItem();
        lifePlanGraph3OutgoListItem.setId(0);
        lifePlanGraph3OutgoListItem.setKoumoku("基本生活費");
        lifePlanGraph3OutgoListItem.setYouSougaku((float) 50.0);
        lifePlanGraph3OutgoListItem.setAverageSougaku((float) 50.0);
        lifePlanGraph3OutgoListItems.add(lifePlanGraph3OutgoListItem);

        lifePlanGraph3OutgoListItem = new LifePlanGraph3OutgoListItem();
        lifePlanGraph3OutgoListItem.setId(1);
        lifePlanGraph3OutgoListItem.setKoumoku("保険料");
        lifePlanGraph3OutgoListItem.setYouSougaku((float) 3.3);
        lifePlanGraph3OutgoListItem.setAverageSougaku((float) 10.0);
        lifePlanGraph3OutgoListItems.add(lifePlanGraph3OutgoListItem);

        lifePlanGraph3OutgoListItem = new LifePlanGraph3OutgoListItem();
        lifePlanGraph3OutgoListItem.setId(2);
        lifePlanGraph3OutgoListItem.setKoumoku("住居費");
        lifePlanGraph3OutgoListItem.setYouSougaku((float) 23.3);
        lifePlanGraph3OutgoListItem.setAverageSougaku((float) 20.0);
        lifePlanGraph3OutgoListItems.add(lifePlanGraph3OutgoListItem);

        lifePlanGraph3OutgoListItem = new LifePlanGraph3OutgoListItem();
        lifePlanGraph3OutgoListItem.setId(3);
        lifePlanGraph3OutgoListItem.setKoumoku("教育費");
        lifePlanGraph3OutgoListItem.setYouSougaku((float) 6.6);
        lifePlanGraph3OutgoListItem.setAverageSougaku((float) 5.0);
        lifePlanGraph3OutgoListItems.add(lifePlanGraph3OutgoListItem);

        lifePlanGraph3OutgoListItem = new LifePlanGraph3OutgoListItem();
        lifePlanGraph3OutgoListItem.setId(4);
        lifePlanGraph3OutgoListItem.setKoumoku("自動車費");
        lifePlanGraph3OutgoListItem.setYouSougaku((float) 6.6);
        lifePlanGraph3OutgoListItem.setAverageSougaku((float) 5.0);
        lifePlanGraph3OutgoListItems.add(lifePlanGraph3OutgoListItem);

        lifePlanGraph3OutgoListItem = new LifePlanGraph3OutgoListItem();
        lifePlanGraph3OutgoListItem.setId(5);
        lifePlanGraph3OutgoListItem.setKoumoku("その他");
        lifePlanGraph3OutgoListItem.setYouSougaku((float) 10.0);
        lifePlanGraph3OutgoListItem.setAverageSougaku((float) 15.0);
        lifePlanGraph3OutgoListItems.add(lifePlanGraph3OutgoListItem);

        // カスタムAdapterのインスタンスを取得
        LifePlanGraph3OutgoListViewAdapter lifePlanGraph3OutgoListViewAdapter = new LifePlanGraph3OutgoListViewAdapter(getActivity());

        //lifePlanGraph3OutgoListViewAdapter.notifyDataSetChanged();

        // アダプタにリストアイテムオブジェクトをセット
        lifePlanGraph3OutgoListViewAdapter.setLifePlanGraph3List(lifePlanGraph3OutgoListItems);

        // リストビューにアダプタをセット
        listView.setAdapter(lifePlanGraph3OutgoListViewAdapter);

        return view;
    }

    /**
     * メソッド
     */
    public void setData() {

        float mult = 80;
        float min = 20;
        int cnt = 5;

        ArrayList<RadarEntry> entries1 = new ArrayList<RadarEntry>();
        ArrayList<RadarEntry> entries2 = new ArrayList<RadarEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        //for (int i = 0; i < cnt; i++) {
        //    float val1 = (float) (Math.random() * mult) + min;
        //    entries1.add(new RadarEntry(val1));
        //    float val2 = (float) (Math.random() * mult) + min;
        //    entries2.add(new RadarEntry(val2));
        //}

        // サンプルデータ（平均）
        entries1.add(new RadarEntry(50.0f));
        entries1.add(new RadarEntry(10.0f));
        entries1.add(new RadarEntry(20.0f));
        entries1.add(new RadarEntry(5.0f));
        entries1.add(new RadarEntry(5.0f));
        entries1.add(new RadarEntry(15.0f));

        // サンプルデータ
        entries2.add(new RadarEntry(50.0f));
        entries2.add(new RadarEntry(3.3f));
        entries2.add(new RadarEntry(23.3f));
        entries2.add(new RadarEntry(6.6f));
        entries2.add(new RadarEntry(6.6f));
        entries2.add(new RadarEntry(10.0f));

        RadarDataSet set1 = new RadarDataSet(entries1, "平均");
        set1.setColor(Color.rgb(103, 110, 129));
        set1.setFillColor(Color.rgb(103, 110, 129));
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);

        RadarDataSet set2 = new RadarDataSet(entries2, "あなた");
        set2.setColor(Color.rgb(121, 162, 175));
        set2.setFillColor(Color.rgb(121, 162, 175));
        set2.setDrawFilled(true);
        set2.setFillAlpha(180);
        set2.setLineWidth(2f);
        set2.setDrawHighlightCircleEnabled(true);
        set2.setDrawHighlightIndicators(false);

        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);
        sets.add(set2);

        RadarData data = new RadarData(sets);
//        data.setValueTypeface(mTfLight);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);
        mChart.invalidate();
    }

}
