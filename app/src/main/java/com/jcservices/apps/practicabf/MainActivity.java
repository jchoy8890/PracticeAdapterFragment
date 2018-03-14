package com.jcservices.apps.practicabf;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jcservices.apps.practicabf.bean.Product;
import com.jcservices.apps.practicabf.events.OnProductSelected;

public class MainActivity extends AppCompatActivity implements OnProductSelected {

    FragmentManager fManager;

    ProductSelectedFragment productSelectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        loadUI();
    }

    private void loadUI() {
        productSelectedFragment = (ProductSelectedFragment) fManager.findFragmentById(R.id.fragmentDetailsProducts);
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