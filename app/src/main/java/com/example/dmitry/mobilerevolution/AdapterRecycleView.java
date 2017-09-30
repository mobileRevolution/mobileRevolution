package com.example.dmitry.mobilerevolution;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by dmitry on 30.09.17.
 */

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder>  {


    private LayoutInflater inflater;
    private List<Product> products;

    public AdapterRecycleView(Context context, List<Product> list)
    {
        this.inflater = LayoutInflater.from(context);
        this.products = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.element,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.nameOfProduct.setText(product.getName());
        holder.photoProduct.setImageResource(R.drawable.bread);
    }


    @Override
    public int getItemCount() {
        return products.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final ImageView photoProduct;
        final TextView nameOfProduct;
        final ImageButton buttonAdd;
        final View viewBackground;
        public ViewHolder(View itemView) {
            super(itemView);
            this.photoProduct = (ImageView)itemView.findViewById(R.id.elementImageViewPhoto);
            this.nameOfProduct = (TextView)itemView.findViewById(R.id.elementTextViewName);
            this.buttonAdd = (ImageButton)itemView.findViewById(R.id.elementImageButtonAdd);
            this.viewBackground = itemView.findViewById(R.id.elementView);

            buttonAdd.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //тут будет вызываться новое активитии с подробной информацией

        }
    }
}
