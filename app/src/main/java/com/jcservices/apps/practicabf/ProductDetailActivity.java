package com.jcservices.apps.practicabf;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jcservices.apps.practicabf.bean.Product;

public class ProductDetailActivity extends AppCompatActivity {

    FragmentManager fManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Bundle extras = getIntent().getExtras();
        Product p = extras.getParcelable("Product");
    }


}
