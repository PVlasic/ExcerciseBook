package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.OffsetDateTime;

@Entity
public class ExcerciseDay {
    @PrimaryKey
    int Id;

    //lookup on user so we know which user had this exercise
    @ColumnInfo(name = "userId")
    int userId;


    //Need to find out how to store dates in the Room
//    @ColumnInfo(name = "dateOfExcercise")
//    OffsetDateTime dateTime;


}
