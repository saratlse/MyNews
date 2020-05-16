package com.example.mynews.PagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mynews.Fragment.BusinessFragment;
import com.example.mynews.Fragment.MostPopularFragment;
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
            case 0:
                return new TopStoriesFragment();
            case 1:
                return new MostPopularFragment();
            default:
                return new BusinessFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}


