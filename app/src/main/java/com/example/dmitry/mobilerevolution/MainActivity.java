package com.example.dmitry.mobilerevolution;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.activityMainViewPager);
        setUpViewPager();

        tabLayout = (TabLayout)findViewById(R.id.activityMainTabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    //заполнение адаптера ViewPager фрагментами с RecyclerView
    private void setUpViewPager() {

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager());

        //два подэкрана, поэтому два элемента
        adapterViewPager.addFragment(new FragmentRecyclerView(), "List1");
        adapterViewPager.addFragment(new FragmentRecyclerView(), "List2");
        viewPager.setAdapter(adapterViewPager);
    }


}
