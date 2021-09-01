package com.example.restuapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
//The following code defines a DAO called Dishes. Dishses provides the methods that the rest of the app uses to interact with data in the dishes table.
@Dao
public interface DishesDao {

    @Query("SELECT * FROM dishes WHERE dish_name Like :name")
    Dishes findByName(String name);

    @Query("SELECT * FROM dishes")
    List<Dishes>findAll();
    @Insert
    void insertOne(Dishes dishes);

    @Delete
    void deleteItem(Dishes dishes);
}
