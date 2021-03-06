package com.example.mynews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mynews.Controllers.WebViewActivity;
import com.example.mynews.R;
import com.example.mynews.View.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder> {

    //Member variable
    private List<Articles> articlesList;
    private Context mContext;


    // data is passed into the constructor
    public MostPopularAdapter(Context context, List<Articles> listArticles){
        this.articlesList = listArticles;
    }


    //inflate the card_item layout from xml
    @Override
    public MostPopularViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new MostPopularViewHolder(view);
    }

    public void onBindViewHolder( MostPopularAdapter.MostPopularViewHolder holder, int position) {
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


    public class MostPopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        private ImageView articleImage;
        private TextView articleDescription, articleCategory, articleDate;

        public MostPopularViewHolder(View itemView) {
            super(itemView);

            articleDescription = itemView.findViewById(R.id.articleCategory);
            articleDate = itemView.findViewById(R.id.articleDate);
            articleCategory = itemView.findViewById(R.id.articleCategory);
            articleImage = itemView.findViewById(R.id.articleImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), WebViewActivity.class);
            intent.putExtra("url",articlesList.get(getAdapterPosition()).getUrl());
            view.getContext().startActivities(new Intent[]{intent});
        }
    }
}