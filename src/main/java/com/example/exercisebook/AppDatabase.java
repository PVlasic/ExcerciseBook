package com.example.exercisebook;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {User.class, ExerciseDay.class, MeasurementDay.class, Exercise.class, Measurement.class}, version = 1, exportSchema = false)
@TypeConverters(RoomConverters.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDAO userDao();
    public abstract ExerciseDayDAO exerciseDayDao();
    public abstract MeasurementDayDAO measurementDayDao();

    public static synchronized AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "exerciseBook-database")
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}