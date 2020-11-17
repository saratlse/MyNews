package com.example.mynews.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.View.Articles;

import java.util.List;

public class WebViewNewsAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // For data
    private List<Articles> articlesList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        return null;
    }

    // Create interface for callback
    public interface Listener {
        void onClickItem(int position);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.articlesList.size();
    }


    // Return the position of an item in the list
    public Articles getPosition(int position){
        return this.articlesList.get(position);
    }
}
