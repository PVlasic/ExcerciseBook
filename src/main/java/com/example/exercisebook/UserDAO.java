package com.example.exercisebook;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    //we use live data because we want to refelect all of the changes on the database right away
    @Query("SELECT Id, firstName, lastName FROM User ORDER BY firstName")
    LiveData<List<User>> getAllUsers();

    @Insert
    void insert(User user);

    //need to write custom delete since I will need to delete all objects related to the
    //User when I delete the user
    @Delete
    void delete(User user);

    @Update
    void update(User user);

    
}
