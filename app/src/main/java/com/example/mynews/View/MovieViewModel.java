package com.example.mynews.View;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private final MutableLiveData<List<ItemByArticle>> mItemByArticle = new MutableLiveData<>();
    private final LiveData<List<ItemByArticle>> mList = Transformations.map(this.mItemByArticle, new Function<List<ItemByArticle>, List<ItemByArticle>>() {
        @Override
        public List<ItemByArticle> apply(final List<ItemByArticle> input) {
            return input;
        }
    });


    public void setItemByArticle(final List<ItemByArticle> itemByArticle) {
        this.mItemByArticle.setValue(itemByArticle);
    }

    public LiveData<List<ItemByArticle>> getList() {
        return this.mList;
    }
}


