package com.example.mynews.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.R;
import com.example.mynews.View.Articles;
import com.example.mynews.View.MostPopularViewModel;

import java.util.List;

public abstract class MostPopularAdapter extends RecyclerView.Adapter {

    //Member variable
    private List<Articles> articlesList;
    private LayoutInflater mInflater;


    // data is passed into the constructor
    public MostPopularAdapter (Context context, List<Articles> newsList){
        this.mInflater = LayoutInflater.from(context);
        this.articlesList = newsList;
    }


 
    public void onBindViewHolder(@NonNull MostPopularAdapter holder, int position) {
        Articles articles = articlesList.get(position);

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }




}
