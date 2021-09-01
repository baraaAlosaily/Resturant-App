package com.example.restuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddDishesScreen extends AppCompatActivity {
    private DishesDao dishesDao;
    private AppDataBase appDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Dish Screen");
        setContentView(R.layout.activity_add_dishes_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appDataBase= Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"dish").allowMainThreadQueries().build();
        dishesDao=appDataBase.dishesDao();

        Button addDish=findViewById(R.id.submitDish);
        addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dishNameInput=findViewById(R.id.dishNameInput);
                EditText dishPriceInput=findViewById(R.id.dishPriceInput);
                EditText dishIngInput=findViewById(R.id.dishIngInput);
                String name=dishNameInput.getText().toString();
                String price=dishPriceInput.getText().toString();
                String ing=dishIngInput.getText().toString();

                Dishes dishes=new Dishes(name,Integer.parseInt(price),ing);
                dishesDao.insertOne(dishes);

                Toast.makeText(AddDishesScreen.this,"Dishes Addes",Toast.LENGTH_LONG).show();

            }
        });
    }
}