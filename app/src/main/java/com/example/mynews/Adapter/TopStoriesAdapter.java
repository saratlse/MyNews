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
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {
    private List<Articles> articlesList;


    // data is passed into the constructor
    public TopStoriesAdapter(Context context, List<Articles> listArticles){
        this.articlesList = listArticles;
    }

    @NonNull
    @Override
    public TopStoriesAdapter.TopStoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new TopStoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoriesAdapter.TopStoriesViewHolder holder, int position) {
        Articles articles = articlesList.get(position);
        //insert the JSON queried Data in each section
        holder.articleDescription.setText(articles.getTitle());
        holder.articleCategory.setText(articles.getSection());
        holder.articleDate.setText(articles.getDate());
        String imageUrl = articles.getImageUrl();
        Picasso.get().load(imageUrl).into(holder.articleImage);
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class TopStoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView articleImage;
        private TextView articleDescription, articleCategory, articleDate;

        public TopStoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            articleDescription = itemView.findViewById(R.id.articleCategory);
            articleDate = itemView.findViewById(R.id.articleDate);
            articleCategory = itemView.findViewById(R.id.articleCategory);
            articleImage = itemView.findViewById(R.id.articleImage);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {

        }
    }
}
