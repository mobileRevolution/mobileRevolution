package com.example.dmitry.mobilerevolution;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {


    private LayoutInflater inflater;
    private List<Product> products;
    private FragmentManager fragmentManager;

    public AdapterRecycleView(Context context, List<Product> list) {
        this.inflater = LayoutInflater.from(context);
        this.products = list;

    }

    public void setManager(FragmentManager manager) {
        this.fragmentManager = manager;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.element_of_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.init(products.get(position));
        // Лучше в классе ViewHolder добавить метод
        // void init(Product product);
        // и перенести туда эту логику, потому что иначе если будет несколько типов ViewHolder'ов,
        // то здесь будет много кода
    }


    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ImageView photoProduct;
        final TextView nameOfProduct;
        final ImageButton buttonAdd;
        final View viewBackground;
        private String description;

        public ViewHolder(View itemView) {
            super(itemView);
            this.photoProduct = itemView.findViewById(R.id.elementImageViewPhoto); // начиная с 26 support library можно убрать явный каст
            this.nameOfProduct = itemView.findViewById(R.id.elementTextViewName);
            this.buttonAdd = itemView.findViewById(R.id.elementImageButtonAdd);
            this.viewBackground = itemView.findViewById(R.id.elementView);
            viewBackground.setOnClickListener(this);
            if (itemView.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                initWithStartProduct(products.get(0));
            }

        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public void onClick(View view) {
            // если хранить id изображения в entity
            // то можно получить изображение с помощью
            // products.get(getAdapterPosition()).getImage(); -- ссылка на ресурс изображения
            photoProduct.buildDrawingCache();
            Bitmap photo = photoProduct.getDrawingCache(); // это слишком долгие операции для элементов списка
            Bitmap watermarkimage = photo.copy(photo.getConfig(), true);
            if (view.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) { // этот код лучше вынести в родительскую Activity / Fragment
                Intent intent = ElementActivity.createStartIntent(view.getContext(), nameOfProduct.getText().toString(), description, watermarkimage);
                view.getContext().startActivity(intent);//тут будет вызываться новое активитии с подробной информацией
            } else {
                Fragment elementFragment=ElementFragment.createStartFragment( nameOfProduct.getText().toString(),description, watermarkimage);
                fragmentManager.beginTransaction().replace(R.id.fragment_container1, elementFragment).commit();
            }

        }

        public void initWithStartProduct(Product p) {
            Fragment elementFragment=ElementFragment.createStartFragment(p.getName(),p.getDescription(),null);
            fragmentManager.beginTransaction().replace(R.id.fragment_container1, elementFragment).commit();
        }

        public void init(Product product) {
            nameOfProduct.setText(product.getName());
            photoProduct.setImageDrawable(product.getPhoto());
            setDescription(product.getDescription());
        }
    }
}
