package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class ExcerciseSet {
    @PrimaryKey
    int Id;

    @ColumnInfo(name = "excerciseId")
    int excerciseId;
    
    @ColumnInfo(name = "numberOfRepetitions")
    String numberOfRepetitions;
}
