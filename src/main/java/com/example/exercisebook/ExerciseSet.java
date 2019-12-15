package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ExerciseSet")
public class ExerciseSet {
    @PrimaryKey(autoGenerate = true)
    int Id;

    @ColumnInfo(name = "exerciseId")
    int excerciseId;

    @ColumnInfo(name = "numberOfRepetitions")
    int numberOfRepetitions;

    public int getId(int id){
        return this.Id;
    }
    public void setParent(int dayId){
        this.excerciseId = dayId;
    }

    public int getParent(){
        return this.excerciseId;
    }
    public void setNumberOfRepetitions(int number){
        this.numberOfRepetitions = number;
    }

    public int getNumberOfRepetitions(){
        return this.numberOfRepetitions;
    }
}
