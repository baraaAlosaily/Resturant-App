package com.example.restuapp;



/*The following code defines an AppDatabase class to hold the database. AppDatabase defines the database configuration and serves as the app's main access point to the persisted data. The database class must satisfy the following conditions:

1. The class must be annotated with a @Database annotation that includes an entities array that lists all of the data entities associated with the database.
2. The class must be an abstract class that extends RoomDatabase.
3. For each DAO class that is associated with the database, the database class must define an abstract method that has zero arguments and returns an instance of the DAO class.*/

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Dishes.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DishesDao dishesDao();
}
