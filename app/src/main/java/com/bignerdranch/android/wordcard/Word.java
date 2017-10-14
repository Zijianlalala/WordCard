package com.bignerdranch.android.wordcard;

import java.util.Date;
import java.util.UUID;

/**
 * Created by wuzijian on 2017/10/14.
 */

public class Word {
    private int mId;
    private String mContent;
    private String mProperty;
    private Date mDate;
    private String mMeaning;

    public Word() {}

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getProperty() {
        return mProperty;
    }

    public void setProperty(String property) {
        mProperty = property;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getMeaning() {
        return mMeaning;
    }

    public void setMeaning(String meaning) {
        mMeaning = meaning;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
