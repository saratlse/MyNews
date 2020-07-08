package com.example.mynews.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TopStoryViewModel extends ViewModel {

    public MutableLiveData<List<Articles>> itemByArticleList = new MutableLiveData<>();
    private final LiveData<List<Articles>> mList = Transformations.map(this.itemByArticleList, input -> input);

    public void setItemByArticle(final List<Articles> article) {
        this.itemByArticleList.setValue(article);
    }

    public LiveData<List<Articles>> getList() {
        return this.mList;
    }
}
