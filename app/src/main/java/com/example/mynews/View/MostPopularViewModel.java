package com.example.mynews.View;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MostPopularViewModel extends ViewModel {
    private final MutableLiveData<List<Articles>> mItemByArticle = new MutableLiveData<>();
    private final LiveData<List<Articles>> mList = Transformations.map(this.mItemByArticle, new Function<List<Articles>, List<Articles>>() {
        @Override
        public List<Articles> apply(final List<Articles> input) {
            return input;
        }
    });


    public void setItemByArticle(final List<Articles> articles) {
        this.mItemByArticle.setValue(articles);
    }

    public LiveData<List<Articles>> getList() {
        return this.mList;
    }
}
