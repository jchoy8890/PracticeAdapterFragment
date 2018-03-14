package com.jcservices.apps.practicabf;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcservices.apps.practicabf.bean.Product;
import com.jcservices.apps.practicabf.events.OnProductSelected;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductSelectedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductSelectedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductSelectedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnProductSelected mListener;
    private Product product;
    private ImageView imgProduct;
    private TextView txtName, txtDescription, txtPrice;


    public ProductSelectedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductSelectedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductSelectedFragment newInstance(String param1, String param2) {
        ProductSelectedFragment fragment = new ProductSelectedFragment();
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
        //setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_selected, container, false);
        imgProduct = view.findViewById(R.id.imgViewProduct);
        txtName = view.findViewById(R.id.txtNameProduct);
        txtDescription = view.findViewById(R.id.txtDescriptionProduct);
        txtPrice = view.findViewById(R.id.txtPriceProduct);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().getIntent() != null && getActivity().getIntent().getExtras() != null)
            this.product = (Product) getActivity().getIntent().getExtras().getParcelable("Product");
        populateProduct();
    }

    private void populateProduct() {
        if (product != null) {
            Picasso.with(getActivity()).load(product.getUrlImage()).into(imgProduct);
            txtDescription.setText(product.getDescription());
            txtName.setText(product.getName());
            txtPrice.setText("S/ " + product.getPrice());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProductSelected) {
            mListener = (OnProductSelected) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void showDetailProduct(Product product) {
        this.product = product;
        populateProduct();
    }


}
