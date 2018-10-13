package com.lifeplan.lifeplanapplication;

public class LifePlanGraph3OutgoListItem {

    /**
     * フィールド
     */
    long id;
    private String mKoumoku = null;
    private Float mYouSougaku = null;
    private Float mAverageSougaku = null;

    /**
     * コンストラクタ
     */
    public LifePlanGraph3OutgoListItem() {
    }

    /**
     * プロパティ
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKoumoku(String koumoku) {
        mKoumoku = koumoku;
    }

    public String getKoumoku() {
        return mKoumoku;
    }

    public void setYouSougaku(Float youSougaku) {
        mYouSougaku = youSougaku;
    }

    public Float getYouSougaku() {
        return mYouSougaku;
    }

    public void setAverageSougaku(Float averageSougaku) {
        mAverageSougaku = averageSougaku;
    }

    public Float getAverageSougaku() {
        return mAverageSougaku;
    }


}
