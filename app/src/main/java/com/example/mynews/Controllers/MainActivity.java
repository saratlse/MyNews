package com.example.mynews.Controllers;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mynews.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabItem tab1, tab2, tab3;
    private TabLayout tabLayout;
    private final String[] titles = {"TOP STORIES", "MOST POPULAR", "BUSINESS"};
    //private TabAdapter tabAdapter;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.tabLayout = this.findViewById(R.id.tabLayout);

        this.viewPager2 = this.findViewById(R.id.view_pager2);

       /* final TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager2.setAdapter(tabAdapter);*/


        //attaching Tab mediator for attach together the tablayout and the viewpager
        //TabLayout tabLayout = viewPager2.findViewById(R.id.tabLayout);
        new TabLayoutMediator(this.tabLayout, this.viewPager2,
                (tab, position) -> tab.setText(this.titles[position])).attach();
    }



        //viewPager for the swipe between the screen, we find the view and set the adapter on  the viewpager


       /* tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(final TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0) {
                    tabAdapter.notifyDataSetChanged();

                } else if (tab.getPosition() == 1) {
                    tabAdapter.notifyDataSetChanged();

                } else if (tab.getPosition() == 2) {
                    tabAdapter.notifyDataSetChanged();
                }
            }*/


           /* @Override
            public void onTabUnselected(final TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(final TabLayout.Tab tab) {

            }
        });

        viewPager2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


        Toolbar toolbar = findViewById(R.id.toolbar);
        //Set the toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tabAdapter.addFragment(new FragmentOne(), "TOP STORIES");
        tabAdapter.addFragment(new FragmentTwo(), "MOST POPULAR");
        tabAdapter.addFragment(new FragmentThree(), "BUSINESS");


        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);*/


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        //inflate the menu and add it in the toolbar
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        //each time when you click on item from the toolbar
        final int id = item.getItemId();


        if (id == R.id.notification) {
            Toast.makeText(this.getApplicationContext(), "You click Notifications", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.help) {
            Toast.makeText(this.getApplicationContext(), "You click on Help", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.search) {
            Toast.makeText(this.getApplicationContext(), "You click on Search", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

}


