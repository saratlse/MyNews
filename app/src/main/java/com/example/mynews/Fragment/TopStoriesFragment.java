package com.example.mynews.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

    private static final String JSON_URL = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=Rcgp5CKAbUEUBl6NlZOppWk0ZN0tmvE7";
    private RequestQueue mQueue;
    private List<Articles> articles;
    private TopStoriesAdapter topStoriesAdapter;
    private TopStoryViewModel topStoryViewModel;


    public TopStoriesFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articles = new ArrayList<>();
        topStoryViewModel = new TopStoryViewModel();
        requestApi();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_top_stories, container, false);
        //LiveData Observer
        topStoryViewModel.getList().observe(getViewLifecycleOwner(), itemByArticles -> {

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
                        JSONObject newObjet = newsArray.getJSONObject(i);
                        String sectionObject = newObjet.getString("section");
                        JSONArray mediaArray = newObjet.getJSONArray("multimedia");
                        JSONObject mediaObject = mediaArray.getJSONObject(0);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.start();
        mQueue.add(request);
    }
}
