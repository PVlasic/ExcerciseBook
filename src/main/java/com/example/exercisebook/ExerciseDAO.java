package com.example.exercisebook;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public abstract class ExerciseDAO {


    @Query("SELECT Id, dayId, name, numberOfSets, weight, repetitionsBySet FROM Exercise WHERE dayId=:dayId")
    abstract LiveData<List<Exercise>> getAllExercisesById(long dayId);

    @Insert
    abstract void insert(List<Exercise> exercises);

    @Delete
    abstract void delete(Exercise exercise);

    @Update
    abstract void update(List<Exercise> exercises);

    @Query("SELECT COUNT(Id) FROM Exercise")
    abstract LiveData<Integer> getExerciseCount();

    @Insert(onConflict = REPLACE)
    abstract long insert(ExerciseDay day);

    @Transaction
    public void InsertAllWithParent(ExerciseDay day, List<Exercise> exercises) {

        final long dayId = insert(day);

        //inserted exercises are not for insert anymore
        // Set companyId for all related employeeEntities
        for (Exercise exercise : exercises) {
            exercise.setDayId(dayId);
            Log.d("myTest", "exercise name DAO " + exercise.getName() + " dayId: " + exercise.getDayId());
        }

        insert(exercises);
    }


}
