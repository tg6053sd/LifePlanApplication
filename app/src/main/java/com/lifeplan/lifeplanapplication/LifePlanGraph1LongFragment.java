package com.lifeplan.lifeplanapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifePlanGraph1LongFragment extends Fragment {

    // region フィールド

    // 混合チャート
    private CombinedChart combinedChart;

    // endregion

    // region イベント

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // レイアウトをインストールする
        View view = inflater.inflate(R.layout.fragment_lifeplan_graph1_long, container, false);

        // チャートをセットする
        setCart(view);

        // リストビューをセットする
        setListView(view);

        // ビューを返す
        return view;
    }

    // endregion

    // region メソッド

    // チャートをセット
    private void setCart(View view) {

        // 混合チャートを取得
        combinedChart = view.findViewById(R.id.chartLifePlanGraph1Long);

        combinedChart.getDescription().setEnabled(false);
        // 背景色
        combinedChart.setBackgroundColor(Color.WHITE);
        // 背景のグリッド表示
        combinedChart.setDrawGridBackground(false);
        // 影の表示
        combinedChart.setDrawBarShadow(false);
        // すべてのバーのハイライト可否？
        combinedChart.setHighlightFullBarEnabled(false);

        // 結合対象のチャート
        combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE
        });

        // ?
        Legend l = combinedChart.getLegend();
        // 言葉のラップ？
        l.setWordWrapEnabled(true);
        // 垂直のアライメント
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        // 水平のアライメント
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        // 配置
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        // 内に表示
        l.setDrawInside(false);

        // Y軸（右）
        YAxis rightAxis = combinedChart.getAxisRight();
        // グリッド線の表示
        rightAxis.setDrawGridLines(false);

        // Y軸（左）
        YAxis leftAxis = combinedChart.getAxisLeft();
        // グリッド線の表示
        leftAxis.setDrawGridLines(false);

        // X軸
        XAxis xAxis = combinedChart.getXAxis();
        // 位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        // 粒度
        xAxis.setGranularity(1f);
        // 値のフォーマット
        /**
         xAxis.setValueFormatter(new IAxisValueFormatter() {
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
        return mMonths[(int) value % mMonths.length];
        }
        });*/

        // 結合データのインスタンスを取得
        CombinedData data = new CombinedData();

        // ラインデータをセット
        data.setData(generateLineData());
        // バーデータをセット
        data.setData(generateBarData());

        // データに応じて最大値最小値を変える
        // Y軸（右）の最大値
        rightAxis.setAxisMaximum(data.getYMax() + 100.00f);
        // Y軸（右）の最小値
        rightAxis.setAxisMinimum(data.getYMin() - 100.00f);
        // Y軸（左）の最大値
        leftAxis.setAxisMaximum(data.getYMax() + 100.00f);
        // Y軸（左）の最小値
        leftAxis.setAxisMinimum(data.getYMin() - 100.00f);
        // X軸の最小値
        xAxis.setAxisMinimum(0f);
        // X軸の最大値
        xAxis.setAxisMaximum(data.getXMax() + 0.50f);

        // チャートにデータをセット
        combinedChart.setData(data);

        combinedChart.invalidate();

    }

    // リストビューをセット
    private void setListView(View view) {

        // 画面部品ListViewを取得
        ListView listView = view.findViewById(R.id.lvLifePlanGraph1Long);

        // カスタムAdapterで使用するListオブジェクトを用意
        ArrayList<LifePlanGraph1LongListItem> lifePlanGraph1LongListItems = new ArrayList<>();
        // リストアイテムオブジェクトのインスタンスを取得
        // サンプルデータ
        LifePlanGraph1LongListItem lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(0);
        lifePlanGraph1LongListItem.setNengo(1);
        lifePlanGraph1LongListItem.setYear(2018);
        lifePlanGraph1LongListItem.setOld(32);
        lifePlanGraph1LongListItem.setZandaka(195);
        lifePlanGraph1LongListItem.setShuusi(95);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(1);
        lifePlanGraph1LongListItem.setNengo(2);
        lifePlanGraph1LongListItem.setYear(2019);
        lifePlanGraph1LongListItem.setOld(33);
        lifePlanGraph1LongListItem.setZandaka(293);
        lifePlanGraph1LongListItem.setShuusi(98);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(2);
        lifePlanGraph1LongListItem.setNengo(3);
        lifePlanGraph1LongListItem.setYear(2020);
        lifePlanGraph1LongListItem.setOld(34);
        lifePlanGraph1LongListItem.setZandaka(337);
        lifePlanGraph1LongListItem.setShuusi(44);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(3);
        lifePlanGraph1LongListItem.setNengo(4);
        lifePlanGraph1LongListItem.setYear(2021);
        lifePlanGraph1LongListItem.setOld(35);
        lifePlanGraph1LongListItem.setZandaka(85);
        lifePlanGraph1LongListItem.setShuusi(-252);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(4);
        lifePlanGraph1LongListItem.setNengo(5);
        lifePlanGraph1LongListItem.setYear(2022);
        lifePlanGraph1LongListItem.setOld(36);
        lifePlanGraph1LongListItem.setZandaka(67);
        lifePlanGraph1LongListItem.setShuusi(-18);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(5);
        lifePlanGraph1LongListItem.setNengo(6);
        lifePlanGraph1LongListItem.setYear(2023);
        lifePlanGraph1LongListItem.setOld(37);
        lifePlanGraph1LongListItem.setZandaka(101);
        lifePlanGraph1LongListItem.setShuusi(34);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(6);
        lifePlanGraph1LongListItem.setNengo(7);
        lifePlanGraph1LongListItem.setYear(2024);
        lifePlanGraph1LongListItem.setOld(38);
        lifePlanGraph1LongListItem.setZandaka(203);
        lifePlanGraph1LongListItem.setShuusi(103);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(7);
        lifePlanGraph1LongListItem.setNengo(8);
        lifePlanGraph1LongListItem.setYear(2025);
        lifePlanGraph1LongListItem.setOld(39);
        lifePlanGraph1LongListItem.setZandaka(303);
        lifePlanGraph1LongListItem.setShuusi(99);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(8);
        lifePlanGraph1LongListItem.setNengo(9);
        lifePlanGraph1LongListItem.setYear(2026);
        lifePlanGraph1LongListItem.setOld(40);
        lifePlanGraph1LongListItem.setZandaka(407);
        lifePlanGraph1LongListItem.setShuusi(105);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(9);
        lifePlanGraph1LongListItem.setNengo(10);
        lifePlanGraph1LongListItem.setYear(2027);
        lifePlanGraph1LongListItem.setOld(41);
        lifePlanGraph1LongListItem.setZandaka(159);
        lifePlanGraph1LongListItem.setShuusi(-248);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(10);
        lifePlanGraph1LongListItem.setNengo(11);
        lifePlanGraph1LongListItem.setYear(2028);
        lifePlanGraph1LongListItem.setOld(42);
        lifePlanGraph1LongListItem.setZandaka(268);
        lifePlanGraph1LongListItem.setShuusi(109);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        lifePlanGraph1LongListItem = new LifePlanGraph1LongListItem();
        lifePlanGraph1LongListItem.setId(11);
        lifePlanGraph1LongListItem.setNengo(12);
        lifePlanGraph1LongListItem.setYear(2029);
        lifePlanGraph1LongListItem.setOld(43);
        lifePlanGraph1LongListItem.setZandaka(379);
        lifePlanGraph1LongListItem.setShuusi(111);
        lifePlanGraph1LongListItems.add(lifePlanGraph1LongListItem);

        // カスタムAdapterのインスタンスを取得
        LifePlanGraph1LongListViewAdapter lifePlanGraph1LongListViewAdapter = new LifePlanGraph1LongListViewAdapter(getActivity());

        //lifePlanGraph1LongListViewAdapter.notifyDataSetChanged();

        // アダプタにリストアイテムオブジェクトをセット
        lifePlanGraph1LongListViewAdapter.setLifePlanGraph1List(lifePlanGraph1LongListItems);

        // リストビューにアダプタをセット
        listView.setAdapter(lifePlanGraph1LongListViewAdapter);

    }

    // endregion

    // region インナークラス

    // 折れ線グラフ
    private LineData generateLineData() {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<Entry>();

        // サンプルデータ
        entries.add(new BarEntry(1f, 195f));
        entries.add(new BarEntry(2f, 293f));
        entries.add(new BarEntry(3f, 337f));
        entries.add(new BarEntry(4f, 85f));
        entries.add(new BarEntry(5f, 67f));
        entries.add(new BarEntry(6f, 101f));
        entries.add(new BarEntry(7f, 203f));
        entries.add(new BarEntry(8f, 303f));
        entries.add(new BarEntry(9f, 407f));
        entries.add(new BarEntry(10f, 159f));
        entries.add(new BarEntry(11f, 268f));
        entries.add(new BarEntry(12f, 379f));

        LineDataSet set = new LineDataSet(entries, "金融資産残高");
        set.setColor(Color.rgb(240, 238, 70));
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return d;
    }

    // 棒グラフ
    private BarData generateBarData() {

        ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();

        // サンプルデータ
        entries1.add(new BarEntry(1f, 95f));
        entries1.add(new BarEntry(2f, 98f));
        entries1.add(new BarEntry(3f, 44f));
        entries1.add(new BarEntry(4f, -252f));
        entries1.add(new BarEntry(5f, -18f));
        entries1.add(new BarEntry(6f, 34f));
        entries1.add(new BarEntry(7f, 103f));
        entries1.add(new BarEntry(8f, 99f));
        entries1.add(new BarEntry(9f, 105f));
        entries1.add(new BarEntry(10f, -248f));
        entries1.add(new BarEntry(11f, 109f));
        entries1.add(new BarEntry(12f, 111f));

        BarDataSet set1 = new BarDataSet(entries1, "年間収支");
        set1.setColor(Color.rgb(60, 220, 78));
        set1.setValueTextColor(Color.rgb(60, 220, 78));
        set1.setValueTextSize(10f);

        BarData d = new BarData(set1);
        d.setBarWidth(0.9f);

        return d;
    }

    // endregion
}
