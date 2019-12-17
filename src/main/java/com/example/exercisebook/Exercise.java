package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.HashMap;

@Entity(tableName = "Exercise")
public class Exercise {
    @PrimaryKey(autoGenerate = true)
    Integer Id;

    Integer dayId;

    String excerciseName;
    Integer numberOfSets;
    Double weight;
    //public HashMap<Integer, Integer> repetitionsBySet;



    public Integer getId(Integer id){
        return this.Id;
    }

    public void setParent(Integer dayId){
        this.dayId = dayId;
    }

    public Integer getParent(){
        return this.dayId;
    }

    public void setName(String name){
        this.excerciseName = name;
    }

    public String getName(){
        return this.excerciseName;
    }

    public void setNumberOfSets(Integer number){
        this.numberOfSets = number;
    }

    public Integer getNumberOfSets(){
        return this.numberOfSets;
    }

    public void setWeight(Double weight){
        this.weight = weight;
    }

    public Double getWeight(){
        return this.weight;
    }
}
