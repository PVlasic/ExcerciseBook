package com.example.exercisebook;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "MeasurementDay",
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "Id",
                childColumns = "userId",
                onDelete = CASCADE
        ),
        indices = @Index("userId"))
public class MeasurementDay {
    @PrimaryKey(autoGenerate = true)
    private long Id;
    //lookup on user so we know whose measurement this is
    private long userId;
    @TypeConverters(DateRoomConverter.class)
    private Date date;

    public MeasurementDay(long userId, Date date) {
        this.userId = userId;
        this.date = date;
    }

    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
