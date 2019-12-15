package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    int Id;

    @ColumnInfo(name = 'firstName')
    String firstName;

    @ColumnInfo(name = 'lastName')
    String lastName;


}
