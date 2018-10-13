package com.lifeplan.lifeplanapplication;

public class LifePlanEditKazokuListItem {

    /**
     * フィールド
     */
    int id;
    private Integer mIconId;
    private String mKazokuName = "";
    private Integer mOld;

    /**
     * コンストラクタ
     */
    public LifePlanEditKazokuListItem() {
    }

    /**
     * プロパティ
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIconId(Integer iconId) {
        mIconId = iconId;
    }
    public Integer getIconId() {
        return mIconId;
    }

    public void setKazokuName(String kazokuName) {
        mKazokuName = kazokuName;
    }
    public String getKazokuName() {
        return mKazokuName;
    }

    public void setOld(Integer old) {
        mOld = old;
    }
    public Integer getOld() {
        return mOld;
    }
}
