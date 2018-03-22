package com.jcservices.apps.practicabf;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jcservices.apps.practicabf.bean.Product;
import com.jcservices.apps.practicabf.events.OnProductSelected;

public class MainActivity extends AppCompatActivity implements OnProductSelected {

    FragmentManager fManager;

    ProductSelectedFragment productSelectedFragment;
    ListProductFragment listProductFragment;

    FloatingActionButton btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        loadUI();
    }

    private void loadUI() {
        fManager.beginTransaction();
        FragmentTransaction fmTransaction = fManager.beginTransaction();
        FrameLayout frameDetailProduct = findViewById(R.id.frameDetailProduct);
        listProductFragment = ListProductFragment.newInstance(null, null);
        productSelectedFragment = ProductSelectedFragment.newInstance(null, null);
        fmTransaction.replace(R.id.frameListProduct, listProductFragment);
        if (frameDetailProduct != null)
            fmTransaction.replace(R.id.frameDetailProduct, productSelectedFragment);
        fmTransaction.commit();
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAddProduct);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
            }
        });

        // Toast.makeText(getApplicationContext(), String.valueOf((FloatingActionButton) findViewById(R.id.btnAddProduct) != null), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClickProduct(Product product) {
        //Toast.makeText(getApplicationContext(), "Prueba", Toast.LENGTH_SHORT).show();
        if (productSelectedFragment != null && productSelectedFragment.isVisible()) {
            Log.i("JCHOY", "Fragment en pantalla.");
            sendDataToFragment(product);
        } else {
            Log.i("JCHOY", "Yendo a Activity");
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