package com.example.mynews.Controllers;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mynews.PagerAdapter.PagerAdapter;
import com.example.mynews.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView mtopStoriesResult;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);


        final Button buttonParse = this.findViewById(R.id.button);
        this.mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                MainActivity.this.jsonParse();
            }
        });


        this.toolbar = this.findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);


        final ViewPager2 viewPager2 = this.findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PagerAdapter(this));

        final TabLayout tabLayout = this.findViewById(R.id.tabLayout);
        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull final TabLayout.Tab tab, final int position) {


                switch (position) {
                    case 0: {
                        tab.setText("TOP STORIES");
                        break;
                    }
                    case 1: {
                        tab.setText("MOST POPULAR");
                        break;
                    }
                    case 2: {
                        tab.setText("BUSINESS");
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();

    }


    private void jsonParse() {
        final String url = "https://jsonplaceholder.typicode.com/posts";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            int i;

            @Override
            public void onResponse(final JSONObject response) {

                try {
                    final JSONArray jsonArray = response.getJSONArray("users");

                    for (int i = 0; i < jsonArray.length(); i++) ;
                    {
                        final JSONObject user = jsonArray.getJSONObject(this.i);

                        final int userId = user.getInt("userid");
                        final int id = user.getInt("id");
                        final String title = user.getString("title");
                        final String body = user.getString("body");

                        MainActivity.this.mtopStoriesResult.append(userId + "," + id + "," + title + "," + body + "\n\n");


                    }

                } catch (final JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                error.printStackTrace();
            }
        });
        this.mQueue.add(request);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu:
                Toast.makeText(this, "Menu", Toast.LENGTH_LONG).show();
                break;
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }

}




