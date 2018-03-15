package com.jcservices.apps.practicabf;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jcservices.apps.practicabf.bean.Product;
import com.jcservices.apps.practicabf.events.OnProductSelected;

public class MainActivity extends AppCompatActivity implements OnProductSelected {

    FragmentManager fManager;

    ProductSelectedFragment productSelectedFragment;

    FloatingActionButton btnAdd;

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        loadUI();
    }

    private void loadUI() {
        ctx = this;
        productSelectedFragment = (ProductSelectedFragment) fManager.findFragmentById(R.id.fragmentDetailsProducts);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAddProduct);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"Add", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClickProduct(Product product) {
        if (productSelectedFragment != null) {
            sendDataToFragment(product);
        } else {
            startActivityDetailProduct(product);
        }

        //Intent intent = new Intent(this, ProductSelectedFragment.class);
        //oast.makeText(this, "Product: " + product, Toast.LENGTH_SHORT).show();
    }

    private void sendDataToFragment(Product product) {
        productSelectedFragment.showDetailProduct(product);
    }

    private void startActivityDetailProduct(Product product) {
        Intent intentProductDetail = new Intent(this, ProductDetailActivity.class);
        intentProductDetail.putExtra("Product", product);
        startActivity(intentProductDetail);
    }


}