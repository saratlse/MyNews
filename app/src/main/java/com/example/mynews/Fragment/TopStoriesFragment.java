package com.example.mynews.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.example.mynews.ItemByArticle;
import com.example.mynews.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopStoriesFragment extends Fragment {


    private static final String JSON_URL = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=zxR4wstV5o10Lush";
    private List<ItemByArticle> itemByArticles;

    private TextView mtopStoriesResult;
    private RequestQueue mQueue;


    public TopStoriesFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_stories, container, false);





        /*JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, TopStoriesFragment.JSON_URL,new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject objet = new JSONObject(response);
                    JSONArray newsArray = objet.getJSONArray("results");



                    for (int i = 0; i < newsArray.length(); i++) ;

                    {
                        JSONObject newsObject = newsArray.getJSONObject();
                        String sectionObject = newsObject.getString("section");
                        JSONArray mediaArray = newsObject.getJSONArray("multimedia");
                        JSONObject mediaObject = mediaArray.getJSONObject(0);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse( VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}