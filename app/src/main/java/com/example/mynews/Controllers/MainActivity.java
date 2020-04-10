package com.example.mynews.Controllers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mynews.PagerAdapter.PagerAdapter;
import com.example.mynews.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);


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
                    case 3: {
                        tab.setText("BUSINESS");
                        break;
                    }
                }

            }
        }
        );
        tabLayoutMediator.attach();

    }
}



