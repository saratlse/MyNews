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


public class SearchArticlesAdapter extends RecyclerView.Adapter<SearchArticlesAdapter.SearchResultViewHolder> {

    List<Articles> articlesList;
    public static final String EXTRA_MESSAGE = "test";
    private View.OnClickListener clickListener;

    // data is passed into the constructor
    public SearchArticlesAdapter(Context context, List<Articles> listArticles){
        this.articlesList = listArticles;
    }

    //inflate the card_item layout from xml
    @NonNull
    @Override
    public SearchArticlesAdapter.SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        RecyclerView.ViewHolder holder = new SearchResultViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(view);
            }
        });
        return new SearchResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder( SearchResultViewHolder holder, int position) {

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

    public class SearchResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private ImageView articleImage;
        private TextView articleDescription, articleCategory, articleDate;

        public SearchResultViewHolder(@NonNull View itemView) {
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
        public void setClickListener(View.OnClickListener callback) {
            clickListener = callback;
        }
    }
    
}
