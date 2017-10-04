package com.example.dmitry.mobilerevolution;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 01.10.17.
 */

public class AdapterViewPager extends FragmentStatePagerAdapter {

    private List<Fragment> listFragmentRecyclerView = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragmentRecyclerView.get(position);
    }

    @Override
    public int getCount() {
        return listFragmentRecyclerView.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        listFragmentRecyclerView.add(fragment);
        titles.add(title);
    }
}
