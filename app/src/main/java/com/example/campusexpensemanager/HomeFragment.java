package com.example.campusexpensemanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ListView lstProduct = view.findViewById(R.id.listProducts);
        // tao du lieu test
        List<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel(1, "Iphone 8", 450));
        products.add(new ProductModel(2, "IPhone X", 600));
        products.add(new ProductModel(3, "Iphone 11", 800));
        products.add(new ProductModel(4, "Iphone 12", 1000));
        products.add(new ProductModel(5, "Iphone 13", 1500));
        products.add(new ProductModel(6, "Iphone 14", 2000));
        products.add(new ProductModel(7, "Iphone 15", 2500));
        products.add(new ProductModel(8, "Samsung S23", 800));
        products.add(new ProductModel(9, "Samsung S24", 1500));
        products.add(new ProductModel(10, "Samsung S25", 2000));

        ProductListViewAdapter adapter = new ProductListViewAdapter(products);
        lstProduct.setAdapter(adapter);
        return view;
    }
}