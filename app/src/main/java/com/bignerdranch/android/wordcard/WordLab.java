package com.bignerdranch.android.wordcard;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * Created by wuzijian on 2017/10/14.
 */

public class WordLab {
    private static WordLab sWordLab;
    private Context mContext;

    private WordLab(Context context) {
        mContext = context.getApplicationContext();
    }

    public static WordLab get(Context context) {
        if (sWordLab == null) {
            sWordLab = new WordLab(context);
        }
        return sWordLab;
    }

    public  List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Word word = new Word();
            word.setId(i);
            word.setContent("Apple " + i);
            word.setProperty("noun.");
            word.setDate(new Date(System.currentTimeMillis()));
            word.setMeaning("苹果");
            words.add(word);
        }
        return words;
    }

    public Word getWord(int id) {
        return sWordLab.getWords().get(id);
    }



}
