package com.example.mynews.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.example.mynews.Adapter.SearchArticlesAdapter;
import com.example.mynews.Adapter.TopStoriesAdapter;
import com.example.mynews.R;
import com.example.mynews.View.Articles;
import com.example.mynews.View.SearchArticlesViewModel;
import com.example.mynews.View.TopStoryViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchArticlesFragment extends Fragment {

    private static final String JSON_URL = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=lvzzkPeHJEIDxfpTaqSb3Azu9LDnO4Fv";
    private RequestQueue mQueue;
    private ArrayList<Articles> articles;

    private SearchArticlesAdapter searchArticlesAdapter;
    private SearchArticlesViewModel searchArticlesViewModel;

    // SharedPreferences variable
    private static final String MyPref = "MyPrefsFile";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;

    public SearchArticlesFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articles = new ArrayList<>();

        searchArticlesViewModel = new SearchArticlesViewModel();
        requestApi();

        mSharedPreferences = getActivity().getSharedPreferences(MyPref, MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_search_articles, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.search_recyclerView);

        //LiveData Observer
        searchArticlesViewModel.getList().observe(getViewLifecycleOwner(), new Observer<List<Articles>>() {
            @Override
            public void onChanged(List<Articles> articles) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                searchArticlesAdapter = new SearchArticlesAdapter(getContext(),articles);
                recyclerView.setAdapter(searchArticlesAdapter);
            }
        });
        return root;
    }

    private void requestApi() {
        mQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, SearchArticlesFragment.JSON_URL, null, new Response.Listener<JSONObject>() {

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
                    searchArticlesViewModel.setItemByArticle(articles);


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
                Toast.makeText(SearchArticlesFragment.this.getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.start();
        mQueue.add(request);
    }

    /**
     * @return
     */
    //Simple method to retrieve if a checkBox is checked in the searchActivity
    private boolean isArtChecked() {
        return mSharedPreferences.getBoolean("arts", true);
    }

    private boolean isPoliticsIsChecked(){
        return mSharedPreferences.getBoolean("politics", true);
    }

    private boolean businessIsChecked(){
        return mSharedPreferences.getBoolean("business", false);
    }

    private boolean sportsIsChecked(){
        return mSharedPreferences.getBoolean("sports", false);
    }

    private boolean entrepreneursIsChecked(){
        return mSharedPreferences.getBoolean("entrepreneurs", false);
    }

    private boolean travelsIsChecked(){
        return mSharedPreferences.getBoolean("travels", false);
    }
    // end of the method

    //method to retrieve the search query from the SearchActivity
    private String searchQueryValue(){
        return mSharedPreferences.getString("searchQuery","");
    }

    //method to retrieve the start date from the searchActivity
    private String startDateValue(){
        return mSharedPreferences.getString("beginDate", "");
    }

    //method to retrieve the end date from the searchActivity
    private String endDateValue(){
        return mSharedPreferences.getString("endDate", "");
    }


}
