package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Excercise {
    @PrimaryKey
    int Id;

    //lookup on exercise day
    @ColumnInfo(name = "dayId")
    int dayId;

    @ColumnInfo(name = "exerciseName")
    String excerciseName;

    @ColumnInfo(name = "numberOfSets")
    int numberOfSets;


}
