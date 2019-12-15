package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ExcerciseSet")
public class ExcerciseSet {
    @PrimaryKey
    int Id;

    @ColumnInfo(name = "excerciseId")
    int excerciseId;

    @ColumnInfo(name = "numberOfRepetitions")
    int numberOfRepetitions;

    public void setId(int id){
        this.Id = id;
    }
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
