package com.example.mynews.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.Fragment.MostPopularFragment;
import com.example.mynews.R;
import com.example.mynews.View.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public abstract class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder> {

    MostPopularFragment mostPopularFragment;
    //Member variable
    private List<Articles> articlesList;
    private LayoutInflater inflater;


    // data is passed into the constructor
    public MostPopularAdapter(Context context, List<Articles> newsList, MostPopularFragment mostPopularFragment) {

        this.inflater = LayoutInflater.from(context);
        this.articlesList = newsList;
        this.mostPopularFragment = mostPopularFragment;
    }

    //inflate the card_item layout from xml
    @NonNull
    @Override
    public MostPopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new MostPopularViewHolder(view);
    }

    public void onBindViewHolder(@NonNull MostPopularAdapter.MostPopularViewHolder holder, int position) {
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


    public class MostPopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView articleImage;
        TextView articleDescription, articleCategory, articleDate;

        public MostPopularViewHolder(@NonNull View itemView) {
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
