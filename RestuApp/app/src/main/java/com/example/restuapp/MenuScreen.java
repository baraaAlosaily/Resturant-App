package com.example.restuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuScreen extends AppCompatActivity {
    // create fields for Dao  and appdatabase
    private DishesDao dishesDao;
    private AppDataBase appDataBase;


    // List and adapter that mydata will saved on it
    private List<Dishes> dishesList=new ArrayList<>();
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Menu");
        setContentView(R.layout.activity_menu_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button backtoMain=findViewById(R.id.backToMenu);
        backtoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMenu=new Intent(MenuScreen.this,MainActivity.class);
                startActivity(goToMenu);
            }
        });

        // 1. Before that was add dependencies that related to room db
        // 2. Create AppData Base
        // 3.Create Dao that will manage my data base and it will work like Curd in some cases

        // Data Base


        // This line represent my table in data base and it will change based methods that i will created in Dao like insert or delete and etc..
        appDataBase= Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"dish").allowMainThreadQueries().build();
        dishesDao=appDataBase.dishesDao();
        dishesList=dishesDao.findAll();

        RecyclerView allDishesRecycleView=findViewById(R.id.menuRecycleView);

        dishesList.add(new Dishes("Mansaf",10,"Jammed"));
        dishesList.add(new Dishes("Shawerma",2,"Checken"));
        dishesList.add(new Dishes("Brosted",4,"checken,potato"));
        dishesList.add(new Dishes("Pizza",5,"bread"));


        menuAdapter=new MenuAdapter(dishesList, this);
        allDishesRecycleView.setAdapter(menuAdapter);
        allDishesRecycleView.setLayoutManager(new LinearLayoutManager(this));


    }
}