package com.example.campusexpensemanager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductListViewAdapter extends BaseAdapter {
    public List<ProductModel> products;

    public ProductListViewAdapter(List<ProductModel> items){
        this.products = items;
    }

    @Override
    public int getCount() {
        return products.size(); // lay ra kich thuoc cua DS san pham
    }

    @Override
    public Object getItem(int position) {
        return products.get(position); // lay ra vi tri cua cac san pham trong DS
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).idProduct; // lay ra id cua tung san pham
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if(convertView == null){
            viewProduct = View.inflate(parent.getContext(), R.layout.list_product, null);
        } else {
            viewProduct = convertView;
        }
        // doi du lieu tu model vao listview
        ProductModel model = (ProductModel) getItem(position);

        TextView tvId = viewProduct.findViewById(R.id.tvProductId);
        TextView tvName = viewProduct.findViewById(R.id.tvNameProduct);
        TextView tvPrice = viewProduct.findViewById(R.id.tvPriceProduct);

        tvId.setText(String.format("%d", model.idProduct));
        tvName.setText(String.format("%s", model.nameProduct));
        tvPrice.setText(String.format("%d", model.priceProduct));

        return viewProduct;
    }
}
