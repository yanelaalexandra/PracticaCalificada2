package com.pachacama.segundocalificado.practicacalificada2.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pachacama.segundocalificado.practicacalificada2.R;
import com.pachacama.segundocalificado.practicacalificada2.activities.DashboardActivity;
import com.pachacama.segundocalificado.practicacalificada2.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private static final String TAG = DashboardActivity.class.getSimpleName();

    private List<Product> products;

    public ProductAdapter(List<Product> products){

        this.products = products;
    }

    public void setProducts(List<Product> products) {

        this.products = products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView product_name;
        public TextView product_price;
        public TextView product_desc;

        public Button Button_favoritos;
        public Button Button_archivar;


        public ViewHolder(View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name_text);
            product_price = itemView.findViewById(R.id.product_price_text);
            product_desc = itemView.findViewById(R.id.product_description_text);
            Button_favoritos = itemView.findViewById(R.id.favoritos_btn);
            Button_archivar = itemView.findViewById(R.id.archivar_btn);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder holder, final int position) {
        final Product product = this.products.get(position);

        holder.product_name.setText(product.getProduct_name());
        String price = "$ "+product.getProduct_price();
        holder.product_price.setText(price);
        holder.product_desc.setText(product.getProduct_desc());


        holder.Button_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.Button_favoritos.getContext(), product.getProduct_name() +" agregado a favoritos", Toast.LENGTH_SHORT).show();
            }
        });

        holder.Button_archivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.Button_archivar.getContext(), product.getProduct_name() +" archivado", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }


}
