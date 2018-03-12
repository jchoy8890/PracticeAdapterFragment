package com.jcservices.apps.practicabf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jcservices.apps.practicabf.bean.Product;
import com.jcservices.apps.practicabf.events.OnProductSelected;

public class MainActivity extends AppCompatActivity implements OnProductSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClickProduct(Product product) {
        //Intent intent = new Intent(this, ProductSelectedFragment.class);
        Toast.makeText(this, "Product: " + product, Toast.LENGTH_SHORT).show();
    }
}