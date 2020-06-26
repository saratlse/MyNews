package com.example.mynews.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mynews.R;
import com.example.mynews.View.ItemByArticle;
import com.example.mynews.View.MostPopularViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostPopularFragment extends Fragment {


    private static final String JSON_URL = "https://api.nytimes.com/svc/mostpopular/v2/emailed/7.json?api-key=lvzzkPeHJEIDxfpTaqSb3Azu9LDnO4Fv";
    private List<ItemByArticle> itemByArticle;

    private RequestQueue mQueue;
    private MostPopularViewModel mMostPopularViewModel;

    public MostPopularFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.requestApi();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_most_popular, container, false);


    }

    private void requestApi() {

        this.mQueue = Volley.newRequestQueue(this.getContext());
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(final JSONObject response) {
                try {

                    final JSONArray newsArray = response.getJSONArray("results");

                    for (int i = 0; i < newsArray.length(); i++) {
                        final JSONObject newObjet = newsArray.getJSONObject(i);
                        final String sectionObject = newObjet.getString("section");
                        final JSONArray mediaArray = newObjet.getJSONArray("multimedia");
                        final JSONObject mediaObject = mediaArray.getJSONObject(0);


                    }

                } catch (final JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                error.printStackTrace();
                Toast.makeText(MostPopularFragment.this.getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        this.mQueue.start();

        this.mQueue.add(request);

    }
}

