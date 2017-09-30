package com.example.dmitry.mobilerevolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Product> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set RecyclerView
        setTestData();

        rv = (RecyclerView)findViewById(R.id.activityMainRecyclerView);
        rv.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        rv.setLayoutManager( linearLayoutManager);
        AdapterRecycleView adapter = new AdapterRecycleView(this, products);
        rv.setAdapter(adapter);

    }

    private void setTestData() {
       // Product p = new Product();

        products.add(new Product("Bread", null));
        products.add(new Product("Milk", null));
        products.add(new Product("Sweet", null));
        products.add(new Product("Tea", null));
        products.add(new Product("Coffe", null));
        products.add(new Product("Apple", null));
        products.add(new Product("PineApple", null));
        products.add(new Product("Lime", null));
        products.add(new Product("Lemon", null));

//        p.setName("Bread");
//        products.add(p);
//
//        p.setName("Milk");
//        products.add(p);
//
//        p.setName("Sweet");
//        products.add(p);
//
//        p.setName("Tea");
//        products.add(p);
//
//        p.setName("Coffe");
//        products.add(p);
//
//        p.setName("Apple");
//        products.add(p);
//
//        p.setName("Pineapple");
//        products.add(p);


    }
}
