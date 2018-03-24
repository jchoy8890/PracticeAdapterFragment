package com.jcservices.apps.practicabf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcservices.apps.practicabf.R;
import com.jcservices.apps.practicabf.bean.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by prog1 on 12/03/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> lstProducts;
    private Context ctx;

    public ProductAdapter(List<Product> lstProducts, Context ctx) {
        this.lstProducts = lstProducts;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = this.lstProducts.get(position);
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText("S/ " + product.getPrice());
        holder.txtDescription.setText(product.getDescription());
        if (product.getUrlImage() != null)
            Picasso.with(this.ctx).load(product.getUrlImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtName, txtDescription, txtPrice;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imgViewProduct);
            txtName = view.findViewById(R.id.txtNameProduct);
            txtDescription = view.findViewById(R.id.txtDescriptionProduct);
            txtPrice = view.findViewById(R.id.txtPriceProduct);
        }
    }


}
