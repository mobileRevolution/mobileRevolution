package com.example.dmitry.mobilerevolution;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dmitry on 30.09.17.
 */

/**
 * Необходимо форматировать код, в идеале в соответствии с Java CodeStyle и Android CodeStyle
 * https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md
 * http://www.oracle.com/technetwork/java/codeconvtoc-136057.html -- читать его полностью
 * не обязательно, но нужно иметь ввиду.
 * К тому же, можно использовать комбинацию Ctrl + Alt + L для форматирования.
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
        View view = inflater.inflate(R.layout.element_of_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.nameOfProduct.setText(product.getName());
        holder.photoProduct.setTag(R.drawable.bread);
        holder.photoProduct.setImageDrawable(product.getPhoto());
        holder.setDescription(product.getDescription());
        // Лучше в классе ViewHolder добавить метод
        // void init(Product product);
        // и перенести туда эту логику, потому что иначе если будет несколько типов ViewHolder'ов,
        // то здесь будет много кода
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
        private String description;
        public ViewHolder(View itemView) {
            super(itemView);
            this.photoProduct = (ImageView)itemView.findViewById(R.id.elementImageViewPhoto); // начиная с 26 support library можно убрать явный каст
            this.nameOfProduct = (TextView)itemView.findViewById(R.id.elementTextViewName);
            this.buttonAdd = (ImageButton)itemView.findViewById(R.id.elementImageButtonAdd);
            this.viewBackground = itemView.findViewById(R.id.elementView);
            viewBackground.setOnClickListener(this);
        }

        public void setDescription(String description){
            this.description=description;
        }

        @Override
        public void onClick(View view) {
            photoProduct.buildDrawingCache();
            Bitmap photo= photoProduct.getDrawingCache();
            Bundle extras = new Bundle();
            extras.putString("nameOfProduct",nameOfProduct.getText().toString());
            extras.putString("descriptionOfProduct",description);
            extras.putParcelable("photoOfProduct", photo);
            Intent intent=new Intent(view.getContext(),ElementActivity.class);
            // Переходы лучше вынести в активити (роутер)
            // при переходе в другую активити, если необходимо передать параметры,
            // то создается статический метод ElementActivity.createStartIntent(Context context, String id);
            // как пример. Названия полей (nameOfProduct и т.д.) всегда используются в виде констант
            // и хранятся в активити, которая генерирует стартовый Intent и достает из него данные
            // private static final String BUNDLE_NAME = "bundle_name;
            // Клик из адаптера передается через интерфейс в активити / фрагмент
            intent.putExtras(extras);
            view.getContext().startActivity(intent);//тут будет вызываться новое активитии с подробной информацией

        }
    }
}
