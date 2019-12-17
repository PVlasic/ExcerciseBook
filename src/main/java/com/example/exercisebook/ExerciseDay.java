package com.example.exercisebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.OffsetDateTime;

@Entity(tableName = "ExerciseDay")
public class ExerciseDay {
    @PrimaryKey(autoGenerate = true)
    private Integer Id;

    //lookup on user so we know which user had this exercise
    private Integer userId;
    //private OffsetDateTime dateTime;
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


//    public OffsetDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(OffsetDateTime dateTime) {
//        this.dateTime = dateTime;
//    }
}
