package com.bignerdranch.android.wordcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wuzijian on 2017/10/14.
 */

public class WordListFragment extends Fragment {
    private static final String TAG = "WordListFragment";

    private RecyclerView mRecyclerView;
    private WordAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_list, container, false);
        mRecyclerView = view.findViewById(R.id.word_list_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        WordLab wordLab = WordLab.get(getActivity());
        List<Word> words = wordLab.getWords();

        if (mAdapter == null) {
            mAdapter = new WordAdapter(words);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            //更新快照
            mAdapter.notifyDataSetChanged();
        }

    }

    private class WordHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mWordText;
        private TextView mDateText;
        private TextView mPropertyText;
        private Word mWord;
        public WordHolder(View itemView) {
            super(itemView);
            mWordText = itemView.findViewById(R.id.list_item_word);
            mPropertyText = itemView.findViewById(R.id.list_item_property);
            mDateText = itemView.findViewById(R.id.list_item_date);
            itemView.setOnClickListener(this);

        }
        public void bindWord(Word word) {
            mWord = word;
            mWordText.setText(word.getContent());
            mPropertyText.setText(word.getProperty());
            CharSequence dateFormat = android.text.format.DateFormat.format(
                    "E, M d, y",
                    word.getDate()
            );
            mDateText.setText(dateFormat);
        }

        @Override
        public void onClick(View view) {
            //跳转到单词页面
            Intent intent = WordActivity.newIntent(getActivity(), mWord.getId());
            startActivity(intent);
        }
    }

    private class WordAdapter extends RecyclerView.Adapter<WordHolder> {
        private List<Word> mWords;

        public WordAdapter(List<Word> words) {
            mWords = words;
        }

        @Override
        public WordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(
                    R.layout.list_item_word,
                    parent,
                    false
            );
            return new WordHolder(view);
        }

        @Override
        public void onBindViewHolder(WordHolder holder, int position) {
            Word word = mWords.get(position);
            holder.bindWord(word);
        }

        @Override
        public int getItemCount() {
            return mWords.size();
        }
    }


}
