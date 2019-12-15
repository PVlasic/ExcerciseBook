package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    int Id;

    @ColumnInfo(name = "firstName")
    String firstName;

    @ColumnInfo(name = "lastName")
    String lastName;

    public int getId(int id){
        return this.Id;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }




}
