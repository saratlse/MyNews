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
    public PagerAdapter(@NonNull final FragmentActivity fragmentActivity) {

        super(fragmentActivity);
    }

    //methods
    @NonNull
    @Override
    public Fragment createFragment(final int position) {

        switch (position) {
            case 0:
                return new TopStoriesFragment();
            case 1:
                return new MostPopularFragment();
            default:
                return new MovieFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}


