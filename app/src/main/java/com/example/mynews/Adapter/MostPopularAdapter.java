package com.example.mynews.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.View.Articles;

import java.util.List;

public abstract class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder> {

    //Member variable
    private List<Articles> articlesList;
    private LayoutInflater mInflater;


    // data is passed into the constructor
    public MostPopularAdapter(Context context, List<Articles> newsList) {
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

    public class MostPopularViewHolder extends RecyclerView.ViewHolder {
        public MostPopularViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
