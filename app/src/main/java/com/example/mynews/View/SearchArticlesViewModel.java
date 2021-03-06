package com.example.mynews.View;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class SearchArticlesViewModel extends ViewModel {

        private final MutableLiveData<List<Articles>> mItemByArticle = new MutableLiveData<>();
        private MutableLiveData<String> nycTabTitle = new MutableLiveData<>();

        private final LiveData<List<Articles>> mList = Transformations.map(this.mItemByArticle, new Function<List<Articles>, List<Articles>>() {
            @Override
            public List<Articles> apply(List<Articles> input) {
                return input;
            }
        });

    public MutableLiveData<String> getTabTitle(){
        if(nycTabTitle == null) {
            return new MutableLiveData<>();
        }
        return nycTabTitle;
    }

    public void setTabTitle(String title){
        nycTabTitle.setValue(title);
    }


    public void setItemByArticle(List<Articles> articles) {
            this.mItemByArticle.setValue(articles);
        }

        public LiveData<List<Articles>> getList() {
            return this.mItemByArticle;
        }

    public void onClickListerner() {

    }


}
