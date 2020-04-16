package com.example.mynews.PagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mynews.Fragment.FragmentOne;
import com.example.mynews.Fragment.FragmentThree;
import com.example.mynews.Fragment.FragmentTwo;

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
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return null;
        }

    }



    @Override
    public int getItemCount() {
        return 3;
    }


}


