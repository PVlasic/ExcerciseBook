package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.OffsetDateTime;

@Entity(tableName = "ExerciseDay")
public class ExcerciseDay {
    @PrimaryKey(autoGenerate = true)
    int Id;

    //lookup on user so we know which user had this exercise
    @ColumnInfo(name = "userId")
    int userId;


    //Need to find out how to store dates in the Room
//    @ColumnInfo(name = "dateOfExcercise")
//    OffsetDateTime dateTime;

    public int getId(int id){
        return this.Id;
    }
    public void setParent(int userId){
        this.userId = userId;
    }

    public int getParentId(){
        return this.userId;
    }
}
