package com.example.dmitry.mobilerevolution.view.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmitry.mobilerevolution.R;
import com.example.dmitry.mobilerevolution.model.Product;
import com.example.dmitry.mobilerevolution.presenter.ProductRepositoryImpl;
import com.example.dmitry.mobilerevolution.presenter.interfaces.ProductRepository;
import com.example.dmitry.mobilerevolution.view.fragments.ElementFragment;
import com.example.dmitry.mobilerevolution.view.interfaces.ViewAdapter;

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
public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> implements ViewAdapter {


    private LayoutInflater inflater;
    private FragmentManager fragmentManager;
    private ProductRepository repository;

    public AdapterRecycleView(Context context) {
        this.inflater = LayoutInflater.from(context);
        repository = new ProductRepositoryImpl(context, this);

    }

    public void setManager(FragmentManager manager) {
        this.fragmentManager = manager;
        repository.setFragmentManager(manager);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.element_of_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        repository.initProduct(holder, position);
        // Лучше в классе ViewHolder добавить метод
        // void init(Product product);
        // и перенести туда эту логику, потому что иначе если будет несколько типов ViewHolder'ов,
        // то здесь будет много кода
    }

    public void setProductComponent() {

    }

    @Override
    public int getItemCount() {
        return repository.getSizeOfProducts();
    }

    public void addFragment(Product p) {
        Fragment elementFragment = ElementFragment.createStartFragment(p.getName(), p.getDescription(), null);
        fragmentManager.beginTransaction().replace(R.id.fragment_container1, elementFragment).commit();

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
                repository.initWithStartProduct();
            }

        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public void onClick(View view) {
            repository.initWithProduct(this, view);
        }

        public void init(Product product) {
            nameOfProduct.setText(product.getName());
            photoProduct.setImageDrawable(product.getPhoto());
            setDescription(product.getDescription());
        }

        public String getDescription() {
            return description;
        }

        public ImageView getPhotoProduct() {
            return photoProduct;
        }

        public TextView getNameOfProduct() {
            return nameOfProduct;
        }

        public ImageButton getButtonAdd() {
            return buttonAdd;
        }

        public View getViewBackground() {
            return viewBackground;
        }
    }
}
