package com.example.restuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DishesDetailes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Dishes Details");
        setContentView(R.layout.activity_dishes_detailes);


        Intent i=getIntent();
        String dishname=i.getStringExtra("dishesName");
        String dishprice=i.getStringExtra("dishesPrice");
        String dishing=i.getStringExtra("dishesIng");
        ((TextView)findViewById(R.id.dishNameDet)).setText(dishname);
        ((TextView)findViewById(R.id.dishPriceDet)).setText(dishprice);
        ((TextView)findViewById(R.id.dishIngDet)).setText(dishing);


    }
}