package com.example.mynews.Controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mynews.PagerAdapter.PagerAdapter;
import com.example.mynews.R;
import com.example.mynews.View.SearchArticlesViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private SearchArticlesViewModel searchArticlesViewModel;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);


        this.toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
        this.toolbar.setTitle(R.string.app_name);


        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PagerAdapter(this));

        StringBuilder searchStringBuilder = new StringBuilder();
        if (getFromSharedPreferences("arts")){
            searchStringBuilder.append("Arts,");
        }
        if (getFromSharedPreferences("travel")){
            searchStringBuilder.append("Travel,");
        }
        if (getFromSharedPreferences("business")){
            searchStringBuilder.append("Business,");
        }
        if (getFromSharedPreferences("politics")){
            searchStringBuilder.append("Politics,");
        }
        if (getFromSharedPreferences("sports")){
            searchStringBuilder.append("Sports,");
        }
        if (getFromSharedPreferences("entrepreneurs")){
            searchStringBuilder.append("Entrepreneurs,");
        }

        if (searchStringBuilder.length() > 0){
            searchStringBuilder.replace(searchStringBuilder.length()-1,searchStringBuilder.length(),"");
        }

        searchArticlesViewModel= new SearchArticlesViewModel();



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
                        tab.setText(searchStringBuilder.toString());
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();

        searchArticlesViewModel.getTabTitle().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String title) {
                TabLayout.Tab tab = tabLayout.getTabAt(2);
            tab.setText(title);
            viewPager2.getAdapter().notifyDataSetChanged();
            }
        });
    }

    private boolean getFromSharedPreferences(String key) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }


    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
       // SearchView searchView =(SearchView)item.getActionView();
      //  searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        //   @Override
         //   public boolean onQueryTextSubmit(String query) {
        //        return false;
        //    }

         //   @Override
        //    public boolean onQueryTextChange(String newText) {
        //        return false;
      //      }
     //   });
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu:
                Toast.makeText(this, "Notifications", Toast.LENGTH_LONG).show();
                break;
            case R.id.search:
                Intent searchIntent = new Intent(this, SearchArticlesActivity.class);
                startActivityForResult(searchIntent,0000);
                break;
            default:
              return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0000:
                if (resultCode == Activity.RESULT_OK){
                this.searchArticlesViewModel.setTabTitle(data.getStringExtra("SearchTitle"));
                }
                break;
        }
    }

}




