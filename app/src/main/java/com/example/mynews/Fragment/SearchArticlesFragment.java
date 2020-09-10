package com.example.mynews.Fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynews.R;
import com.example.mynews.View.SearchArticlesViewModel;

public class SearchArticlesFragment extends Fragment {

    private SearchArticlesViewModel mViewModel;

    public static SearchArticlesFragment newInstance() {
        return new SearchArticlesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_articles, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SearchArticlesViewModel.class);
        // TODO: Use the ViewModel
    }

}