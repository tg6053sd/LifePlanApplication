package com.lifeplan.lifeplanapplication;

public class LifePlanGraph1LongListItem {

    /**
     * フィールド
     */
    long id;
    private Integer mNengo = null;
    private Integer mYear = null;
    private Integer mOld = null;
    private Integer mZandaka = null;
    private Integer mShuusi = null;

    /**
     * コンストラクタ
     */
    public LifePlanGraph1LongListItem() {
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

    public void setNengo(Integer nengo) {
        mNengo = nengo;
    }
    public Integer getNengo() {
        return mNengo;
    }

    public void setYear(Integer year) {
        mYear = year;
    }
    public Integer getYear() {
        return mYear;
    }

    public void setOld(Integer old) {
        mOld = old;
    }
    public Integer getOld() {
        return mOld;
    }

    public void setZandaka(Integer zandaka) {
        mZandaka = zandaka;
    }
    public Integer getZandaka() {
        return mZandaka;
    }

    public void setShuusi(Integer shuusi) {
        mShuusi = shuusi;
    }
    public Integer getShuusi() {
        return mShuusi;
    }

}
