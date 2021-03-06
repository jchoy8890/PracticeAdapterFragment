package com.jcservices.apps.practicabf;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcservices.apps.practicabf.adapter.ProductAdapter;
import com.jcservices.apps.practicabf.bean.Product;
import com.jcservices.apps.practicabf.events.ClickListener;
import com.jcservices.apps.practicabf.events.OnProductSelected;
import com.jcservices.apps.practicabf.events.RecyclerViewOnTouch;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListProductFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListProductFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnProductSelected mListener;
    private List<Product> lstProducts;
    private RecyclerView recyclerView;


    public ListProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListProductFragment newInstance(String param1, String param2) {
        ListProductFragment fragment = new ListProductFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        loadFragment(view);
        return view;
    }

    // Load RecyclerView before load data
    private void loadFragment(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerViewOnTouch(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(lstProducts!=null){
                    Product product = lstProducts.get(position);
                    //gotoDetails(starWarsEvent);
                    Log.v("CONSOLE", " Product "+product);
                    if(mListener!=null){
                        mListener.onClickProduct(product);
                    }
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }


    private void loadData() {
        lstProducts = new ArrayList<Product>();
        Product product = new Product();
        product.setId(1);
        product.setDescription("Manzana originaria de Perú, producida en la Sierra central");
        product.setName("Manzana de Agua");
        product.setPrice(5.5);
        product.setUrlImage("https://vignette.wikia.nocookie.net/risassonrisas-y-carcajadas/images/7/7d/Apple.png/revision/latest?cb=20140131000944&path-prefix=es");
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        lstProducts.add(product);
        recyclerView.setAdapter(new ProductAdapter(this.lstProducts, getActivity()));

    }


}
