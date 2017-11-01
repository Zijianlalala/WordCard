package com.bignerdranch.android.wordcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by wuzijian on 2017/11/1.
 */

public class WordPagerActivity extends AppCompatActivity {
    private static final String EXTRA_WORD_ID =
            "com.bignerdranch.android.wordcard.word_id";
    private ViewPager mViewPager;
    private List<Word> mWords;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_pager);

        int word_id = getIntent().getIntExtra(EXTRA_WORD_ID, 0);

        mViewPager = (ViewPager) findViewById(R.id.activity_word_view_pager);
        mWords = WordLab.get(this).getWords();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Word word = mWords.get(position);
                return new WordFragment().newInstance(word.getId());
            }

            @Override
            public int getCount() {
                return mWords.size();
            }
        });
        for (int i = 0; i<mWords.size();i++) {
            if (mWords.get(i).getId() == word_id) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newIntent(Context packContext, int id) {
        Intent intent = new Intent(packContext, WordPagerActivity.class);
        intent.putExtra(EXTRA_WORD_ID, id);
        return intent;
    }
}
