package com.example.exercisebook;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "MeasurementDay")
public class MeasurementDay {
    @PrimaryKey(autoGenerate = true)
    private Integer Id;
    //lookup on user so we know whose measurement this is
    private Integer userId;
    @TypeConverters(RoomConverters.class)
    private Date date;

    public MeasurementDay(Integer userId, Date date) {
        this.userId = userId;
        this.date = date;
    }

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

    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
