package com.lifeplan.lifeplanapplication;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifePlanGraph2IncomFragment extends Fragment {

    /**
     * フィールド
     */
    // チャート
    private PieChart mChart;

    /**
     * コンストラクタ
     */
    public LifePlanGraph2IncomFragment() {
    }

    /**
     * イベント
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // レイアウトをインストールする
        View view = inflater.inflate(R.layout.fragment_lifeplan_graph2_incom, container, false);

        // パイチャートを取得
        mChart = view.findViewById(R.id.chartLifePlanGraph2Incom);

        // パーセント値
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        //mChart.setCenterTextTypeface(mTfLight);
        mChart.setCenterText(generateCenterSpannableText());

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(false);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        // mChart.setOnChartValueSelectedListener(this);

        setData(5, 100);

        //mChart.animateY(1400, Easing.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mChart.setEntryLabelColor(Color.WHITE);
        //mChart.setEntryLabelTypeface(mTfRegular);
        mChart.setEntryLabelTextSize(12f);


        // 画面部品ListViewを取得
        ListView listView = view.findViewById(R.id.lvLifePlanGraph2Incom);

        // カスタムAdapterで使用するListオブジェクトを用意
        ArrayList<LifePlanGraph2IncomListItem> lifePlanGraph2IncomListItems = new ArrayList<>();
        // リストアイテムオブジェクトのインスタンスを取得
        // サンプルデータ
        LifePlanGraph2IncomListItem lifePlanGraph2IncomListItem = new LifePlanGraph2IncomListItem();
        lifePlanGraph2IncomListItem.setId(0);
        lifePlanGraph2IncomListItem.setKoumoku("本業収入");
        lifePlanGraph2IncomListItem.setWariai((float) 60.0);
        lifePlanGraph2IncomListItem.setSougaku(20000);
        lifePlanGraph2IncomListItems.add(lifePlanGraph2IncomListItem);

        lifePlanGraph2IncomListItem = new LifePlanGraph2IncomListItem();
        lifePlanGraph2IncomListItem.setId(1);
        lifePlanGraph2IncomListItem.setKoumoku("年金");
        lifePlanGraph2IncomListItem.setWariai((float) 20.0);
        lifePlanGraph2IncomListItem.setSougaku(6000);
        lifePlanGraph2IncomListItems.add(lifePlanGraph2IncomListItem);

        lifePlanGraph2IncomListItem = new LifePlanGraph2IncomListItem();
        lifePlanGraph2IncomListItem.setId(2);
        lifePlanGraph2IncomListItem.setKoumoku("不動産収入");
        lifePlanGraph2IncomListItem.setWariai((float) 10.0);
        lifePlanGraph2IncomListItem.setSougaku(3000);
        lifePlanGraph2IncomListItems.add(lifePlanGraph2IncomListItem);

        lifePlanGraph2IncomListItem = new LifePlanGraph2IncomListItem();
        lifePlanGraph2IncomListItem.setId(3);
        lifePlanGraph2IncomListItem.setKoumoku("株・為替収入");
        lifePlanGraph2IncomListItem.setWariai((float) 5.0);
        lifePlanGraph2IncomListItem.setSougaku(1500);
        lifePlanGraph2IncomListItems.add(lifePlanGraph2IncomListItem);

        lifePlanGraph2IncomListItem = new LifePlanGraph2IncomListItem();
        lifePlanGraph2IncomListItem.setId(4);
        lifePlanGraph2IncomListItem.setKoumoku("その他収入");
        lifePlanGraph2IncomListItem.setWariai((float) 5.0);
        lifePlanGraph2IncomListItem.setSougaku(1500);
        lifePlanGraph2IncomListItems.add(lifePlanGraph2IncomListItem);

        // カスタムAdapterのインスタンスを取得
        LifePlanGraph2IncomListViewAdapter lifePlanGraph2IncomListViewAdapter = new LifePlanGraph2IncomListViewAdapter(getActivity());

        //lifePlanGraph2IncomListViewAdapter.notifyDataSetChanged();

        // アダプタにリストアイテムオブジェクトをセット
        lifePlanGraph2IncomListViewAdapter.setLifePlanGraph2List(lifePlanGraph2IncomListItems);

        // リストビューにアダプタをセット
        listView.setAdapter(lifePlanGraph2IncomListViewAdapter);

        // ビューを返す
        return view;
    }

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        //for (int i = 0; i < count ; i++) {
        //entries.add(new PieEntry((float) ((Math.random() * mult) + mult / 5),
        //        mParties[i % mParties.length],
        //        getResources().getDrawable(R.drawable.star)));
        //}
        entries.add(new PieEntry((float) 60.0, "本業収入"));
        entries.add(new PieEntry((float) 20.0, "年金"));
        entries.add(new PieEntry((float) 10.0, "不動産収入"));
        entries.add(new PieEntry((float) 5.0, "株・為替収入"));
        entries.add(new PieEntry((float) 5.0, "その他収入"));

        PieDataSet dataSet = new PieDataSet(entries, "収入項目");

        // アイコンのセット
        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        //data.setValueTypeface(mTfLight);
        mChart.setData(data);

        // グラフ中のラベルの表示
        mChart.setDrawEntryLabels(false);
        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }
}
