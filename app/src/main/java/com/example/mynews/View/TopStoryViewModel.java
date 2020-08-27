package com.example.mynews.View;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TopStoryViewModel extends ViewModel {

    public MutableLiveData<List<Articles>> mItemByArticleList = new MutableLiveData<>();
    private final LiveData<List<Articles>> mList = Transformations.map(this.mItemByArticleList, new Function<List<Articles>, List<Articles>>() {
        @Override
        public List<Articles> apply(List<Articles> input) {
            return input;
        }
    });


    public void setItemByArticle(final List<Articles> article) {
        this.mItemByArticleList.setValue(article);
    }

    public LiveData<List<Articles>> getList() {
        return this.mItemByArticleList;
    }
}
