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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopStoriesFragment extends Fragment {

    private static final String JSON_URL = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=lvzzkPeHJEIDxfpTaqSb3Azu9LDnO4Fv";
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
                        String subSectionObject = newObject.getString("subsection");
                        String dateObject = newObject.getString("published_date");
                        JSONArray multimediaArray = newObject.getJSONArray("multimedia");
                        JSONObject mediaObject = multimediaArray.getJSONObject(0);

                        articles.add(new Articles(sectionObject,subSectionObject,newObject.getString("title"),dateObject,mediaObject.getString("url")));

                    }
                    topStoryViewModel.setItemByArticle(articles);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
