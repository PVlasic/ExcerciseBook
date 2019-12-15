package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Excercise")
public class Excercise {
    @PrimaryKey(autoGenerate = true)
    int Id;

    //lookup on exercise day
    @ColumnInfo(name = "dayId")
    int dayId;

    @ColumnInfo(name = "exerciseName")
    String excerciseName;

    @ColumnInfo(name = "numberOfSets")
    int numberOfSets;

    @ColumnInfo(name = "wieght")
    int weight;

    public int getId(int id){
        return this.Id;
    }

    public void setParent(int dayId){
        this.dayId = dayId;
    }

    public int getParent(){
        return this.dayId;
    }

    public void setName(String name){
        this.excerciseName = name;
    }

    public String getName(){
        return this.excerciseName;
    }

    public void setNumberOfSets(int number){
        this.numberOfSets = number;
    }

    public int getNumberOfSets(){
        return this.numberOfSets;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }
}
