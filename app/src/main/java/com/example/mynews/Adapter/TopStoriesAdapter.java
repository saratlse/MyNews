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
import java.util.Objects;

import static androidx.core.content.ContextCompat.startActivity;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {
    private List<Articles> articlesList;



    // data is passed into the constructor
    public TopStoriesAdapter(Context context, List<Articles> listArticles){
        this.articlesList = listArticles;
    }

    @NonNull
    @Override
    public TopStoriesAdapter.TopStoriesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new TopStoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder( TopStoriesAdapter.TopStoriesViewHolder holder, int position) {
        Articles articles = articlesList.get(position);
        //insert the JSON queried Data in each section
        holder.articleDescription.setText(articles.getTitle());
        holder.articleCategory.setText(articles.getSection());
        holder.articleDate.setText(articles.getDate());
        holder.articleSubsection.setText(articles.getSubsection());
        String imageUrl = articles.getImageUrl();
        Picasso.get().load(imageUrl).into(holder.articleImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.putExtra("url",articles.getUrl());
                v.getContext().startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class TopStoriesViewHolder extends RecyclerView.ViewHolder  {
        private ImageView articleImage;
        private TextView articleDescription, articleSubsection, articleCategory, articleDate;

        public TopStoriesViewHolder(View itemView) {
            super(itemView);
            articleCategory = itemView.findViewById(R.id.articleCategory);
            articleSubsection = itemView.findViewById(R.id.subSection);
            articleDate = itemView.findViewById(R.id.articleDate);
            articleDescription = itemView.findViewById(R.id.articleDescription);
            articleImage = itemView.findViewById(R.id.articleImage);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context,"my webview is clicked",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                    intent.putExtra("KEY_URL",articlesList.get(getAdapterPosition()).getUrl());
                  //  intent.putExtra("url", "https://www.nytimes.com/subscription?campaignId=7UXFY&ds_c=71700000074377394&gclid=Cj0KCQiAqdP9BRDVARIsAGSZ8AllWN-ve3Ld3Y3mRU02FW72QWFfc5vKBkCLGXt16cZauEgYr-WrYVsaAik9EALw_wcB&gclsrc=aw.ds");
                    view.getContext().startActivities(new Intent[]{intent});
                }
            });


        }

      /*  @Override
        public void onClick(View view) {
           Intent intent = new Intent(view.getContext(), WebViewActivity.class);
           intent.putExtra("KEY_URL",articlesList.get(getAdapterPosition()).getUrl());
           intent.putExtra("url", "https://www.nytimes.com/subscription?campaignId=7UXFY&ds_c=71700000074377394&gclid=Cj0KCQiAqdP9BRDVARIsAGSZ8AllWN-ve3Ld3Y3mRU02FW72QWFfc5vKBkCLGXt16cZauEgYr-WrYVsaAik9EALw_wcB&gclsrc=aw.ds");
          // view.getContext().startActivities(new Intent[]{intent});

        }*/
    }
}
