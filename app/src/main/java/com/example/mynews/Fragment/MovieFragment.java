package com.example.mynews.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import com.example.mynews.Adapter.MovieAdapter;
import com.example.mynews.R;
import com.example.mynews.View.Articles;
import com.example.mynews.View.MovieViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {


    private static final String JSON_URL = "https://api.nytimes.com/svc/mostpopular/v2/emailed/7.json?api-key=lvzzkPeHJEIDxfpTaqSb3Azu9LDnO4Fv";
    private ArrayList<Articles> articles;

    private RequestQueue mQueue;

    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;


    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articles = new ArrayList<>();
        movieViewModel = new MovieViewModel();
        this.requestApi();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_movie, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.movie_recyclerView);

        //LiveData Observer
        movieViewModel.getList().observe(getViewLifecycleOwner(), new Observer<List<Articles>>() {
            @Override
            public void onChanged(List<Articles> articles) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                movieAdapter = new MovieAdapter(getContext(), articles);
            }
        });
        return root;

    }
        private void requestApi () {

            this.mQueue = Volley.newRequestQueue(getContext());
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, MovieFragment.JSON_URL, null, new Response.Listener<JSONObject>() {

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
                        movieViewModel.setItemByArticle(articles);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Toast.makeText(MovieFragment.this.getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            this.mQueue.start();
            this.mQueue.add(request);
        }
    }



