package com.example.mynews.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.View.Articles;

import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {
    private List<Articles> articlesList;
    private LayoutInflater mInflater;

    @NonNull
    @Override
    public TopStoriesAdapter.TopStoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoriesAdapter.TopStoriesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TopStoriesViewHolder extends RecyclerView.ViewHolder {
        public TopStoriesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
