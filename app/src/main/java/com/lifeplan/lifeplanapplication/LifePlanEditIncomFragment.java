package com.lifeplan.lifeplanapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifePlanEditIncomFragment extends Fragment {


    public LifePlanEditIncomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // レイアウトをインストールする
        View view = inflater.inflate(R.layout.fragment_lifeplan_edit_incom, container, false);

        // リストビューを取得
        ListView listView = view.findViewById(R.id.lvLifePlanEditIncom);
        // Listオブジェクトを用意
        List<Map<String,String>> list = new ArrayList<>();

        // SimpleAdapter第4引数from用データの用意
        String[] from = {"who","himoku"};
        // SimpleAdapter第5引数to用データの用意
        int[] to = {android.R.id.text1,android.R.id.text2};
        // SimpleAdapterを生成
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),list,android.R.layout.simple_list_item_2,from,to);
        // アダプタの登録
        listView.setAdapter(adapter);

        return view;
    }
}
