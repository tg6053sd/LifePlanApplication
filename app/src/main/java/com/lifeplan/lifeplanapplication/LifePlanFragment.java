package com.lifeplan.lifeplanapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LifePlanFragment extends Fragment {

    // region イベント

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // レイアウトをインストールする
        View view = inflater.inflate(R.layout.fragment_lifeplan, container, false);

        // ビューページャーをセット
        setViewPager(view);

        // リスナーをセット
        setListener(view);

        // ビューを返す
        return view;
    }

    // endregion

    // region メソッド

    // ビューページャーをセット
    private void setViewPager(View view) {

        // セクションページアダプタのインスタンスを取得
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // ビューページャーを取得してセクションページアダプタをセット
        ViewPager viewPager = view.findViewById(R.id.vpLifePlan);
        viewPager.setAdapter(sectionsPagerAdapter);

    }


    // リスナーをセット
    private void setListener(View view) {

        // フローティングアクションボタンのリスナーをセット
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fabLifePlan);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // インテントの作成
                Intent intent = new Intent(getActivity(), LifePlanEditActivity.class);
                // 基本情報編集画面に遷移
                startActivity(intent);
            }
        });

    }

    // endregion

    // region インナークラス

    // セクションページアダプタクラス
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            // ページの切り替え
            switch (position) {
                case 0:
                    return new LifePlanGraph1LongFragment();
                case 1:
                    return new LifePlanGraph2IncomFragment();
                case 2:
                    return new LifePlanGraph2OutgoFragment();
                case 3:
                    return new LifePlanGraph3IncomFragment();
                case 4:
                    return new LifePlanGraph3OutgoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }
    }

    // endregion
}
