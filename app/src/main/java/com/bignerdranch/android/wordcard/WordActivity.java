package com.bignerdranch.android.wordcard;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by wuzijian on 2017/10/14.
 */

public class WordActivity extends SingleFragmentActivity {
    public static final String EXTRA_WORD_ID =
            "com.bignerdranch.android.wordcard.word_id";

    @Override
    protected Fragment createFragment() {
        return new WordFragment();
    }

    public static Intent newIntent(Context packContext, int id) {
        Intent intent = new Intent(packContext, WordActivity.class);
        intent.putExtra(EXTRA_WORD_ID, id);
        return intent;
    }
}
