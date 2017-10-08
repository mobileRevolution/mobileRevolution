package com.example.dmitry.mobilerevolution.view.activities;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dmitry.mobilerevolution.R;
import com.example.dmitry.mobilerevolution.view.adapters.AdapterViewPager;
import com.example.dmitry.mobilerevolution.view.fragments.FragmentRecyclerView;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.activityMainViewPager);
        setUpViewPager();
        tabLayout = (TabLayout) findViewById(R.id.activityMainTabLayout);
        tabLayout.setupWithViewPager(viewPager);


    }

    //заполнение адаптера ViewPager фрагментами с RecyclerView
    private void setUpViewPager() {

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager());
        adapterViewPager.addFragment(new FragmentRecyclerView(), getString(R.string.first_list));
        adapterViewPager.addFragment(new FragmentRecyclerView(), getString(R.string.second_list));
        viewPager.setAdapter(adapterViewPager);
    }




}
