package com.example.mynews.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mynews.Adapter.TopStoriesAdapter;
import com.example.mynews.R;
import com.example.mynews.View.Articles;
import com.example.mynews.View.TopStoryViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopStoriesFragment extends Fragment {

    private static final String JSON_URL = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=jM2fsht0Q5b6cviIbvKsFn1yQYUf5Evd";
    private RequestQueue mQueue;
    private ArrayList<Articles> articles;

    private TopStoriesAdapter topStoriesAdapter;
    private TopStoryViewModel topStoryViewModel;


    public TopStoriesFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articles = new ArrayList<>();
        //for (int i =0; i <45 ; i++){
       //     articles.add(new Articles("titre","11 aout 2020", "Section", "PhotoURL"));
       // }
        topStoryViewModel = new TopStoryViewModel();
        requestApi();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_top_stories, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.top_stories_recyclerView);

        //LiveData Observer
        topStoryViewModel.getList().observe(getViewLifecycleOwner(), new Observer<List<Articles>>() {
            @Override
            public void onChanged(List<Articles> articles) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                topStoriesAdapter = new TopStoriesAdapter(getContext(),articles);
                recyclerView.setAdapter(topStoriesAdapter);
            }
        });
        return root;
    }

    private void requestApi() {
        mQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, TopStoriesFragment.JSON_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray newsArray = response.getJSONArray("results");

                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject newObject = newsArray.getJSONObject(i);
                        String sectionObject = newObject.getString("section");


                        if (sectionObject.length() >0){
                           sectionObject = sectionObject.substring(0,1).toUpperCase() + sectionObject.substring(1).toLowerCase();
                       }
                       capitalize(sectionObject);// ???


                        String subSectionObject = newObject.getString("subsection");
                        if (subSectionObject.length() >0){
                            subSectionObject = subSectionObject.substring(0,1).toUpperCase() + subSectionObject.substring(1).toLowerCase();
                        }
                        capitalize(subSectionObject);// ???

                        //show > between section and subsection
                        StringBuilder subsectionStringBuilder = new StringBuilder();
                        subsectionStringBuilder.append(sectionObject);
                        subsectionStringBuilder.append(">");
                        subsectionStringBuilder.append(subSectionObject);
                        String sectionArticle = subsectionStringBuilder.toString();


                        String dateObject = newObject.getString("published_date");
                        JSONArray multimediaArray = newObject.getJSONArray("multimedia");
                        JSONObject mediaObject = multimediaArray.getJSONObject(0);

                        articles.add(new Articles(sectionObject,subSectionObject,newObject.getString("title"),dateObject,mediaObject.getString("url")));
                        capitalize(subSectionObject);
                    }
                    topStoryViewModel.setItemByArticle(articles);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            private String capitalize(String sectionObject) {
                if (sectionObject.length() > 0){
                    sectionObject = sectionObject.substring(0,1).toUpperCase() + sectionObject.substring(1).toLowerCase();
                }
                return sectionObject;

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(TopStoriesFragment.this.getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.start();
        mQueue.add(request);
    }

}
