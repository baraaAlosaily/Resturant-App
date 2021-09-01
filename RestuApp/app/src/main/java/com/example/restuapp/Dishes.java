package com.example.restuapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Dishes {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "dish_name")
    public String dishesName;
    @ColumnInfo(name = "dish_price")
    public int dishesPrice;
    @ColumnInfo(name = "dish_ing")
    public String dishesIng;

    public Dishes(String dishesName, int dishesPrice, String dishesIng) {
        this.dishesName = dishesName;
        this.dishesPrice = dishesPrice;
        this.dishesIng = dishesIng;
    }

    public String getDishesName() {
        return dishesName;
    }

    public String getDishesPrice() {
        return Integer.toString(dishesPrice);
    }

    public String getDishesIng() {
        return dishesIng;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public void setDishesPrice(int dishesPrice) {
        this.dishesPrice = dishesPrice;
    }

    public void setDishesIng(String dishesIng) {
        this.dishesIng = dishesIng;
    }


}
