package com.example.mynews.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.View.Articles;

import java.util.List;


public abstract class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        List<Articles> articlesList;
        LayoutInflater mInflater;

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
