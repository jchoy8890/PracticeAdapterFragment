package com.jcservices.apps.practicabf;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jcservices.apps.practicabf.bean.Product;
import com.jcservices.apps.practicabf.events.OnProductSelected;

public class ProductDetailActivity extends AppCompatActivity implements OnProductSelected{

    FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Bundle extras = getIntent().getExtras();
        Product p = extras.getParcelable("Product");
        Toast.makeText(this, p.getDescription(), Toast.LENGTH_SHORT).show();
        fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        ProductSelectedFragment fragmentProductSelected = ProductSelectedFragment.newInstance(null, null);
        fTransaction.replace(R.id.frameDetailProduct2, fragmentProductSelected);
        fTransaction.commit();
        //fragmentProductSelected.showDetailProduct(p);

    }


    @Override
    public void onClickProduct(Product product) {

    }
}
