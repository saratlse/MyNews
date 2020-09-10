package com.example.mynews.Controllers;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mynews.PagerAdapter.PagerAdapter;
import com.example.mynews.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);


        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {


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


    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
       SearchView searchView =(SearchView)item.getActionView();
      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(final MenuItem item) {
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




