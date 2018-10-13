package com.lifeplan.lifeplanapplication;

public class LifePlanGraph2IncomListItem {

    /**
     * フィールド
     */
    long id;
    private String mKoumoku = null;
    private Float mWariai = null;
    private Integer mSougaku = null;

    /**
     * コンストラクタ
     */
    public LifePlanGraph2IncomListItem() {
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

    public void setWariai(Float wariai) {
        mWariai = wariai;
    }

    public Float getWariai() {
        return mWariai;
    }

    public void setSougaku(Integer sougaku) {
        mSougaku = sougaku;
    }

    public Integer getSougaku() {
        return mSougaku;
    }

}
