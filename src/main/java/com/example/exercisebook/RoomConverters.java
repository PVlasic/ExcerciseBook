package com.example.exercisebook;

import androidx.room.TypeConverter;
import java.util.Date;


public class RoomConverters {
    @TypeConverter
    public static Date toDate(Long dateLong){
        Date date = new Date();
        date.setTime(dateLong);
        return dateLong == null ? null: date;
    }

    @TypeConverter
    public static Long fromDate(Date date){

        return date == null ? null : date.getTime();
    }
}
