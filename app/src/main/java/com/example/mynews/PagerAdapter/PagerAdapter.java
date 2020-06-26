package com.example.mynews.PagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mynews.Fragment.MostPopularFragment;
import com.example.mynews.Fragment.MovieFragment;
import com.example.mynews.Fragment.TopStoriesFragment;

public class PagerAdapter extends FragmentStateAdapter {

    //constructor
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {

        super(fragmentActivity);
    }

    //methods
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0: //page 1
                return new TopStoriesFragment();
            case 1: //page2
                return new MostPopularFragment();
            default://page3
                return new MovieFragment();
        }

    }

    //method will be called as soon as a page (fragment) requests to be displayed
    @Override
    public int getItemCount() {
        return 3;
    }


}


