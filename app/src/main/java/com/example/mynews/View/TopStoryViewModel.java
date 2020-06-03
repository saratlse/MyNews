package com.example.mynews.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TopStoryViewModel extends ViewModel {

    public MutableLiveData<List<ItemByArticle>> itemByArticleList = new MutableLiveData<>();
    private final LiveData<List<ItemByArticle>> mList = Transformations.map(this.itemByArticleList, input -> input);

    public void setItemByArticle(final List<ItemByArticle> article) {
        this.itemByArticleList.setValue(article);
    }

    public LiveData<List<ItemByArticle>> getList() {
        return this.mList;
    }
}
