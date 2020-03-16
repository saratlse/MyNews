package com.example.mynews.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mynews.Fragment.FragmentOne;
import com.example.mynews.Fragment.FragmentThree;
import com.example.mynews.Fragment.FragmentTwo;

public class TabAdapter extends FragmentStateAdapter {


    //private final List<Fragment> fragmentList = new ArrayList<>();
    // private final List<String> fragmentTitleList = new ArrayList<>();
    private final int numberOfTabs;


    public TabAdapter(final FragmentManager fragmentManager, final int numberOfTabs) {
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }



    /*public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }*/

    @NonNull
    @Override
    public Fragment createFragment(final int position) {
        return null;
    }

    @Override
    public int getItemCount() {

        return this.numberOfTabs;
    }


    @NonNull
    //this method return the instance of the fragment
    public Fragment getItem(final int position) {
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


    public int getCount() {
        return this.numberOfTabs;
    }


    @Override
    public long getItemId(final int position) {
        return super.getItemId(position);
    }
       /*public CharSequence GetPageTitle(int position) {
        switch (position) {
            case 0:
                return "tab1";
            case 1:
                return "tab2";
            case 2:
                return "tab3";
            default:
                return null;

        }

    }*/
}

