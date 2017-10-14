package com.bignerdranch.android.wordcard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by wuzijian on 2017/10/14.
 */

public class WordFragment extends Fragment {

    private EditText mEditContent;
    private EditText mEditProperty;
    private EditText mEditMeaning;
    private Word mWord;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int word_id = getActivity().getIntent().getIntExtra(WordActivity.EXTRA_WORD_ID, 0);
        mWord = WordLab.get(getActivity()).getWord(word_id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_word, container, false);
        mEditContent = view.findViewById(R.id.word_content);
        mEditProperty = view.findViewById(R.id.word_property);
        mEditMeaning = view.findViewById(R.id.word_meaning);

        mEditContent.setText(mWord.getContent());
        mEditProperty.setText(mWord.getProperty());
        mEditMeaning.setText(mWord.getMeaning());
        return view;
    }

}
